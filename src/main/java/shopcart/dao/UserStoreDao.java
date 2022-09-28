package shopcart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import shopcart.model.Product;
import shopcart.model.Type;
import shopcart.model.UserStore;

public class UserStoreDao {
	
	public void registerUser(UserStore user) {
		

		String sql ="INSERT INTO USERSTORE VALUES(null,?,?,?,?)";
		
		PreparedStatement psStatement = null;
		Connection conn = null;
		
		try {
			conn = new MySqlConnection().getConnection();
			psStatement = conn.prepareStatement(sql);
			psStatement.setString(1, user.getName());
			psStatement.setString(2, user.getType().toString());
			psStatement.setDouble(3, user.getBalance());
			psStatement.setString(4, user.getPassword());
			psStatement.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(psStatement!=null) {
					psStatement.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
			try {
				if(conn!=null) {
					conn.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	
	}
	
	
	public  UserStore userStoreAuthenticate(String name, String password) {

		String sql = "SELECT * FROM USERSTORE WHERE name = ? AND password = ?";
		ResultSet rs = null;
		Connection conn = null;
		PreparedStatement psStatement = null;
		UserStore user = null;
//		ArrayList<UserStore> usersFound = null;
		try {
			conn = new MySqlConnection().getConnection();
			psStatement = conn.prepareStatement(sql);
			psStatement.setString(1, name);
			psStatement.setString(2, password);
			rs = psStatement.executeQuery();
			if(rs.next()) {
				
				user = new UserStore();
				user.setIdUser(rs.getInt("idUser"));
				user.setBalance(rs.getDouble("balance"));
				user.setName(rs.getString("name"));
				user.setPassword(rs.getString("password"));
				user.setType(Type.valueOf(rs.getString("type")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(psStatement!=null) {
					psStatement.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
			try {
				if(conn!=null) {
					conn.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return user;
	
	}
	
	public  UserStore searchUserById(Integer userId) {

		String sql = "SELECT * FROM USERSTORE WHERE idUser = ?;";
		ResultSet rs = null;
		Connection conn = null;
		PreparedStatement psStatement = null;
		UserStore user = null;
		try {
			conn = new MySqlConnection().getConnection();
			psStatement = conn.prepareStatement(sql);
			psStatement.setInt(1, userId);
			rs = psStatement.executeQuery();
			if(rs.next()) {
				
				user = new UserStore();
				user.setIdUser(rs.getInt("idUser"));
				user.setBalance(rs.getDouble("balance"));
				user.setName(rs.getString("name"));
				user.setPassword(rs.getString("password"));
				user.setType(Type.valueOf(rs.getString("type")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(psStatement!=null) {
					psStatement.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
			try {
				if(conn!=null) {
					conn.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return user;
	
	}
	
}
