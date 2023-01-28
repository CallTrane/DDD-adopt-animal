package carl.infr.converter;

import carl.domain.user.aggregate.User;
import carl.infr.entity.UserDO;

/**
 * @className: UserConverter
 * @description: TODO
 * @author: Carl Tong
 * @date: 2022/4/6 16:46
 */
public class UserConverter {
    public static UserDO toUserDO(User user) {
        UserDO userDO = new UserDO();
        userDO.setId(user.getId());
        userDO.setName(user.getName());
        userDO.setGender(user.getGender());
        userDO.setEmail(user.getEmail());
        userDO.setAccount(user.getAccount());
        userDO.setPassword(user.getPassword());
        userDO.setPhone(user.getPhone());
        userDO.setIsDeleted(user.getIsDeleted());
        userDO.setAddTime(user.getAddTime());
        userDO.setUpdateTime(user.getUpdateTime());
        return userDO;
    }

    public static User toUser(UserDO userDO) {
        User user = new User();
        user.setId(userDO.getId());
        user.setName(userDO.getName());
        user.setGender(userDO.getGender());
        user.setEmail(userDO.getEmail());
        user.setAccount(userDO.getAccount());
        user.setPassword(userDO.getPassword());
        user.setPhone(userDO.getPhone());
        user.setIsDeleted(userDO.getIsDeleted());
        user.setAddTime(userDO.getAddTime());
        user.setUpdateTime(userDO.getUpdateTime());
        return user;
    }

    public static User toUser(UserDO userDO, Long topicCount, Long replyCount) {
        User user = new User();
        user.setId(userDO.getId());
        user.setName(userDO.getName());
        user.setGender(userDO.getGender());
        user.setEmail(userDO.getEmail());
        user.setAccount(userDO.getAccount());
        user.setPassword(userDO.getPassword());
        user.setPhone(userDO.getPhone());
        user.setIsDeleted(userDO.getIsDeleted());
        user.setAddTime(userDO.getAddTime());
        user.setUpdateTime(userDO.getUpdateTime());
        user.setTopicCount(topicCount);
        user.setReplyCount(replyCount);
        return user;
    }
}
