package carl.app.converter;

import carl.app.vo.AnimalVO;
import carl.domain.communication.entity.TopicUserAnimal;
import carl.infr.config.GlobalConfig;

/**
 * @className: AnimalConverter
 * @description: TODO
 * @author: Carl Tong
 * @date: 2022/4/6 16:44
 */
public class AnimalConverter {
    public static AnimalVO toAnimalVO(TopicUserAnimal topicAnimalEntity) {
        AnimalVO animalVO = new AnimalVO();
        animalVO.setAnimalId(topicAnimalEntity.getAnimalId());
        animalVO.setAnimalName(topicAnimalEntity.getAnimalName());
        animalVO.setAnimalGender(topicAnimalEntity.getAnimalGender());
        animalVO.setAnimalAddress(topicAnimalEntity.getAnimalAddress());
        animalVO.setSpeciesName(topicAnimalEntity.getSpeciesName());
        animalVO.setAnimalUpdateTime(GlobalConfig.getDateFormat().format(topicAnimalEntity.getAnimalUpdateTime()));
        return animalVO;
    }
}
