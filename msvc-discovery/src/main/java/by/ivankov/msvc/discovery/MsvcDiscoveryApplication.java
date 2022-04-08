package by.ivankov.msvc.discovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author al.ivankov@outlook.com
 */
@SpringBootApplication
@EnableEurekaServer
public class MsvcDiscoveryApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsvcDiscoveryApplication.class, args);
    }

}
