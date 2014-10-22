package vandekadsye.tanghe.ActionAndPool;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BasketPool baskets = new BasketPool(6);
		CubiclePool cubicles=new CubiclePool(3);
		FairScheduler s=new FairScheduler();
		
		s.addAction(new Swimmer("Camille",baskets,cubicles,6,4,8));

	}

}
