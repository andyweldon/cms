package com.dineshkrish.cms.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SecurityConfig  {

    @Bean
    public InMemoryUserDetailsManager userDetailsService() {

        UserDetails user1 = User.withDefaultPasswordEncoder()
                .username("myuser1")
                .password("password")
                .roles("USER")
                .build();

        UserDetails user2 = User.withDefaultPasswordEncoder()
                .username("myuser2")
                .password("password")
                .roles("USER", "ADMIN")
                .build();

        return new InMemoryUserDetailsManager(user1, user2);
    }

}
