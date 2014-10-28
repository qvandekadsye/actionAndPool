package vandekadsye.tanghe.ActionAndPool.JUnit;

import static org.junit.Assert.*;

import org.junit.Test;

import vandekadsye.tanghe.ActionAndPool.Basket;
import vandekadsye.tanghe.ActionAndPool.BasketPool;

public class BasketPoolTest {
	public BasketPool baskets;

	@Test
	public void ProvideResourceTest() {
		baskets=new BasketPool(7);
		Basket basket=null;
		basket=baskets.provideResource();
		assertNotNull(basket);
		
	}

}
