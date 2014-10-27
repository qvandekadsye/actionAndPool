package vandekadsye.tanghe.ActionAndPool;

public class ForseeableAction extends Action{

	private int currentStep;
	private int numberOfSteps;
	
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
	}
	
	public boolean isFinished()
	{
		boolean result=false;
		if(this.currentStep==this.numberOfSteps)
		{
			result=true;
			System.out.println("A forseable action is finished");
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
	}

	@Override
	public boolean isInProgress() {
		// TODO Auto-generated method stub
		return false;
	}
}
