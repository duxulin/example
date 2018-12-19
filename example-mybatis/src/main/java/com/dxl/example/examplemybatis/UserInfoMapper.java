package com.dxl.example.examplemybatis;

public interface UserInfoMapper {


	int save(UserInfoBo user);

	UserInfoBo selectById(int id);


}
