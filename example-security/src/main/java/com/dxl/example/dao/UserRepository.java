package com.dxl.example.dao;

import com.dxl.example.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * @Program UserRepository
 * @Description
 * @Author duxl
 * @Create 2019/1/3 14:40
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	User findByUserName(String username);
}
