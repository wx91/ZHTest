package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 所有jdbc的父类
 * 
 * @author THINK
 *
 */
public class BaseDao {

	/**
	 * 公共的增删改的方法
	 * 
	 * @param sql
	 * @param param
	 * @return 影响行数
	 */
	public static int execUpdateData(String sql, Object... param) {

		Connection connection = getConnection();
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(sql);
			if (param != null) {
				// 循环给sql语句中的占位符赋值
				for (int i = 1; i <= param.length; i++) {
					statement.setObject(i, param[i-1]);
				}
			}
			int row = statement.executeUpdate();
			return row;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeAll(null, statement, connection);
		}

		return 0;

	}

	/**
	 * 获取连接对象
	 * 
	 * @return 连接对象Connection
	 */
	public static Connection getConnection() {
		try {
			// 1.导入数据库驱动包（找对象的数据库厂商）
			// 2.加载驱动
			Class.forName("com.mysql.jdbc.Driver");

			// 3.获取连接对象
			String url = "jdbc:mysql://localhost:3306/store";
			String name = "root";
			String pwd = "000000";
			Connection connection = DriverManager.getConnection(url, name, pwd);

			return connection;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("连接异常.....");
			return null;
		}

	}

	/**
	 * 关闭
	 * 
	 * @param rs
	 * @param statm
	 * @param conn
	 */
	public static void closeAll(ResultSet rs, Statement statm, Connection conn) {

		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if (statm != null) {
			try {
				statm.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
