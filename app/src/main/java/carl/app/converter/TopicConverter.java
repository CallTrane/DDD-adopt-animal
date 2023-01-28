package carl.app.converter;

import carl.app.dto.TopicPublishDTO;
import carl.app.vo.TopicVO;
import carl.domain.communication.aggregate.Topic;
import carl.domain.communication.entity.TopicMO;
import carl.domain.communication.entity.TopicUserAnimal;

/**
 * @className: TopicConverter
 * @description: TODO
 * @author: Carl Tong
 * @date: 2022/4/6 16:47
 */
public class TopicConverter {
    public static TopicMO toTopicMO(TopicPublishDTO topicPublishDTO) {
        TopicMO topicMO = new TopicMO();
        topicMO.setUserId(topicPublishDTO.getUserId());
        topicMO.setTopicText(topicPublishDTO.getTopicText());
        topicMO.setTopicName(topicPublishDTO.getTopicName());
        topicMO.setAnimalName(topicPublishDTO.getAnimalName());
        topicMO.setAnimalGender(topicPublishDTO.getAnimalGender());
        topicMO.setSpeciesId(topicPublishDTO.getSpeciesId());
        topicMO.setAnimalAddress(topicPublishDTO.getAnimalAddress());
        return topicMO;
    }

    public static TopicVO toTopicVO(Topic topic) {
        TopicVO topicVO = new TopicVO();
        topicVO.setUserId(topic.getUserId());
        topicVO.setUserName(topic.getUserName());
        topicVO.setTopicId(topic.getId());
        topicVO.setTopicName(topic.getName());
        topicVO.setTopicText(topic.getText());
        return topicVO;
    }

    public static TopicVO toTopicVO(TopicUserAnimal topicAnimalEntity) {
        TopicVO topicVO = new TopicVO();
        topicVO.setTopicId(topicAnimalEntity.getTopicId());
        topicVO.setTopicName(topicAnimalEntity.getTopicName());
        topicVO.setTopicText(topicAnimalEntity.getTopicText());
        topicVO.setUserId(topicAnimalEntity.getUserId());
        topicVO.setUserName(topicAnimalEntity.getUserName());
        return topicVO;
    }
}
