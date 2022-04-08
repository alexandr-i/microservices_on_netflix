package by.ivankov.msvc.gateway.filter;

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @author al.ivankov@outlook.com
 */
@Component
public class AuthorizationHeaderFilter extends AbstractGatewayFilterFactory<AuthorizationHeaderFilter.Config> {

    @Value("${token.secret}")
    private String secret;

    public AuthorizationHeaderFilter() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain) -> {
            ServerHttpRequest req = exchange.getRequest();
            if (!req.getHeaders().containsKey(HttpHeaders.AUTHORIZATION)) {
                return onError(exchange, "No Authorization Header", HttpStatus.UNAUTHORIZED);
            }

            String authorization = req.getHeaders().get(HttpHeaders.AUTHORIZATION).get(0);
            String jwt = authorization.replace("Bearer", "");

            if (!isJwtValid(jwt)) {
                return onError(exchange, "JWT Not Valid", HttpStatus.UNAUTHORIZED);
            }

            return chain.filter(exchange);
        };
    }

    private boolean isJwtValid(String jwt) {
        try {
            String subject = Jwts.parser().setSigningKey(secret)
                    .parseClaimsJws(jwt)
                    .getBody()
                    .getSubject();
            return StringUtils.hasText(subject);
        } catch (JwtException exc) {
            return false;
        }
    }

    private Mono<Void> onError(ServerWebExchange exchange, String msg, HttpStatus status) {
        ServerHttpResponse resp = exchange.getResponse();
        resp.setStatusCode(status);
        return resp.setComplete();
    }


    public static class Config {

    }
}
