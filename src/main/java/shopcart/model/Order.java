package shopcart.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class Order {
	
	private Integer idOrder;
	private List<Item> listItem;
	private UserStore user;
	private BigDecimal orderValue;
	private LocalDate date;
	public Order() {
	}
	public Order(List<Item> listItem, UserStore user, BigDecimal orderValue, LocalDate date) {
		super();
		this.listItem = listItem;
		this.user = user;
		this.orderValue = orderValue;
		this.date = date;
	}
	public Integer getIdOrder() {
		return idOrder;
	}
	public void setIdOrder(Integer idOrder) {
		this.idOrder = idOrder;
	}
	public List<Item> getListItem() {
		return listItem;
	}
	public void setListItem(List<Item> listItem) {
		this.listItem = listItem;
	}
	public UserStore getUser() {
		return user;
	}
	public void setUser(UserStore user) {
		this.user = user;
	}
	public BigDecimal getOrderValue() {
		return orderValue;
	}
	public void setOrderValue(BigDecimal orderValue) {
		this.orderValue = orderValue;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}

}
