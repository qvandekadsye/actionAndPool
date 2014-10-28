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
	
	@Test
	public void isFinishedTest() throws ActionFinishedException
	{
		aCubiclePool=new CubiclePool(5);
		aUser=new ResourcefulUser<Cubicle>();
		theAction=new TakeResourceAction<Cubicle>(aCubiclePool,aUser);
		assertFalse(theAction.isFinished());
		theAction.doStep();
		assertTrue(theAction.isFinished());
	}
	
	@Test
	public void isReadyTest() throws ActionFinishedException
	{
		aCubiclePool=new CubiclePool(5);
		aUser=new ResourcefulUser<Cubicle>();
		theAction=new TakeResourceAction<Cubicle>(aCubiclePool,aUser);
		assertTrue(theAction.isReady());
		theAction.doStep();
		assertFalse(theAction.isReady());
	}
	
	@Test
	public void isInProgressTest() throws ActionFinishedException
	{
		aCubiclePool=new CubiclePool(0);
		aUser=new ResourcefulUser<Cubicle>();
		theAction=new TakeResourceAction<Cubicle>(aCubiclePool,aUser);
		assertFalse(theAction.isInProgress());
		theAction.doStep();
		assertTrue(theAction.isInProgress());
	}
	

}
