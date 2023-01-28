package carl.infr.repositoryimpl;

import carl.common.enums.RedisKey;
import carl.domain.user.aggregate.User;
import carl.domain.user.repository.UserRepository;
import carl.infr.converter.UserConverter;
import carl.infr.dao.ReplyDAO;
import carl.infr.dao.TopicDAO;
import carl.infr.dao.UserDAO;
import carl.infr.entity.ReplyDO;
import carl.infr.entity.TopicDO;
import carl.infr.entity.UserDO;
import carl.infr.gateway.RedisGateway;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;

/**..
 * @className: UserRepositoryImpl
 * @description: TODO
 * @author: Carl Tong
 * @date: 2022/4/6 16:40
 */
@Repository
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    private RedisGateway redisGateway;

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private TopicDAO topicDAO;

    @Autowired
    private ReplyDAO replyDAO;

    @Override
    public void register(User user) {
        userDAO.insert(UserConverter.toUserDO(user));
    }

    @Override
    public Optional<User> login(String account, String password) {
        // 先从缓存中取
        String userKey = RedisKey.USER_KEY.getName() + account;
        User user = redisGateway.get(userKey);
        // 没有的话再从数据库获取
        if (ObjectUtils.isEmpty(user)) {
            UserDO userDO = userDAO.login(account, password);
            if (ObjectUtils.isNotEmpty(userDO)) {
                user = UserConverter.toUser(userDO);
                redisGateway.set(userKey, user);
            }
        }
        return Optional.ofNullable(user);
    }

    @Override
    public User getUserInfo(Long userId) {
        CompletableFuture<Long> topicFuture = CompletableFuture.supplyAsync(() -> getUserTopicCount(userId));
        CompletableFuture<Long> replyFuture = CompletableFuture.supplyAsync(() -> getUserReplyCount(userId));
        // 这里可以考虑直接从缓存获取用户基本信息
        UserDO userDO = userDAO.selectById(userId);
        Long topicCount = null, replyCount = null;
        try {
            topicCount = topicFuture.get();
            replyCount = replyFuture.get();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return UserConverter.toUser(userDO, topicCount, replyCount);
    }

    Long getUserTopicCount(Long userId) {
        LambdaQueryWrapper<TopicDO> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(TopicDO::getUserId, userId);
        return topicDAO.selectCount(wrapper);
    }

    Long getUserReplyCount(Long userId) {
        LambdaQueryWrapper<ReplyDO> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(ReplyDO::getUserId, userId);
        return replyDAO.selectCount(wrapper);
    }

    @Override
    public void updateInfo(User user) {
        UserDO userDO = UserConverter.toUserDO(user);
        userDAO.updateById(userDO);
    }

}
