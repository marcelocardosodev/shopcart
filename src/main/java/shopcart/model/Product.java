package shopcart.model;

import java.util.ArrayList;

import shopcart.dao.ProductDao;
import shopcart.dao.UserStoreDao;

public class Product {
	
	private Integer idProduct;
	private String description;
	private Integer amount;
	private Category category;
	private Double price;
	private boolean online;
	public Product() {
	}
	public Product(String description, Integer amount, Category category, Double price, boolean online) {
		super();
		this.description = description;
		this.amount = amount;
		this.category = category;
		this.price = price;
		this.online = online;
	}
	public Integer getIdProduct() {
		return idProduct;
	}
	public void setIdProduct(Integer idProduct) {
		this.idProduct = idProduct;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	
	
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public boolean isOnline() {
		return online;
	}
	public void setOnline(boolean online) {
		this.online = online;
	}
	
	public Boolean saveProduct(Product product) {
		
		if(product != null) {
			new ProductDao().registerProduct(product);
			return true;
		}
		return false;
	}
	
	public Product seacherById(int idProduct) {
		
		return new ProductDao().seacherById(idProduct);
	}
	
	public ArrayList<Product> searchProductByDescription(String description){
		
		return new ProductDao().searchProductByDescription(description);
	}
	
	public void change(Product product) {
		new ProductDao().changeProduct(product);
	}
	
	public void excluirProduct(int id) {
		new ProductDao().excluirProduct(id);
	}

}
