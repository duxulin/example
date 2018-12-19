package com.dxl.example.examplemybatis;

import com.mysql.jdbc.ConnectionImpl;
import org.springframework.jdbc.datasource.ConnectionProxy;

import java.sql.*;
import java.util.Date;

/**
 * @Program JDBCUtil
 * @Description
 * @Author duxl
 * @Create 2018/11/12 9:04
 */
public class JDBCUtil {

	private static Connection connection;
	private static String url = "jdbc:mysql://localhost:3306/xjkd-test";
	private static String userName = "root";
	private static String password = "123456";

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		try {
			connection = DriverManager.getConnection(url, userName, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}

	public static void closeResource(Connection connection, Statement statement, ResultSet resultSet) {
		try {

			if (statement != null) {
				statement.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if (resultSet != null) {
				resultSet.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}


	public static void jdbcTest() {
		String sql = "select * from back_log where id < ?";
		Connection connection = getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			//preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, 4);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				int id = resultSet.getInt(1);
				int userId = resultSet.getInt(2);
				String logType = resultSet.getString(3);
				String userLog = resultSet.getString(4);
				Timestamp addTime = resultSet.getTimestamp(5);
				Date updateTime = resultSet.getDate(6);
				System.out.println("id=" + id + "; userid=" + userId + "; logType=" + logType +
						"; userLog=" + userLog + "; addTime=" + addTime + "; updateTime=" + updateTime);


			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResource(connection, preparedStatement, resultSet);
		}

	}

	public static void main(String[] args) {
		//jdbcTest();
		System.out.println(Connection.class.isAssignableFrom(ConnectionImpl.class));
	}


}
