package by.ivankov.msvc.accounts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author al.ivankov@outlook.com
 */
@SpringBootApplication
@EnableDiscoveryClient
public class MsvcAccountsApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsvcAccountsApplication.class, args);
    }

}
