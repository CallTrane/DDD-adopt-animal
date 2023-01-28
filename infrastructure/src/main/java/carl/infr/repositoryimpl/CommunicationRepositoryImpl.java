package carl.infr.repositoryimpl;

import carl.common.enums.RedisKey;
import carl.domain.communication.aggregate.Topic;
import carl.domain.communication.entity.ReplyMO;
import carl.domain.communication.entity.ReplyUser;
import carl.domain.communication.entity.TopicMO;
import carl.domain.communication.entity.TopicUserAnimal;
import carl.domain.communication.repository.CommunicationRepository;
import carl.infr.config.GlobalConfig;
import carl.infr.dao.ReplyDAO;
import carl.infr.dao.TopicDAO;
import carl.infr.gateway.RedisGateway;
import carl.infr.rabbitmq.RabbitMQSender;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import reactor.util.function.Tuple2;
import reactor.util.function.Tuples;

import java.util.List;

/**
 * @className: CommunicationRepositoryImpl
 * @description: TODO
 * @author: Carl Tong
 * @date: 2022/4/6 16:41
 */
@Repository
public class CommunicationRepositoryImpl implements CommunicationRepository {

    @Autowired
    TopicDAO topicDAO;

    @Autowired
    ReplyDAO replyDAO;

    @Autowired
    RedisGateway redisGateway;

    @Autowired
    RabbitMQSender rabbitMQSender;

    @Override
    public void publishTopic(TopicMO topicMO) {
        rabbitMQSender.publishTopic(topicMO);
    }

    @Override
    public void replyTopic(ReplyMO replyMO) {
        rabbitMQSender.replyTopic(replyMO);
    }

    @Override
    public Tuple2<List<Topic>, Long> getPageData(Integer pageIndex) {
        Page<Topic> page = PageHelper.startPage(pageIndex, GlobalConfig.PAGE_SIZE).doSelectPage(() -> topicDAO.getTopic());
        return Tuples.of(page.getResult(), page.getTotal());
    }

    @Override
    public List<ReplyUser> getRepliesByTopicId(Long topicId) {
        return replyDAO.getRepliesByTopicId(topicId);
    }

    @Override
    public TopicUserAnimal getTopicDetailInfo(Long topicId) {
        return topicDAO.getTopicDetailInfo(topicId);
    }

    @Override
    public List<Topic> search(String context) {
        return topicDAO.search(context);
    }

    @Override
    public List<Topic> topList() {
        // 先从缓存中尝试获取
        String topKey = RedisKey.TOP_TOPIC_KEY.getName();
        List<Topic> topicList = redisGateway.get(topKey);
        if (ObjectUtils.isEmpty(topicList)) {
            topicList = topicDAO.topList();
            redisGateway.set(topKey, topicList);
        }
        return topicList;
    }
}
