package com.dymitrmisiejuk.kozliki.role.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;


@EnableWebSecurity

public class UserSecurity extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

    @Autowired
    private JdbcTemplate jdbcTemplate;


//    @Override
//    @Autowired
//    protected void configure(HttpSecurity http) throws Exception {
//        http.httpBasic().and().authorizeRequests()
//                .antMatchers("/reservations")
//                .hasAnyAuthority("ROLE_ADMIN", "ROLE_USER")
//                .anyRequest().permitAll()
//                .and().csrf().disable()
//                .headers().frameOptions().disable()
//                .and().formLogin()
//                .loginPage("/login")
//                .usernameParameter("login")
//                .passwordParameter("password")
//                .defaultSuccessUrl("/reservations")
//                .loginProcessingUrl("/login-process")
//                .and()
//                .logout().logoutSuccessUrl("/login");
//    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic().and().authorizeRequests()
                .antMatchers(HttpMethod.GET, "/reservations")
                .hasAnyAuthority("ROLE_ADMIN", "ROLE_USER")
                .antMatchers(HttpMethod.POST, "/reservations")
                .hasAnyAuthority("ROLE_ADMIN", "ROLE_USER")
                .antMatchers(HttpMethod.POST, "/reservations/update/**")
                .hasAnyAuthority("ROLE_ADMIN")
                .antMatchers(HttpMethod.POST, "/reservations/delete/**")
                .hasAnyAuthority("ROLE_ADMIN")
                .and().csrf().disable()
                .headers().frameOptions().disable()
                .and().formLogin()
                .loginPage("/login")
                .failureUrl("/login-error.html")
                .usernameParameter("login")
                .passwordParameter("password")
                .defaultSuccessUrl("/reservations")
                .loginProcessingUrl("/login-process")
                .and()
                .logout().logoutSuccessUrl("/login");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .usersByUsernameQuery("select u.login, u.password, 1 from user u where u.login=?")
                .authoritiesByUsernameQuery("select u.login, u.role, 1 from user u where u.login=?")
                .dataSource(jdbcTemplate.getDataSource())
                .passwordEncoder(passwordEncoder);

    }
}
