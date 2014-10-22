package vandekadsye.tanghe.ActionAndPool;

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
		this.actions.addAction(new TakeResourceAction(basketPoolToUse,new ResourcefulUser<Basket>()));
		this.actions.addAction(new TakeResourceAction(cubiclePoolToUse,new ResourcefulUser()));
		this.actions.addAction(new ForseeableAction(timeToUndress));
		//this.actions.addActions(new FreeResourceAction());
		this.actions.addAction(new ForseeableAction(timeToSwim));
		this.actions.addAction(new TakeResourceAction(cubiclePoolToUse,new ResourcefulUser()));
		this.actions.addAction(new ForseeableAction(timeToDress));
		//this.actions.addActions(new FreeResourceAction());
		//this.actions.addActions(new FreeResourceAction());
		
		
	}

	
	}


