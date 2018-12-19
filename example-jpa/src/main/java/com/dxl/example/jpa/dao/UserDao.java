package com.dxl.example.jpa.dao;

import com.dxl.example.jpa.bean.AccountInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<AccountInfo, Long> {


}
