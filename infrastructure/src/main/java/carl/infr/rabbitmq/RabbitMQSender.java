package carl.infr.rabbitmq;

import carl.domain.communication.entity.ReplyMO;
import carl.domain.communication.entity.TopicMO;
import carl.infr.config.RabbitMQConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @className: RabbitMQSender
 * @description: TODO
 * @author: Carl Tong
 * @date: 2022/4/13 18:50
 */
@Service
public class RabbitMQSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void publishTopic(TopicMO topicMO) {
        rabbitTemplate.convertAndSend(RabbitMQConfig.PUBLISH_TOPIC_EXCHANGE, RabbitMQConfig.PUBLISH_TOPIC_KEY, topicMO);
    }

    public void replyTopic(ReplyMO replyMO) {
        rabbitTemplate.convertAndSend(RabbitMQConfig.REPLY_TOPIC_EXCHANGE, RabbitMQConfig.REPLY_TOPIC_KEY, replyMO);
    }
}
