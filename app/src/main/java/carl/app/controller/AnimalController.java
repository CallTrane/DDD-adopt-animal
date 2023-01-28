package carl.app.controller;

import carl.app.service.AnimalApplicationService;
import carl.domain.animal.aggregate.Species;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @className: AnimalController
 * @description: TODO
 * @author: Carl Tong
 * @date: 2022/4/1 20:41
 */
@RestController
@RequestMapping("/animal")
public class AnimalController {

    @Autowired
    AnimalApplicationService animalApplicationService;

    @GetMapping("/species")
    public List<Species> getSpecies() {
        return animalApplicationService.getSpecies();
    }

}
