package carl.infr.rabbitmq;

import carl.common.exception.BizException;
import carl.domain.communication.entity.ReplyMO;
import carl.domain.communication.entity.TopicMO;
import carl.infr.config.RabbitMQConfig;
import carl.infr.converter.AnimalConverter;
import carl.infr.converter.ReplyConverter;
import carl.infr.converter.TopicConverter;
import carl.infr.dao.AnimalDAO;
import carl.infr.dao.ReplyDAO;
import carl.infr.dao.TopicDAO;
import carl.infr.entity.AnimalDO;
import carl.infr.entity.ReplyDO;
import carl.infr.entity.TopicDO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @className: RabbitMQConsumer
 * @description: TODO
 * @author: Carl Tong
 * @date: 2022/4/13 18:51
 */
@Slf4j
@Service
public class RabbitMQConsumer {
    @Autowired
    AnimalDAO animalDAO;

    @Autowired
    TopicDAO topicDAO;

    @Autowired
    ReplyDAO replyDAO;

    @Transactional(rollbackFor = BizException.class)
    @RabbitListener(queues = RabbitMQConfig.PUBLISH_TOPIC_QUEUE)
    @RabbitHandler
    public void handlerPublishTopic(TopicMO topicMO) {
        AnimalDO animalDO = AnimalConverter.toAnimalDO(topicMO);

        // TODO: 业务逻辑的，这里可以做个监控和 try-catch
        // 1、先插入动物信息表
        animalDAO.insert(animalDO);
        // 2、根据返回的主键，再插入主题表
        TopicDO topicDO = TopicConverter.toTopicDO(topicMO, animalDO.getId());

        topicDAO.insert(topicDO);
    }

    @RabbitListener(queues = RabbitMQConfig.REPLY_TOPIC_QUEUE)
    @RabbitHandler
    public void handlerReplyTopic(ReplyMO replyMO) {
        ReplyDO replyDO = ReplyConverter.toReplyDO(replyMO);
        replyDAO.insert(replyDO);
    }
}
