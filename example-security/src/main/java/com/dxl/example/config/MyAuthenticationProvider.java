package com.dxl.example.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.core.GrantedAuthorityDefaults;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @Program MyAuthenticationProvider
 * @Description
 * @Author duxl
 * @Create 2019/1/2 14:42
 */
@Component
@Slf4j
public class MyAuthenticationProvider implements AuthenticationProvider {
	@Autowired
	UserDetailsService userDetailsService;

	private static List<GrantedAuthority> ROLE = new
			ArrayList<GrantedAuthority>() {{
				new GrantedAuthorityDefaults("ROLE_USER");
			}};

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		log.info("用户提交表单信息：用户名:{},密码:{}", authentication.getPrincipal(), authentication.getCredentials());
		UserDetails userDetails = userDetailsService.loadUserByUsername(authentication.getName());

		if (authentication.getCredentials().equals(userDetails.getPassword())) {
			return new UsernamePasswordAuthenticationToken(authentication.getPrincipal(), authentication.getCredentials(), userDetails.getAuthorities());
		}
		throw new BadCredentialsException("Username/Password does not match for " + authentication.getPrincipal());
	}

	@Override
	public boolean supports(Class<?> aClass) {
		return true;
	}
}
