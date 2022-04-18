package by.ivankov.msvc.users;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author al.ivankov@outlook.com
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class MsvcUsersApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsvcUsersApplication.class, args);
    }

}
