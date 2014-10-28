package vandekadsye.tanghe.ActionAndPool;

/**
 * A pool of Basket-s
 */
public class BasketPool extends ResourcePool<Basket> {

	/**
	 * Constructor
	 * @param nbBaskets the number of baskets in the pool.
	 */
	public BasketPool(int nbBaskets) {

		super(nbBaskets, "basket");

	}

	/**
	 * Creates an instance of Basket and returns it
	 * @return an instance of Basket
	 */
	public Basket createInstanceOfR() {

		return new Basket();

	}

}
