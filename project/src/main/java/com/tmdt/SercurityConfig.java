package com.tmdt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.RequestMatcher;

import com.tmdt.service.CustomUserDetailService;

import jakarta.security.auth.message.callback.PrivateKeyCallback.Request;

@Configuration
@EnableWebSecurity
public class SercurityConfig {

	@Autowired
	private CustomUserDetailService customUserDetailService;
	
	@Bean 
	BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
	
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
		http.csrf(csrf -> csrf.disable()).authorizeHttpRequests((auth)->auth.
				requestMatchers("/*").permitAll().
				requestMatchers("/admin/**")
				.hasAuthority("ADMIN").
				anyRequest().authenticated())

		.formLogin(login->login.loginPage("/logon").loginProcessingUrl("/logon")
						.usernameParameter("username").passwordParameter("password").defaultSuccessUrl("/admin/",true)).
						logout(logout->logout.logoutUrl("/admin-logout").logoutSuccessUrl("/logon"));
				
				
		return http.build();
		
}


	
	@Bean
	WebSecurityCustomizer webSecurityCustomizer() {
		return (web)->web.ignoring().requestMatchers("/static/**","/fe/**","assets/**","/upload/**");
	}
}
