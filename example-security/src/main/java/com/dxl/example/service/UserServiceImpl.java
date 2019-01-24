package com.dxl.example.service;

import com.dxl.example.bean.MyUserPrincipal;
import com.dxl.example.bean.User;
import com.dxl.example.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @Program UserServiceImpll
 * @Description
 * @Author duxl
 * @Create 2019/1/3 14:44
 */
@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) {
		User user = userRepository.findByUserName(username);
		if(user == null){
			throw new UsernameNotFoundException(username);
		}
		return new MyUserPrincipal(user);
	}
}
