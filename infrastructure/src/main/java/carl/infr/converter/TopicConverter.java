package carl.infr.converter;

import carl.domain.communication.aggregate.Topic;
import carl.domain.communication.entity.TopicMO;
import carl.infr.entity.TopicDO;

/**
 * @className: TopicConverter
 * @description: TODO
 * @author: Carl Tong
 * @date: 2022/4/6 16:47
 */
public class TopicConverter {
    public static TopicDO toTopicDO(TopicMO topicMO, Long animalId) {
        TopicDO topicDO = new TopicDO();
        topicDO.setAnimalId(animalId);
        topicDO.setText(topicMO.getTopicText());
        topicDO.setName(topicMO.getTopicName());
        topicDO.setUserId(topicMO.getUserId());
        return topicDO;
    }

    public static Topic toTopic(TopicDO topicDO) {
        Topic topic = new Topic();
        topic.setId(topicDO.getId());
        topic.setAnimalId(topicDO.getAnimalId());
        topic.setUserId(topicDO.getUserId());
        topic.setName(topicDO.getName());
        topic.setText(topicDO.getText());
        topic.setAddTime(topicDO.getAddTime());
        topic.setIsDeleted(topicDO.getIsDeleted());
        return topic;
    }
}
