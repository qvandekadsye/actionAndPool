package vandekadsye.tanghe.ActionAndPool;

public class ForseeableAction extends Action{

	private int currentStep;
	private int numberOfSteps;
	
	/**
	 * Constructor
	 * @param numberOfSteps a number of steps necessary to finish the action
	 */
	public ForseeableAction(int numberOfSteps)
	{
		this.numberOfSteps=numberOfSteps;
		this.currentStep=0;
	}
	public boolean isFinished()
	{
		boolean result=false;
		if(this.currentStep==this.numberOfSteps)
			result=true;
		return result;
	}
	
	public boolean isReady()
	{
		boolean result=false;
		if(this.currentStep==0)
			result=true;
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
