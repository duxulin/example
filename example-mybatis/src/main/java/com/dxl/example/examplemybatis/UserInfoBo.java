package com.dxl.example.examplemybatis;

import java.io.Serializable;

/**
 * @Program UserInfoBo
 * @Description
 * @Author duxl
 * @Create 2018/11/9 14:23
 */
public class UserInfoBo implements Serializable {

	private Long id;
	private String user_name;
	private String phone;
	private String password;
	private String id_card;

	public UserInfoBo() {
	}

	public UserInfoBo(String user_name, String phone, String password, String id_card) {
		this.user_name = user_name;
		this.phone = phone;
		this.password = password;
		this.id_card = id_card;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getId_card() {
		return id_card;
	}

	public void setId_card(String id_card) {
		this.id_card = id_card;
	}

	@Override
	public String toString() {
		return "UserInfoBo{" +
				"id=" + id +
				", user_name='" + user_name + '\'' +
				", phone='" + phone + '\'' +
				", password='" + password + '\'' +
				", id_card='" + id_card + '\'' +
				'}';
	}
}
