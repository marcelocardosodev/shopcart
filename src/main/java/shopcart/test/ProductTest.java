package shopcart.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import org.junit.jupiter.api.Test;

import shopcart.model.Category;
import shopcart.model.Product;


public class ProductTest {

	
	
	@Test
	public void productPriceTest() {
		
		Product productTest = new Product();
		
		productTest.setCategory(Category.ACCESSORIES);
		productTest.setDescription("Test description");
		productTest.setOnline(true);
		productTest.setAmount(100);
		productTest.setPrice(10.00);
		
		assertEquals(productTest.getPrice(), 10);
		assertNotEquals(productTest.getPrice(), 15.00);
	}
	
	@Test
	public void newProductCategoryTest() {
		
		Product productTest = new Product();
		
		productTest.setCategory(Category.ACCESSORIES);
		productTest.setDescription("Test description");
		productTest.setOnline(true);
		productTest.setAmount(100);
		productTest.setPrice(10.00);
		
		assertEquals(productTest.getCategory(), Category.ACCESSORIES);
		assertNotEquals(productTest.getCategory(), Category.CLOTHES);
	}
	
	
	@Test
	public void newProductDescriptionTest() {
		
		Product productTest = new Product();
		
		productTest.setCategory(Category.ACCESSORIES);
		productTest.setDescription("Test description");
		productTest.setOnline(true);
		productTest.setAmount(100);
		productTest.setPrice(10.00);
		
		assertEquals(productTest.getDescription(), "Test description");
		assertNotEquals(productTest.getDescription(), "");
	}
	
	@Test
	public void newProductAmountTest() {
		
		Product productTest = new Product();
		
		productTest.setCategory(Category.ACCESSORIES);
		productTest.setDescription("Test description");
		productTest.setOnline(true);
		productTest.setAmount(100);
		productTest.setPrice(10.00);
		
		assertEquals(productTest.getAmount(), 100);
		assertNotEquals(productTest.getAmount(), 1);
	}

}
