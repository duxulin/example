package com.dxl.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.provider.approval.InMemoryApprovalStore;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Program WebSceurityConfig
 * @Description
 * @Author duxl
 * @Create 2019/1/3 8:46
 */
@EnableWebSecurity
public class WebSceurityConfig implements WebMvcConfigurer {
	@Bean
	public UserDetailsService userDetailsService(){
		InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
		manager.createUser(User.withUsername("duxulin").password("123456").roles("USER").build());
		return manager;
	}

}
