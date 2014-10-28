package vandekadsye.tanghe.ActionAndPool.JUnit;

import static org.junit.Assert.*;

import org.junit.Test;

import vandekadsye.tanghe.ActionAndPool.TakeResourceAction;
import vandekadsye.tanghe.ActionAndPool.ResourcefulUser;
import vandekadsye.tanghe.ActionAndPool.Cubicle;
import vandekadsye.tanghe.ActionAndPool.CubiclePool;
import vandekadsye.tanghe.ActionAndPool.Exceptions.ActionFinishedException;
import vandekadsye.tanghe.ActionAndPool.FreeResourceAction;

public class FreeResourceActionTest {
	public CubiclePool aCubiclePool;
	public ResourcefulUser<Cubicle> aUser;
	public TakeResourceAction<Cubicle> takeAction;
	public FreeResourceAction<Cubicle> freeAction;

	@Test(expected=ActionFinishedException.class)
	public void FreeResourceActionFinishedExceptiontest() throws ActionFinishedException {
		aCubiclePool=new CubiclePool(5);
		aUser=new ResourcefulUser<Cubicle>();
		takeAction=new TakeResourceAction<Cubicle>(aCubiclePool,aUser);
		freeAction=new FreeResourceAction<Cubicle>(aCubiclePool,aUser);
		takeAction.doStep();
		freeAction.doStep();
		freeAction.doStep();
		
	}
	
	@Test
	public void isFinishedTest() throws ActionFinishedException
	{
		aCubiclePool=new CubiclePool(5);
		aUser=new ResourcefulUser<Cubicle>();
		takeAction=new TakeResourceAction<Cubicle>(aCubiclePool,aUser);
		freeAction=new FreeResourceAction<Cubicle>(aCubiclePool,aUser);
		assertFalse(freeAction.isFinished());
		takeAction.doStep();
		freeAction.doStep();
		assertTrue(freeAction.isFinished());
	}
	
	@Test
	public void isReadyTest() throws ActionFinishedException
	{
		aCubiclePool=new CubiclePool(5);
		aUser=new ResourcefulUser<Cubicle>();
		takeAction=new TakeResourceAction<Cubicle>(aCubiclePool,aUser);
		freeAction=new FreeResourceAction<Cubicle>(aCubiclePool,aUser);
		assertTrue(freeAction.isReady());
		takeAction.doStep();
		freeAction.doStep();
		assertFalse(freeAction.isReady());
	}
	
	@Test
	public void isInProgressTest() throws ActionFinishedException
	{
		aCubiclePool=new CubiclePool(0);
		aUser=new ResourcefulUser<Cubicle>();
		takeAction=new TakeResourceAction<Cubicle>(aCubiclePool,aUser);
		freeAction=new FreeResourceAction<Cubicle>(aCubiclePool,aUser);
		assertFalse(freeAction.isInProgress());
		freeAction.doStep();
		assertTrue(freeAction.isInProgress());
	}
	

}
