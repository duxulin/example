package com.dxl.example.jpa;

import com.dxl.example.jpa.bean.AccountInfo;
import com.dxl.example.jpa.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Program JpaTest
 * @Description
 * @Author duxl
 * @Create 2018/12/11 9:08
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class JpaTest {
	@Autowired
	private UserService userService;

	@Test
	public void a() {
		AccountInfo dxl = userService.createNewAccount("dxl", "123456", 1000);
		System.out.println(dxl);
	}
}
