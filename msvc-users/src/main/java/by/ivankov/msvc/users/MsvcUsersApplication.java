package by.ivankov.msvc.users;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author al.ivankov@outlook.com
 */
@SpringBootApplication
@EnableEurekaClient
public class MsvcUsersApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsvcUsersApplication.class, args);
    }

}
