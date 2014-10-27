package vandekadsye.tanghe.ActionAndPool;

import vandekadsye.tanghe.ActionAndPool.Exceptions.ActionFinishedException;

public class Swimmer extends SequentialScheduler {
	private String name;
	private BasketPool basketManager;
	private CubiclePool cubicleManager;
	private int undressingTime, swimmingTime, dressingTime;
	
	/**
	 * Swimmer class constructor.
	 * @param swimmerName Name of the swimmer.
	 * @param basketPoolToUse The basket provider.
	 * @param cubiclePoolToUse The cubicle provider.
	 * @param timeToUndress Steps needed for the undressing.
	 * @param timeToSwim  Steps needed for the swimming.
	 * @param timeToDress Steps needed for the swimming.
	 */
	public Swimmer(String swimmerName, BasketPool basketPoolToUse, CubiclePool cubiclePoolToUse, int timeToUndress, int timeToSwim, int timeToDress)
	{
		this.name=swimmerName;
		this.basketManager=basketPoolToUse;
		this.cubicleManager=cubiclePoolToUse;
		this.undressingTime=timeToUndress;
		this.swimmingTime=timeToSwim;
		this.dressingTime=timeToDress;
		initializing(timeToUndress, timeToSwim, timeToDress);
		
		
	}

	/**
	 * @param timeToUndress number of step for action undress.
	 * @param timeToSwim number of step for action swim.
	 * @param timeToDress number of step for action dress.
	 */
	public void initializing(int timeToUndress, int timeToSwim, int timeToDress) {
		ResourcefulUser<Basket> basketUser=new ResourcefulUser<Basket>();
		ResourcefulUser<Cubicle>cubicleUser=new ResourcefulUser<Cubicle>();
		addAction(new TakeResourceAction<Basket>(basketManager,basketUser));
		addAction(new TakeResourceAction<Cubicle>(cubicleManager,cubicleUser));
		addAction(new ForseeableAction(timeToUndress));
		addAction(new FreeResourceAction<Cubicle>(cubicleManager,cubicleUser));
		addAction(new ForseeableAction(timeToSwim));
		addAction(new TakeResourceAction<Cubicle>(cubicleManager,cubicleUser));
		addAction(new ForseeableAction(timeToDress));
		addAction(new FreeResourceAction<Cubicle>(cubicleManager,cubicleUser));
		addAction(new FreeResourceAction<Basket>(basketManager,basketUser));
	}
	
	public String getName()
	{
		return this.name;
	}

	@Override
	public void doStep() throws ActionFinishedException {
		System.out.println(this.getName());
		super.doStep();
		
	}
	
}


