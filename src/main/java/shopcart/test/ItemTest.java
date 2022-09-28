package shopcart.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.Test;

import shopcart.model.Item;
import shopcart.model.Product;

public class ItemTest {
	
	@Test
	public void itemTest() {
		
		Item item = new Item();
		
		assertNotNull(item);
	}
	
	@Test
	public void itemProductNullTest() {
		
		Item item = new Item();
		
		assertNull(item.getProduct());
	}
	
	@Test
	public void itemProductTest() {
		
		Item item = new Item();
		Product prod = new Product();
		item.setProduct(prod);
		
		assertNotNull(item.getProduct());
	}

}
