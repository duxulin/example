package com.dxl.example.bean;

import lombok.Data;

import javax.persistence.*;

/**
 * @Program User
 * @Description
 * @Author duxl
 * @Create 2019/1/3 14:37
 */
@Entity
@Data
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column
	private String username;
	@Column
	private String password;
}
