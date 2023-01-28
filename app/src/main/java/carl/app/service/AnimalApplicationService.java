package carl.app.service;

import carl.domain.animal.aggregate.Species;
import carl.domain.animal.service.AnimalDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @className: AnimalApplicationService
 * @description: TODO
 * @author: Carl Tong
 * @date: 2022/4/6 16:35
 */
@Service
public class AnimalApplicationService {

    @Autowired
    AnimalDomainService animalDomainService;


    public List<Species> getSpecies() {
        return animalDomainService.getSpecies();
    }
}
