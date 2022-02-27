package by.ivankov.msvcaccounts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author al.ivankov
 */
@SpringBootApplication
@EnableEurekaClient
public class MsvcAccountsApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsvcAccountsApplication.class, args);
    }

}
