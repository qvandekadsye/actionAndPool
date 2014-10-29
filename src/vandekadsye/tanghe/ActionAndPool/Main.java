package vandekadsye.tanghe.ActionAndPool;

import vandekadsye.tanghe.ActionAndPool.Exceptions.ActionFinishedException;

/**
 * @author quentin
 *
 */
public class Main {

	/**
	 * @param args
	 * @throws ActionFinishedException 
	 */
	public static void main(String[] args) throws ActionFinishedException {
		BasketPool baskets = new BasketPool(6);
		CubiclePool cubicles=new CubiclePool(3);
		FairScheduler s=new FairScheduler();
		
		s.addAction(new Swimmer("Camille",baskets,cubicles,6,4,8));
		s.addAction(new Swimmer("Louis",baskets,cubicles,2,10,4));
		s.addAction(new Swimmer("Mae",baskets,cubicles,10,18,10));
		s.addAction(new Swimmer("Ange",baskets,cubicles,3,7,5));
		s.addAction(new Swimmer("Louison",baskets,cubicles,18,3,3));
		s.addAction(new Swimmer("Charlie",baskets,cubicles,3,6,10));
		s.addAction(new Swimmer("Alexis",baskets,cubicles,6,5,7));
		
		int nbstep=0;
		while(!s.isFinished())
		{
			nbstep++;
			s.doStep();
		}
		System.out.println("\nFinished in "+nbstep+" steps");

	}

}
