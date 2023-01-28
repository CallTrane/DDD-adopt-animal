package carl;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableAsync
@EnableTransactionManagement
@MapperScan("carl.infr.dao")
public class AdoptAnimalApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdoptAnimalApplication.class, args);
    }

}
