package carl.infr.dao;

import carl.AdoptAnimalApplicationTest;
import carl.infr.entity.SpeciesDO;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @className: SpeciesDAOTest
 * @description: TODO
 * @author: Carl Tong
 * @date: 2022/4/7 10:48
 */
public class SpeciesDAOTest extends AdoptAnimalApplicationTest {

    @Autowired
    SpeciesDAO speciesDAO;

    @Test
    public void test() {
        speciesDAO.test(List.of(new SpeciesDO("猫"), new SpeciesDO("狗")));
    }

    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add(new String("1"));
        String one = new String("1");
        System.out.println(set.contains(one));
    }
}
