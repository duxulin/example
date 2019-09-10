package com.dxl.example.examplemybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @Program MybatisStart
 * @Description
 * @Author duxl
 * @Create 2018/11/9 13:46
 */
public class MybatisStart {


	public static void main(String[] args) {
		String source = "mybatis-config.xml";
		SqlSession sqlSession = null;
		SqlSession sqlSession1 = null;
		try {

			InputStream resourceAsStream = Resources.getResourceAsStream(source);
			SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
			sqlSession = build.openSession(true);
			sqlSession1 = build.openSession(true);
			UserInfoBo userInfo = new UserInfoBo("ccc", "123456", "18814864588", "3306.....");

            /*int insert = sqlSession.insert("com.dxl.example.examplemybatis.UserInfoMapper.save", userInfo);
            sqlSession.commit();*/
			//UserInfoMapper mapper = sqlSession.getMapper(UserInfoMapper.class);
			//int insert = mapper.save(userInfo);
			//System.out.println(insert ==1?true:false);
			//sqlSession.update("");
			UserInfoBo o = sqlSession.selectOne("com.dxl.example.examplemybatis.UserInfoMapper.selectById", 10);

			System.out.println(o);
			sqlSession.close();

			//int insert = sqlSession.insert("com.dxl.example.examplemybatis.UserInfoMapper.save", userInfo);

			UserInfoBo o1 = sqlSession1.selectOne("com.dxl.example.examplemybatis.UserInfoMapper.selectById", 10);
			System.out.println(o1);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}


	}
}
