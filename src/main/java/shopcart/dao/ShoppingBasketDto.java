package shopcart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import shopcart.model.Category;
import shopcart.model.Item;
import shopcart.model.Product;
import shopcart.model.ShoppingBasket;
import shopcart.model.UserStore;

public class ShoppingBasketDto {

	public ShoppingBasket addItem(Item item, UserStore user) {
		
		ShoppingBasket shpBasket = new ShoppingBasket();
		
		try {
			
			shpBasket =  searchBasketByUser(user);
			
			if(shpBasket == null) {
				
				shpBasket = createNewBasket(user);
			}
			
			saveItemBasket(shpBasket.getIdBasket(), item.getIdItem());
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return searchBasktById(shpBasket.getIdBasket());
	}
	
	
	public ShoppingBasket createNewBasket(UserStore user) {
		
		LocalDate localDate = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String dataFormated = localDate.format(formatter);
		
		String sql02 = "INSERT INTO shoppingbasket VALUES(NULL,?,?, true);";
		String sql03 = "SELECT * FROM shoppingbasket WHERE idBasket in (SELECT LAST_INSERT_ID()); ";
		
		ShoppingBasket shpBasket = null;
		PreparedStatement psStatement = null;
		Connection conn = null;
		ResultSet rs = null;
		
		try {
			
			conn = new MySqlConnection().getConnection();
			psStatement = conn.prepareStatement(sql02);
			psStatement.setInt(1, user.getIdUser());
			psStatement.setString(2, dataFormated);
			psStatement.execute();
			
			rs = psStatement.executeQuery(sql03);
			
			if(rs != null && rs.next()) {
				
				shpBasket = new ShoppingBasket();
				shpBasket.setIdBasket(rs.getInt("idBasket"));
				shpBasket.setUser(user);
				shpBasket.setActive(rs.getBoolean("active"));
				shpBasket.setDataCreated(rs.getString("dataCreate"));
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
		
		
		return shpBasket;
	}
	
	
	public ShoppingBasket searchBasktById(Integer idBasket) {
		
		String sql01 = "SELECT * FROM shoppingbasket WHERE idBasket = ?;";
		List<Item> itens;
		PreparedStatement psStatement = null;
		Connection conn = null;
		ResultSet rs = null;
		ShoppingBasket shpBasket = null;
		UserStore user = null;
		try {
			conn = new MySqlConnection().getConnection();
			psStatement = conn.prepareStatement(sql01);
			psStatement.setInt(1, idBasket);
			rs = psStatement.executeQuery();
			
			if(rs != null && rs.next()) {
				
				shpBasket = new ShoppingBasket();
				shpBasket.setIdBasket(rs.getInt("idBasket"));
				user = new UserStoreDao().searchUserById(rs.getInt("idUser"));
				shpBasket.setUser(user);
				shpBasket.setActive(rs.getBoolean("active"));
				shpBasket.setDataCreated(rs.getString("dataCreate"));
				itens = listItemBasket(rs.getInt("idBasket"));
				shpBasket.setList(itens);
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
		
		return shpBasket;
	}
	
	public ShoppingBasket searchBasketByUser(UserStore user) {
		
		String sql01 = "SELECT * FROM shoppingbasket WHERE idUser = ? AND active = 1;";
		PreparedStatement psStatement = null;
		Connection conn = null;
		ResultSet rs = null;
		ShoppingBasket shpBasket = null;
		try {
			conn = new MySqlConnection().getConnection();
			psStatement = conn.prepareStatement(sql01);
			psStatement.setInt(1, user.getIdUser());
			rs = psStatement.executeQuery();
			
			if(rs != null && rs.next()) {
				
				shpBasket = new ShoppingBasket();
				shpBasket.setIdBasket(rs.getInt("idBasket"));
				shpBasket.setUser(user);
				shpBasket.setActive(rs.getBoolean("active"));
				shpBasket.setDataCreated(rs.getString("dataCreate"));
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
		
		return shpBasket;
	}
	
	
	public List<Item> listItemBasket(Integer idBasket){
		
		String sql = "SELECT * FROM itembasket WHERE idBasket = ?;";
		List<Item> itens = new ArrayList<>();
		Item item = null;
		PreparedStatement psStatement = null;
		Connection conn = null;
		ResultSet rs = null;
		
		try {
			
			conn = new MySqlConnection().getConnection();
			psStatement = conn.prepareStatement(sql);
			psStatement.setInt(1, idBasket);
			rs = psStatement.executeQuery();
			
			if(rs !=null) {
				while(rs.next()) {
					
					item = new ItemDao().seacherItemById(rs.getInt("idItem"));
					itens.add(item);
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
		
		return itens;
	}
	
	
	public void saveItemBasket(Integer idBasket, Integer idItem) {
		
		String sql = "INSERT INTO itembasket VALUES(NULL,?,?);";
		
		PreparedStatement psStatement = null;
		Connection conn = null;
		ResultSet rs = null;
		
		
		try {
			conn = new MySqlConnection().getConnection();
			psStatement = conn.prepareStatement(sql);
			psStatement.setInt(1, idBasket);
			psStatement.setInt(2, idItem);
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
	
	

}
