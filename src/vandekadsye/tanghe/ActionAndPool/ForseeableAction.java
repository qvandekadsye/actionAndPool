package vandekadsye.tanghe.ActionAndPool;

public class ForseeableAction extends Action{

	private int currentState;
	private int numberOfState;
	
	public ForseeableAction(int numberOfState)
	{
		this.numberOfState=numberOfState;
		this.currentState=0;
	}
	
	public boolean isFinished()
	{
		boolean result=false;
		if(this.currentState==this.numberOfState)
			result=true;
		return result;
	}
	
	public boolean isReady()
	{
		boolean result=false;
		if(this.currentState==0)
			result=true;
		return result;
		
	}
	
	public void doStep()
	{
		this.currentState++;
	}

	@Override
	public boolean isInProgress() {
		// TODO Auto-generated method stub
		return false;
	}
}
