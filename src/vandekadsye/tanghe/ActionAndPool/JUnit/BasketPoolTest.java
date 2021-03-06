package vandekadsye.tanghe.ActionAndPool.JUnit;

import static org.junit.Assert.*;

import org.junit.Test;

import vandekadsye.tanghe.ActionAndPool.Basket;
import vandekadsye.tanghe.ActionAndPool.BasketPool;

import java.util.NoSuchElementException;

public class BasketPoolTest {
	public BasketPool baskets;

	@Test
	public void ProvideResourceTest() {
		baskets=new BasketPool(7);
		Basket basket=null;
		basket=baskets.provideResource();
		assertNotNull(basket);
		
	}
	
	@Test(expected=NoSuchElementException.class)
	public void NoSuchElementExceptionTest()
	{
		baskets=new BasketPool(2);
		Basket basket1=baskets.provideResource();
		Basket basket2=baskets.provideResource();
		Basket basket3=baskets.provideResource();
	}
	
	

}
