package com.poi.hr.config;

import com.poi.hr.config.handler.AuthFailHandler;
import com.poi.hr.domain.vacation.enums.TeamPositionRole;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import java.util.Arrays;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private AuthFailHandler authFailHandler;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return web -> web.ignoring().requestMatchers(PathRequest.toStaticResources().atCommonLocations());
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests(auth -> auth
                .requestMatchers("/auth/login", "/auth/fail").permitAll()
                .requestMatchers("/").hasAnyAuthority(
                        Arrays.stream(TeamPositionRole.values())
                                .map(TeamPositionRole::name)
                                .toArray(String[]::new))
                .anyRequest().authenticated()

                // 직원 관리
                .requestMatchers("/author/**").hasAnyAuthority("CEO", "HR_LEADER", "HR_MEMBER", "DEPT_LEADER", "TEAM_LEADER")

                // 출퇴근 관리
                .requestMatchers("/attendanceList/**").hasAnyAuthority("CEO", "HR_LEADER")

                // 휴가 관리


    ).formLogin(login -> login
                .loginPage("/auth/login")
                .loginProcessingUrl("/login")
                .usernameParameter("employeeNumber")
                .passwordParameter("password")
                .defaultSuccessUrl("/", true)
                .failureUrl("/auth/fail")
                .failureHandler(authFailHandler)

    ).logout(logout -> logout
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .deleteCookies("JSESSIONID")
                .invalidateHttpSession(true)
                .logoutSuccessUrl("/auth/login")

    ).sessionManagement(session -> {
                session.maximumSessions(1);
                session.invalidSessionUrl("/");

    }).csrf(csrf -> csrf.disable());

    return http.build();
    }
}
