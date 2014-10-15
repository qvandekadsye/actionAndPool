package vandekadsye.tanghe.ActionAndPool;

public class BasketPool extends ResourcePool<Basket> {

	public BasketPool(int nbBaskets) {

		super(nbBaskets);

	}


	public Basket createInstanceOfR() {

		return new Basket();

	}

}
