package by.ivankov.msvc.users.config;

import by.ivankov.msvc.users.security.AuthenticationFilter;
import by.ivankov.msvc.users.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author al.ivankov@outlook.com
 */
@RequiredArgsConstructor
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Value("${gateway.host}")
    private String gatewayHost;
    @Value("${token.expiration_time}")
    private Integer expirationTime;
    @Value("${token.secret}")
    private String secret;
    private final ApplicationContext applicationContext;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests()
                .antMatchers("/**").hasIpAddress(gatewayHost)
                .antMatchers(HttpMethod.GET, "/actuator/health").hasIpAddress(gatewayHost)
                .antMatchers(HttpMethod.GET, "/actuator/circuitbreakerevents").hasIpAddress(gatewayHost)
                .and().addFilter(getAuthenticationFilter());
        http.headers().frameOptions().disable();//H2 Console
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    private AuthenticationFilter getAuthenticationFilter() throws Exception {
        AuthenticationFilter filter = new AuthenticationFilter(applicationContext.getBean(UserService.class),
                expirationTime, secret);
        filter.setAuthenticationManager(authenticationManager());
        return filter;
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(applicationContext.getBean(UserService.class))
                .passwordEncoder(applicationContext.getBean(BCryptPasswordEncoder.class));
    }
}
