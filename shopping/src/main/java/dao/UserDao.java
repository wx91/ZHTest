package dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.User;

public class UserDao extends BaseDao {
	
	/**
	 * 校验用户名是否存在
	 * @param name
	 * @return
	 */
	public static int checkName(String name){
		
		Connection conn = getConnection();
		PreparedStatement statement=null;
		ResultSet rs=null;
		String sql="select count(1) cnts from user where username=?";
		try {
			statement = conn.prepareStatement(sql);
			statement.setString(1, name);
			 rs = statement.executeQuery();
			 if(rs.next())
			 {
				 int row = rs.getInt("cnts");
				 return row;
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeAll(rs, statement, conn);
		}
		
		return 0;
	}
	/**
	 * 用户注册
	 * @param user
	 * @return
	 */
	public static boolean register(bean.User user) {
		
		String sql="insert into user (uid,username,password,name,email,birthday,sex) values (?,?,?,?,?,?,?)";
		int row = execUpdateData(sql, user.getUid(),user.getUsername(),user.getPassword(),user.getName(),user.getEmail(),user.getBirthday(),user.getSex());
		return row>0 ;
	}
	public static int LogIn(String username, String md5password) {
		Connection conn = getConnection();
		PreparedStatement statement=null;
		ResultSet rs=null;
		String sql="SELECT count(1) from user where username='?' and password='?'";
		try {
			statement = conn.prepareStatement(sql);
			statement.setString(1, username);
			statement.setString(2, md5password);
			 rs = statement.executeQuery();
			 if(rs.next())
			 {
				 int row = rs.getInt("cnts");
				 return row;
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeAll(rs, statement, conn);
		}
		return 0;
		
		
	} 
	
	
}
