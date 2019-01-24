package com.dxl.example.service;

import org.springframework.security.core.userdetails.UserDetails;

public interface IUserService {

	UserDetails loadUserByUsername(String username);
}
