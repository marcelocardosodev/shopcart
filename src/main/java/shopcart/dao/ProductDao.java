package shopcart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import shopcart.model.Category;
import shopcart.model.Product;

public class ProductDao {

	public void registerProduct(Product product) {
		String sql ="INSERT INTO PRODUCT VALUES(null,?,?,?,?,?)";
		
		PreparedStatement psStatement = null;
		Connection conn = null;
		
		try {
			conn = new MySqlConnection().getConnection();
			psStatement = conn.prepareStatement(sql);
			psStatement.setString(1, product.getDescription());
			psStatement.setString(2, product.getCategory().toString());
			psStatement.setInt(3, product.getAmount());
			psStatement.setDouble(4, product.getPrice());
			psStatement.setBoolean(5, product.isOnline());
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
	
	public Product seacherById(int id) {
		String sql = "SELECT * FROM PRODUCT WHERE idProduct = ?";
		ResultSet rs = null;
		Connection conn = null;
		PreparedStatement pStatement = null;
		Product product = null;
		try {
			conn = new MySqlConnection().getConnection();
			pStatement = conn.prepareStatement(sql);
			pStatement.setInt(1, id);
			rs = pStatement.executeQuery();
			if (rs != null && rs.next()) {
				product = new Product();
				product.setIdProduct(rs.getInt("idProduct"));
				product.setDescription(rs.getString("description"));
				product.setAmount(rs.getInt("amount"));
				product.setCategory(Category.valueOf(rs.getString("category")));
				product.setPrice(rs.getDouble("price"));
				product.setOnline(rs.getBoolean("onLine"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pStatement != null) {
					pStatement.close();
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		return product;
	}
	
	public ArrayList<Product> searchProductByDescription(String description){
		
		String consult01 = "SELECT * FROM PRODUCT";
		String consult02 = "SELECT * FROM PRODUCT WHERE description LIKE '%"+ description +"%'";
		String sql = description.isEmpty()?consult01:consult02;
		ResultSet rs = null;
		Connection conn = null;
		PreparedStatement psStatement = null;
		Product product = null;
		ArrayList<Product> products = null;
		try {
			conn = new MySqlConnection().getConnection();
			psStatement = conn.prepareStatement(sql);
			rs = psStatement.executeQuery();
			products = new ArrayList<Product>();
			if(rs !=null) {
				while(rs.next()) {
					
					product = new Product();
					product.setIdProduct(rs.getInt("idProduct"));
					product.setDescription(rs.getString("description"));
					product.setCategory(Category.valueOf(rs.getString("category")));
					product.setAmount(rs.getInt("amount"));
					product.setPrice(rs.getDouble("price"));
					
					products.add(product);
				}
				
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
		return products;
	}
	
	public void changeProduct(Product product) {
		String sql = "UPDATE PRODUCT SET description = ?, amount = ?, category = ?, price = ?, onLine = ? WHERE idProduct = ?";
		PreparedStatement pStatement = null;
		Connection conn = null;
		
		try {
			conn = new MySqlConnection().getConnection();
			pStatement = conn.prepareStatement(sql);
			pStatement.setString(1, product.getDescription());
			pStatement.setInt(2, product.getAmount());
			pStatement.setString(3, product.getCategory().toString());
			pStatement.setDouble(4, product.getPrice());
			pStatement.setBoolean(5, product.isOnline());
			pStatement.setInt(6, product.getIdProduct());
			pStatement.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pStatement!=null) {
					pStatement.close();
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
	
	public void excluirProduct(int idProduct) {
		String sql = "DELETE FROM PRODUCT WHERE idProduct = ?";
		PreparedStatement pStatement = null;
		Connection conn = null;
		try {
			conn = new MySqlConnection().getConnection();
			pStatement = conn.prepareStatement(sql);
			pStatement.setInt(1, idProduct);
			pStatement.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pStatement != null)
					pStatement.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}

			try {
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	
}
