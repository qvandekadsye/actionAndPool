package vandekadsye.tanghe.ActionAndPool;

public class ForseeableAction extends Action{

	private int currentStep;
	private int numberOfSteps;
	private String actionName;
	
	/**
	 * Constructor
	 * @param numberOfSteps a number of steps necessary to finish the action
	 * @throws IllegalArgumentException thrown if the number of steps is lower than 1.
	 */
	public ForseeableAction(int numberOfSteps) throws IllegalArgumentException
	{
		if(numberOfSteps < 1)
			throw new IllegalArgumentException("The number of steps cannot be lower than 1.");
		
		this.numberOfSteps = numberOfSteps;
		this.currentStep = 0;
		
		actionName = "";
	}
	
	public ForseeableAction(int numberOfSteps, String actionName) {
		
		this(numberOfSteps);
		this.actionName = actionName;
		
	}
	
	public boolean isFinished()
	{
		boolean result=false;
		if(this.currentStep==this.numberOfSteps)
		{
			result=true;
		}
		
		return result;
	}
	
	public boolean isReady()
	{
		boolean result=false;
		
		if(this.currentStep == 0)
			result = true;
		
		return result;
		
	}
	
	public void doStep()
	{
		this.currentStep++;
		System.out.println("is "+actionName+" ("+this.currentStep+"/"+this.numberOfSteps+")");
	}

	@Override
	public boolean isInProgress() {
		if(this.currentStep > 0 && this.currentStep < this.numberOfSteps)
			return true;
		else
			return false;
	}
}
