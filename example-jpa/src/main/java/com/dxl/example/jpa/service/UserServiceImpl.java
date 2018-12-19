package com.dxl.example.jpa.service;

import com.dxl.example.jpa.bean.AccountInfo;
import com.dxl.example.jpa.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.stereotype.Service;

/**
 * @Program UserServiceImpl
 * @Description
 * @Author duxl
 * @Create 2018/12/11 8:55
 */
@Service("userService")
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;

	@Override
	public AccountInfo createNewAccount(String user, String pwd, Integer init) {
		AccountInfo accountInfo = new AccountInfo();
		accountInfo.setBalance(init);
		accountInfo.setName(user);
		accountInfo.setPwd(pwd);
		AccountInfo save = userDao.save(accountInfo);
		return save;
	}
}
