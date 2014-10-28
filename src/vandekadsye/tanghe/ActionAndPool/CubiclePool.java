package vandekadsye.tanghe.ActionAndPool;

public class CubiclePool extends ResourcePool<Cubicle> {
	
	/**
	 * @param nbCubicle Number of cubicle you want in the pool
	 */
	public CubiclePool(int nbCubicle)
	{
		super(nbCubicle, "cubicle");
	}

	@Override
	public Cubicle createInstanceOfR() {
		
		return new Cubicle();
	}

}
