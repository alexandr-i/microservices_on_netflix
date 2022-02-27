package by.ivankov.msvcdiscovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author al.ivankov
 */
@SpringBootApplication
@EnableEurekaServer
public class MsvcDiscoveryApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsvcDiscoveryApplication.class, args);
    }

}
