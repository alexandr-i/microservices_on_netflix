package by.ivankov.msvc.albums;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author al.ivankov@outlook.com
 */
@SpringBootApplication
@EnableDiscoveryClient
public class MsvcAlbumApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsvcAlbumApplication.class, args);
    }

}
