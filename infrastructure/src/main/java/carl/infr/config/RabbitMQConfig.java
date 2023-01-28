package carl.infr.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @className: RabbitMQConfig
 * @description: TODO
 * @author: Carl Tong
 * @date: 2022/4/13 10:22
 */
@Configuration
public class RabbitMQConfig {

    public static final String PUBLISH_TOPIC_QUEUE = "PUBLISH_TOPIC_QUEUE";
    public static final String PUBLISH_TOPIC_KEY = "PUBLISH_TOPIC_KEY";
    public static final String PUBLISH_TOPIC_EXCHANGE = "PUBLISH_TOPIC_EXCHANGE";

    public static final String REPLY_TOPIC_QUEUE = "REPLY_TOPIC_QUEUE";
    public static final String REPLY_TOPIC_KEY = "REPLY_TOPIC_KEY";
    public static final String REPLY_TOPIC_EXCHANGE = "REPLY_TOPIC_EXCHANGE";


    /**
     * 队列
     *
     * @return
     */
    @Bean
    public Queue publishTopicQueue() {
        // 名字 持久化
        return new Queue(PUBLISH_TOPIC_QUEUE, true);
    }

    @Bean
    public Queue replyToicQueue() {
        // 名字 持久化
        return new Queue(REPLY_TOPIC_QUEUE, true);
    }

    /**
     * 直连交换机
     *
     * @return
     */
    @Bean
    public DirectExchange publishTopicExchange() {
        return new DirectExchange(PUBLISH_TOPIC_EXCHANGE, true, false);
    }

    @Bean
    public DirectExchange replyTopicExchange() {
        return new DirectExchange(REPLY_TOPIC_EXCHANGE, true, false);
    }

    @Bean
    public Binding publishTopicBinding() {
        return BindingBuilder.bind(publishTopicQueue()).to(publishTopicExchange()).with(PUBLISH_TOPIC_KEY);
    }

    @Bean
    public Binding replyTopicBinding() {
        return BindingBuilder.bind(replyToicQueue()).to(replyTopicExchange()).with(REPLY_TOPIC_KEY);
    }

}
