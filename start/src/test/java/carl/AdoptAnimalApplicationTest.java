package carl;

import org.mockito.MockitoAnnotations;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @className: AdoptAnimalApplicationTest
 * @description: TODO
 * @author: Carl Tong
 * @date: 2022/4/7 10:46
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = AdoptAnimalApplication.class)
@WebAppConfiguration
@EnableWebMvc
@AutoConfigureMockMvc
public class AdoptAnimalApplicationTest {

    @Before
    public void setup() {
        // 初始化测试用例类中由Mockito的注解标注的所有模拟对象
        MockitoAnnotations.openMocks(this);
    }

}
