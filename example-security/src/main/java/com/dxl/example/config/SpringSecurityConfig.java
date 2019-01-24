package com.dxl.example.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @Program SpringSecurityConfig
 * @Description
 * @Author duxl
 * @Create 2019/1/2 13:39
 */
@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	MyAuthenticationProvider myAuthenticationProvider;
	@Override
	protected void configure(HttpSecurity http) throws Exception {
//		super.configure(http);
//
//		http
//				.authorizeRequests()
//				.anyRequest().authenticated()
//				.and()
//				.formLogin()
//				.loginPage("/login")
//				.permitAll();
		http.formLogin()
				.loginPage("/login")
				.loginProcessingUrl("/authentication/login")
				.failureUrl("/login?error")
				.defaultSuccessUrl("/helloadmin")
				.and()
				.authorizeRequests()
				.antMatchers("/login").permitAll()
				.anyRequest()
				.authenticated()
				.and()
				.csrf().disable();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(myAuthenticationProvider);
	}
}
