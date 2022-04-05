package bu.ivankov.msvcusers.security;

import bu.ivankov.msvcusers.model.dto.UserDto;
import bu.ivankov.msvcusers.model.ui.LoginRequest;
import bu.ivankov.msvcusers.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

import static java.util.Collections.emptyList;

/**
 * @author al.ivankov
 */
@RequiredArgsConstructor
public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private final UserService userService;
    private final Integer expirationTime;
    private final String secret;

    @Override
    public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse resp) {
        try {
            LoginRequest login = new ObjectMapper().readValue(req.getInputStream(), LoginRequest.class);
            return getAuthenticationManager().authenticate(
                    new UsernamePasswordAuthenticationToken(login.getLogin(), login.getPassword(), emptyList()));
        } catch (IOException exc) {
            throw new RuntimeException(exc);
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest req, HttpServletResponse resp,
                                            FilterChain chain, Authentication auth) {
        String email = ((User) auth.getPrincipal()).getUsername();
        UserDto dto = userService.getUserByEmail(email);

        String token = Jwts.builder()
                .setSubject(dto.getUserId())
                .setExpiration(Date.from(Instant.now().plus(expirationTime, ChronoUnit.MILLIS)))
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();

        resp.addHeader("token", token);
        resp.setHeader("userId", dto.getUserId());
    }
}
