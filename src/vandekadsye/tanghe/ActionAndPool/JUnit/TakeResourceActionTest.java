package vandekadsye.tanghe.ActionAndPool.JUnit;

import static org.junit.Assert.*;

import org.junit.Test;

import vandekadsye.tanghe.ActionAndPool.TakeResourceAction;
import vandekadsye.tanghe.ActionAndPool.ResourcefulUser;
import vandekadsye.tanghe.ActionAndPool.Cubicle;
import vandekadsye.tanghe.ActionAndPool.CubiclePool;
import vandekadsye.tanghe.ActionAndPool.Exceptions.ActionFinishedException;


public class TakeResourceActionTest {
	public CubiclePool aCubiclePool;
	public ResourcefulUser<Cubicle> aUser;
	public TakeResourceAction<Cubicle> theAction;

	@Test (expected=ActionFinishedException.class)
	public void ActionFinishedExceptionTest() throws ActionFinishedException
	{
		aCubiclePool=new CubiclePool(5);
		aUser=new ResourcefulUser<Cubicle>();
		theAction=new TakeResourceAction<Cubicle>(aCubiclePool,aUser);
		theAction.doStep();
		theAction.doStep();
		
	}
	
	

}
