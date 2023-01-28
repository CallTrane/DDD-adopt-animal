package carl.domain.animal.repository;

import carl.domain.animal.aggregate.Species;

import java.util.List;

/**
 * @className: AnimalRepository
 * @description: TODO
 * @author: Carl Tong
 * @date: 2022/4/6 16:34
 */
public interface AnimalRepository {
    List<Species> getSpecies();
}
