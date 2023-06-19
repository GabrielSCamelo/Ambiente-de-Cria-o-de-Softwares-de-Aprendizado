package Modelo;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configurers.ExceptionHandlingConfigurer;

@Configuration
@EnableWebSecurity
public class ConfigSecurity extends WebSecurityConfiguration {

    protected void configure(HttpSecurity http) throws Exception {
        ExceptionHandlingConfigurer<HttpSecurity> accessDeniedPage = http
            .authorizeRequests()
                .requestMatchers("/", "/signup").permitAll()
                .requestMatchers("/admin/**").hasRole("ADMIN")
                .requestMatchers("/user/**").hasRole("USER")
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/dashboard")
                .permitAll()
                .and()
            .logout()
                .permitAll()
                .and()
            .exceptionHandling()
                .accessDeniedPage("/access-denied");
    }

    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
            .inMemoryAuthentication()
                .withUser("Root")
                .password("{Root}password")
                .roles("ADMIN");
    }
}
