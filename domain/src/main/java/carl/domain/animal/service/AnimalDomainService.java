package carl.domain.animal.service;

import carl.domain.animal.aggregate.Species;
import carl.domain.animal.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @className: AnimalDomainService
 * @description: TODO
 * @author: Carl Tong
 * @date: 2022/4/6 16:55
 */
@Service
public class AnimalDomainService {

    @Autowired
    AnimalRepository animalRepository;

    public List<Species> getSpecies() {
        return animalRepository.getSpecies();
    }
}
