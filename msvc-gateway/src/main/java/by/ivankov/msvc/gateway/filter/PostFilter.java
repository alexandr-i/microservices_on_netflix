package by.ivankov.msvc.gateway.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.lang.annotation.Annotation;

/**
 * @author al.ivankov@outlook.com
 */
@Slf4j
@Component
public class PostFilter implements GlobalFilter, Order {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        return chain.filter(exchange).then(Mono.fromRunnable(() -> {
            log.info("My PostFilter-1");
            ServerHttpResponse resp = exchange.getResponse();
            HttpHeaders headers = resp.getHeaders();
            headers.keySet().forEach(key -> log.info("My PreFilter-1, HEADER: {}, VALUE: {}", key, headers.getFirst(key)));
        }));
    }

    @Override
    public int value() {
        return -1;
    }

    @Override
    public Class<? extends Annotation> annotationType() {
        return null;
    }
}
