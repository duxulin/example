package com.dxl.example.jpa.service;

import com.dxl.example.jpa.bean.AccountInfo;

public interface UserService {

	AccountInfo createNewAccount(String user, String pwd, Integer init);
}
