package bu.ivankov.msvcusers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author al.ivankov
 */
@SpringBootApplication
@EnableEurekaClient
public class MsvcUsersApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsvcUsersApplication.class, args);
    }

}
