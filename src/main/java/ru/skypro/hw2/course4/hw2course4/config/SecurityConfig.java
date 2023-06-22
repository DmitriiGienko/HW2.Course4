package ru.skypro.hw2.course4.hw2course4.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;

@EnableWebSecurity
@Configuration
public class SecurityConfig {
    @Bean
    public UserDetailsManager userDetailsManager(PasswordEncoder passwordEncoder) {
        UserDetails ivan = User.withUsername("Ivan")
                .password(passwordEncoder.encode("ivan1234"))
                .roles("USER")
                .build();

        UserDetails vladimir = User.withUsername("Vladimir")
                .password(passwordEncoder.encode("vladimir1234"))
                .roles("USER")
                .build();

        UserDetails admin = User.withUsername("admin")
                .password(passwordEncoder.encode("admin1234"))
                .roles("USER", "ADMIN")
                .build();


        return new InMemoryUserDetailsManager(ivan, vladimir, admin);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


}
