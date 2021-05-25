package com.example.HospitalSystem.config;

import com.example.HospitalSystem.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserService userService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST,"/login/**").permitAll()

//                .antMatchers(HttpMethod.GET,"/users/**").hasAuthority("ADMIN")
//                .antMatchers(HttpMethod.POST,"/users/**").hasAuthority("ADMIN")
//                .antMatchers(HttpMethod.PUT,"/users/**").hasAuthority("ADMIN")
//                .antMatchers(HttpMethod.PATCH,"/users/**").hasAuthority("ADMIN")
//                .antMatchers(HttpMethod.DELETE,"/users/**").hasAuthority("ADMIN")
//
//                .antMatchers(HttpMethod.GET,"/diagnosis/**").hasAuthority("DOCTOR")
//                .antMatchers(HttpMethod.POST,"/diagnosis/**").hasAuthority("DOCTOR")
//                .antMatchers(HttpMethod.PUT,"/diagnosis/**").hasAuthority("DOCTOR")
//                .antMatchers(HttpMethod.PATCH,"/diagnosis/**").hasAuthority("DOCTOR")
//                .antMatchers(HttpMethod.DELETE,"/diagnosis/**").hasAuthority("DOCTOR")

                //.anyRequest().authenticated()
                .anyRequest().permitAll()
                .and()
                .addFilter(new JwtTokenGeneratorFilter(authenticationManager()))
                .addFilterAfter(new JwtTokenAuthenticationFilter(),
                        UsernamePasswordAuthenticationFilter.class)
        ;
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService)
                .passwordEncoder(passwordEncoder());
    }
}
