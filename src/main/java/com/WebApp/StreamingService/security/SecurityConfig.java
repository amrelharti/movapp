package com.WebApp.StreamingService.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfig {
    @Bean
    BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
   public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
       httpSecurity
               .formLogin(Customizer.withDefaults())
               .httpBasic(Customizer.withDefaults());
       return httpSecurity.build();
   }
   @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager(){
        return new InMemoryUserDetailsManager(
                User.withUsername("admin").password(bCryptPasswordEncoder().encode("123")).roles("ADMIN","USER").build(),
                User.withUsername("user").password(bCryptPasswordEncoder().encode("123")).roles("USER").build()
                );
   }
}
