package shopcart.model;

import java.util.List;

import shopcart.dao.ShoppingBasketDto;

public class ShoppingBasket {
	
	private Integer idBasket;
	private List<Item> list;
	private UserStore user;
	private boolean active;
	private String dataCreated;
	
	public ShoppingBasket() {
		
	}

	public ShoppingBasket(List<Item> list, UserStore user, boolean active, String dataCreated) {
		super();
		this.list = list;
		this.user = user;
		this.active = active;
		this.dataCreated = dataCreated;
	}

	public Integer getIdBasket() {
		return idBasket;
	}

	public void setIdBasket(Integer idBasket) {
		this.idBasket = idBasket;
	}

	public List<Item> getList() {
		return list;
	}

	public void setList(List<Item> list) {
		this.list = list;
	}

	public UserStore getUser() {
		return user;
	}

	public void setUser(UserStore user) {
		this.user = user;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	

	public String getDataCreated() {
		return dataCreated;
	}

	public void setDataCreated(String dataCreated) {
		this.dataCreated = dataCreated;
	}

	public ShoppingBasket addItem(Item item, UserStore user) {
		
		return new ShoppingBasketDto().addItem(item, user);
	}
	
	public ShoppingBasket createNewBasket(UserStore user) {
		
		return new ShoppingBasketDto().createNewBasket(user);
	}
	
	public ShoppingBasket searchBasktById(Integer idBasket) {
		
		return new ShoppingBasketDto().searchBasktById(idBasket);
	}
	
	public ShoppingBasket searchBasketByUser(UserStore user) {
		
		return new ShoppingBasketDto().searchBasketByUser(user);
	}
	
	public List<Item> listItemBasket(Integer idBasket){
		return new ShoppingBasketDto().listItemBasket(idBasket);
	}
	
	public void saveItemBasket(Integer idBasket, Integer idItem) {
		
		new ShoppingBasketDto().saveItemBasket(idBasket, idItem);
	}

}
