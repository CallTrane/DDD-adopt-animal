package carl.infr.converter;

import carl.domain.animal.aggregate.Species;
import carl.domain.communication.entity.TopicMO;
import carl.infr.entity.AnimalDO;
import carl.infr.entity.SpeciesDO;

/**
 * @className: AnimalConverter
 * @description: TODO
 * @author: Carl Tong
 * @date: 2022/4/6 16:44
 */
public class AnimalConverter {
    public static AnimalDO toAnimalDO(TopicMO topicMO) {
        AnimalDO animalDO = new AnimalDO();
        animalDO.setName(topicMO.getAnimalName());
        animalDO.setSpeciesId(topicMO.getSpeciesId());
        animalDO.setAddress(topicMO.getAnimalAddress());
        animalDO.setGender(topicMO.getAnimalGender());
        return animalDO;
    }

    public static Species toSpecies(SpeciesDO speciesDO) {
        Species species = new Species();
        species.setId(speciesDO.getId());
        species.setName(speciesDO.getName());
        return species;
    }
}
