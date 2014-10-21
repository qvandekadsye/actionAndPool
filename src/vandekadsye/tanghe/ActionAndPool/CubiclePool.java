package vandekadsye.tanghe.ActionAndPool;

public class CubiclePool extends ResourcePool<Cubicle> {
	
	public CubiclePool(int nbCubicle)
	{
		super(nbCubicle);
	}

	@Override
	public Cubicle createInstanceOfR() {
		// TODO Auto-generated method stub
		return new Cubicle();
	}

}
