package shopcart.model;

import java.math.BigDecimal;

public class BankAccount {
	
	private Integer idAccount;
	private UserStore user;
	private BigDecimal balance;
	
	public BankAccount() {
		
	}
	public BankAccount(UserStore user, BigDecimal balance) {
		super();
		this.user = user;
		this.balance = balance;
	}
	public Integer getIdAccount() {
		return idAccount;
	}
	public void setIdAccount(Integer idAccount) {
		this.idAccount = idAccount;
	}
	public UserStore getUser() {
		return user;
	}
	public void setUser(UserStore user) {
		this.user = user;
	}
	public BigDecimal getBalance() {
		return balance;
	}
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
	
}
