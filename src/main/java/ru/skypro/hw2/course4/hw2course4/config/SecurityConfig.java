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

    // Создаем бин для хранения пользователей в памяти приложения
    @Bean
    public UserDetailsManager userDetailsManager(PasswordEncoder passwordEncoder) {

        // Создаем пользователя Ivan с ролью USER
        UserDetails ivan = User.withUsername("Ivan")
                .password(passwordEncoder.encode("ivan1234"))
                .roles("USER")
                .build();

        // Создаем пользователя Vladimir с ролью USER
        UserDetails vladimir = User.withUsername("Vladimir")
                .password(passwordEncoder.encode("vladimir1234"))
                .roles("USER")
                .build();

        // Создаем пользователя admin с ролью ADMIN
        UserDetails admin = User.withUsername("admin")
                .password(passwordEncoder.encode("admin1234"))
                .roles("USER","ADMIN")
                .build();

        // Возвращаем новый сервис управления InMemoryUserDetailsManager
        // с добавленными пользователями (Ivan, Vladimir, admin)
        return new InMemoryUserDetailsManager(ivan, vladimir, admin);
    }

    // Создаем бин кодировщика паролей (для хеширования паролей пользователей)
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}