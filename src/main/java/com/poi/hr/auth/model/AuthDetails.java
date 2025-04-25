package com.poi.hr.auth.model;

import com.poi.hr.dto.LoginEmployeeDto;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

public class AuthDetails implements UserDetails {

    private LoginEmployeeDto loginEmployeeDto;

    public AuthDetails() {
    }

    public AuthDetails(LoginEmployeeDto loginEmployeeDto) {
        this.loginEmployeeDto = loginEmployeeDto;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> authorities = new ArrayList<>();

        loginEmployeeDto.getRoles().forEach(role -> authorities.add(() -> role));
        return authorities;
    }

    @Override
    public String getUsername() {
        return loginEmployeeDto.getEmployeeNumber();
    }

    @Override
    public String getPassword() {
        return loginEmployeeDto.getPassword();
    }

    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }
}
