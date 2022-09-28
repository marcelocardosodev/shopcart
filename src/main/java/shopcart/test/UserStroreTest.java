package shopcart.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.Test;

import shopcart.model.UserStore;

public class UserStroreTest {

	@Test
	public void userCreatTest() {
		
		UserStore user = new UserStore();
		
		assertNotNull(user);
	}
	
	@Test
	public void userNameTest() {
		
		UserStore user = new UserStore();
		user.setName("Teste name");
		user.setPassword("passaWordTest");
		user.setBalance(1000.00);
		
		assertEquals(user.getName(), "Teste name");
		assertNotEquals(user.getName(), "Teste");
	}
	
	@Test
	public void userBalanceTest() {
		
		UserStore user = new UserStore();
		user.setName("Teste name");
		user.setPassword("passaWordTest");
		user.setBalance(1000.00);
		
		assertEquals(user.getBalance(),1000.00);
		assertNotEquals(user.getBalance(),100.00);
	}
	
	@Test
	public void userBalanceSumTest() {
		
		UserStore user = new UserStore();
		user.setName("Teste name");
		user.setPassword("passaWordTest");
		user.setBalance(1000.00);
		
		assertEquals(user.getBalance() + 500.00 ,1500.00);
		assertNotEquals(user.getBalance(),100.00);
	}
	
	@Test
	public void userBalanceSubTest() {
		
		UserStore user = new UserStore();
		user.setName("Teste name");
		user.setPassword("passaWordTest");
		user.setBalance(1000.00);
		
		assertEquals(user.getBalance() - 500.00 ,500.00);
		assertNotEquals(user.getBalance(),100.00);
	}
}
