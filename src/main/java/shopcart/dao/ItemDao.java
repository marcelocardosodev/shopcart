package shopcart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import shopcart.model.Category;
import shopcart.model.Item;
import shopcart.model.Product;

public class ItemDao {

	public Item saveIte(Item item, Integer amount) {
		
		String sql = "INSERT INTO item (idProduct, amount) VALUES (?, ?);"; 
		PreparedStatement psStatement = null;
		Connection conn = null;
		ResultSet rs = null;
		Integer id = null;
		Item itemSalved = null;
		try {
			
			conn = new MySqlConnection().getConnection();
			psStatement = conn.prepareStatement(sql);
			psStatement.setInt(1, item.getProduct().getIdProduct());
			psStatement.setInt(2, amount);
			psStatement.execute();
			
			rs = psStatement.executeQuery("SELECT * FROM item WHERE idItem in (SELECT LAST_INSERT_ID());");
			
			if (rs != null && rs.next()) {
				
				itemSalved = new Item();
				itemSalved.setIdItem(rs.getInt("idItem"));
				itemSalved.setProduct(item.getProduct());
				itemSalved.setAmount(amount);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if (psStatement != null) {
					psStatement.close();
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
		return itemSalved;
	}
	
	public Item seacherItemById(int id) {
		String sql = "SELECT * FROM item WHERE idItem = ?";
		ResultSet rs = null;
		Connection conn = null;
		PreparedStatement pStatement = null;
		Item item = null;
		try {
			conn = new MySqlConnection().getConnection();
			pStatement = conn.prepareStatement(sql);
			pStatement.setInt(1, id);
			rs = pStatement.executeQuery();
			if (rs != null && rs.next()) {
				item = new Item();
				
				item.setIdItem(rs.getInt("idItem"));
				item.setAmount(rs.getInt("amount"));
				Integer idProduto = rs.getInt("amount");
			    Product  product = new ProductDao().seacherById(idProduto);
				item.setProduct(product);
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
		return item;
	}
}
