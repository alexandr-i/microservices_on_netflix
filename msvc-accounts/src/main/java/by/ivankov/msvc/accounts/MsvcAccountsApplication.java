package by.ivankov.msvc.accounts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author al.ivankov@outlook.com
 */
@SpringBootApplication
@EnableEurekaClient
public class MsvcAccountsApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsvcAccountsApplication.class, args);
    }

}
