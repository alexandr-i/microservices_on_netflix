package by.ivankov.msvc.gateway.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @author al.ivankov@outlook.com
 */
@Slf4j
@Component
public class PreFilter implements GlobalFilter {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("My PreFilter-1");
        ServerHttpRequest req = exchange.getRequest();
        log.info("My PreFilter-1, PATH: {}", req.getPath());
        HttpHeaders headers = req.getHeaders();
        headers.keySet().forEach(key -> log.info("My PreFilter-1, HEADER: {}, VALUE: {}", key, headers.getFirst(key)));

        return chain.filter(exchange);
    }
}
