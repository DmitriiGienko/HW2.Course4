package ru.skypro.hw2.course4.hw2course4.security;

import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public class SecurityUserPrincipal implements UserDetails {
    private AuthUser user;
    private List<SecurityGrantedAthorities> athoritiesList;

    public SecurityUserPrincipal(AuthUser user) {
        this.user
    }
}
