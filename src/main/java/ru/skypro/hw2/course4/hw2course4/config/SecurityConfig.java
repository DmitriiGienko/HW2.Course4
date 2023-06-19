package ru.skypro.hw2.course4.hw2course4.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AuthorizeHttpRequestsConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
@Configuration
public class SecurityConfig {

    @Bean
    public UserDetailsManager userDetailsManager(PasswordEncoder passwordEncoder) {
        UserDetails ivan = User.withUsername("Ivan")
                .password(passwordEncoder.encode("ivan123"))
                .roles("USER")
                .build();

        UserDetails vladimir = User.withUsername("Vladimir")
                .password(passwordEncoder.encode("vladimir123"))
                .roles("USER")
                .build();

        UserDetails admin = User.withUsername("admin")
                .password(passwordEncoder.encode("admin123"))
                .roles("USER", "ADMIN")
                .build();

        return new InMemoryUserDetailsManager(ivan, vladimir, admin);
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf()
                .disable()
                .authorizeHttpRequests(this::customizeRequest);
        // Цепочка фильтров безопасности для обработки входящих запросов,
        // основанная на настройках безопасности,
        // определенных с помощью метода 'customizeRequest'.

        return http.build();
    }

    private void customizeRequest(AuthorizeHttpRequestsConfigurer<HttpSecurity>.AuthorizationManagerRequestMatcherRegistry registry) throws Exception {
//        try {
            registry.requestMatchers(new AntPathRequestMatcher("/admin/**"))
                    .hasAnyRole("ADMIN")
                    // Определяем правило авторизации для запросов
                    // к URL, которые начинаются с "/admin/",
                    // позволяя доступ только пользователям с ролью "ADMIN".

                    .requestMatchers(new AntPathRequestMatcher("/**"))
                    .hasAnyRole("USER")

                    // Определяем правило авторизации для остальных запросов,
                    // позволяя доступ только пользователям с ролью "USER".

                    .and()
                    .formLogin().permitAll()
                    // Позволяем всем пользователям доступ к форме входа.

                    .and()
                    .logout().logoutUrl("/logout");
            // Настраиваем механизм выхода из системы
            // с заданием URL "/logout".

//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
        }
    }

}
