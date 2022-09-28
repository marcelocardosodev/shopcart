package shopcart.model;

import shopcart.dao.ItemDao;

public class Item {
	
	private Integer idItem;
	private Product product;
	private Integer amount;
	public Item() {
		
	}
	public Item(Product product, Integer amount) {
		super();
		this.product = product;
		this.amount = amount;
	}
	public Integer getIdItem() {
		return idItem;
	}
	public void setIdItem(Integer idItem) {
		this.idItem = idItem;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	
	public Item saveItem(Item item, Integer amount) {
		
		return new ItemDao().saveIte(item, amount);
	}
	
}
