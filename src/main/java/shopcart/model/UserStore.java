package shopcart.model;

import java.util.ArrayList;

import shopcart.dao.UserStoreDao;

public class UserStore {
	
	private Integer idUser;
	private String name;
	private Type type;
	private Double balance;
	private String password;
	
	public UserStore() {
		
	}

	public UserStore(String name, Type type, Double balance, String password) {
		super();
		this.name = name;
		this.type = type;
		this.balance = balance;
		this.password = password;
	}

	public Integer getIdUser() {
		return idUser;
	}

	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public Boolean saveUser(UserStore user) {
		
		if(user != null) {
			new UserStoreDao().registerUser(user);
			return true;
		}
		return false;
	}
	
	public UserStore userStoreAuthenticate(String name, String password) {
		
		UserStore userDataBase = new UserStoreDao().userStoreAuthenticate(name, password);
		
		return userDataBase;
	}
	
	

}
