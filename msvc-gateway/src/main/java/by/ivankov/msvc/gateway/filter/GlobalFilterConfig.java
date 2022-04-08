package by.ivankov.msvc.gateway.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import reactor.core.publisher.Mono;

/**
 * @author al.ivankov@outlook.com
 */
@Slf4j
@Configuration
public class GlobalFilterConfig {

    @Bean
    @Order(1)
    public GlobalFilter secondGlobalFilter() {
        return ((exchange, chain) -> {
            log.info("My Second Filter");
            return chain.filter(exchange).then(Mono.fromRunnable(() -> log.info("My Second PostFilter")));
        });
    }

    @Bean
    @Order(2)
    public GlobalFilter thirdGlobalFilter() {
        return ((exchange, chain) -> {
            log.info("My third Filter");
            return chain.filter(exchange).then(Mono.fromRunnable(() -> log.info("My third PostFilter")));
        });
    }

    @Bean
    @Order(3)
    public GlobalFilter forthGlobalFilter() {
        return ((exchange, chain) -> {
            log.info("My forth Filter");
            return chain.filter(exchange).then(Mono.fromRunnable(() -> log.info("My forth PostFilter")));
        });
    }
}
