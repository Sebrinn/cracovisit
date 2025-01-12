package com.cracovisit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.authentication.PasswordEncoderParser;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.cracovisit.services.UserServiceInterface;

@Configuration
@EnableWebSecurity
public class SecurityConfig {


	@Autowired
	UserServiceInterface service;

    @Bean
    UserDetailsService userDetailsService()
	{
		return service;
	}
	
    @Bean
    AuthenticationProvider authenticationProvider()
    {
    	DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
    	provider.setUserDetailsService(service);
    	provider.setPasswordEncoder(passwordEncoder());
    	return provider;
    }
    
    public static String getLoggedInUsername() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated()) {
            Object principal = authentication.getPrincipal();
            if (principal instanceof UserDetails) {
                return ((UserDetails) principal).getUsername();
            } else {
                return principal.toString();
            }
        }
        return null;
    }
    
    @Bean
    PasswordEncoder passwordEncoder()
    {
    	return new BCryptPasswordEncoder();
    }
    
    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
        	.csrf(AbstractHttpConfigurer::disable)
        	.authorizeHttpRequests(request -> request
                .requestMatchers("/login").permitAll()
                .requestMatchers("/attractions").permitAll()
                .requestMatchers("/attractions/details").permitAll()
                .requestMatchers("/attractions/search").permitAll()
                .requestMatchers("/req/signup").permitAll()
                .requestMatchers("/feedbacks").permitAll()
                .requestMatchers("/req/signup/admit").permitAll()
                .requestMatchers("/css/**").permitAll()
                .requestMatchers("/js/**").permitAll()
                .requestMatchers("/img/**").permitAll()
                .anyRequest().authenticated()
            )
        	.formLogin(form -> form
        			.loginPage("/login")
        			.defaultSuccessUrl("/attractions", true)
        	)
        	.logout(config -> config.logoutSuccessUrl("/attractions"))
            .build();
    }

}
