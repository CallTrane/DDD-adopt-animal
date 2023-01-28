package carl.infr.repositoryimpl;

import carl.domain.animal.aggregate.Species;
import carl.domain.animal.repository.AnimalRepository;
import carl.infr.converter.AnimalConverter;
import carl.infr.dao.AnimalDAO;
import carl.infr.dao.SpeciesDAO;
import carl.infr.entity.SpeciesDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @className: AnimalRepositoryImpl
 * @description: TODO
 * @author: Carl Tong
 * @date: 2022/4/6 16:41
 */
@Repository
public class AnimalRepositoryImpl implements AnimalRepository {

    @Autowired
    AnimalDAO animalDAO;

    @Autowired
    SpeciesDAO speciesDAO;

    protected static List<Species> SPECIES;

    @Override
    public List<Species> getSpecies() {
        return SPECIES;
    }


    @PostConstruct
    private void initializationSpecies() {
        List<SpeciesDO> speciesDOs = speciesDAO.selectList(null);
        SPECIES = speciesDOs.stream().map(AnimalConverter::toSpecies).collect(Collectors.toList());
    }
}
