package ru.skypro.hw2.course4.hw2course4.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class SecurityUserPrincipal implements UserDetails {
    private String name;
    private String password;
    private List<SecurityGrantedAuthrities> authritiesList;

    public SecurityUserPrincipal(AuthUser user) {
        this.name = user.getUsername();
        this.password = user.getPassword();
        this.authritiesList = user.getAuthorityList().stream()
                .map(SecurityGrantedAuthrities::new)
                .toList();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return new ArrayList<>(authritiesList);
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return name;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
