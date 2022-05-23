package com.epam.bookingsystem.security.config;

import com.epam.bookingsystem.security.filter.AuthenticateTokenFilter;
import com.epam.bookingsystem.services.impl.UserDetailsServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Slf4j
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserDetailsService userDetailsService;
    private final AuthenticationEntryPoint unauthorizedHandler;
    private final AccessDeniedHandler accessDeniedHandler;

    public WebSecurityConfig(UserDetailsServiceImpl userDetailsService,
                             AuthenticationEntryPoint unauthorizedHandler,
                             AccessDeniedHandler accessDeniedHandler) {
        this.userDetailsService = userDetailsService;
        this.unauthorizedHandler = unauthorizedHandler;
        this.accessDeniedHandler = accessDeniedHandler;
    }


    @Override
    public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.cors().and().csrf().disable()
                .exceptionHandling().accessDeniedHandler(accessDeniedHandler)
                .authenticationEntryPoint(unauthorizedHandler).and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .authorizeRequests()
                .antMatchers("/auth/logout").authenticated()
                .antMatchers("/auth/refresh-token").authenticated()
                .antMatchers("/auth/reset-password").authenticated()
                .antMatchers("/auth/**").permitAll()
                .antMatchers("/signup/moderator").hasRole("ADMIN")
                .antMatchers("/signup/**").permitAll()
                //
                .antMatchers("/test/user").hasAnyRole("USER", "MODERATOR", "ADMIN")
                .antMatchers("/test/hotel_manager").hasAnyRole("HOTEL_MANAGER", "MODERATOR", "ADMIN")
                .antMatchers("/test/moderator").hasAnyRole("MODERATOR", "ADMIN")
                .antMatchers("/test/admin").hasRole("ADMIN")
                .antMatchers("/test/**").permitAll()
                .antMatchers("/resort-register-requests/all").hasAnyRole("MODERATOR", "ADMIN")
                // todo to be removed
                .antMatchers("/resort-register-requests/test").permitAll()
                .anyRequest().authenticated();
        http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
    }


    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public AuthenticateTokenFilter authenticationJwtTokenFilter() {
        return new AuthenticateTokenFilter();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
