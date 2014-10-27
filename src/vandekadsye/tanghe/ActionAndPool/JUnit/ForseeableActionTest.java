package vandekadsye.tanghe.ActionAndPool.JUnit;

import static org.junit.Assert.*;

import org.junit.Test;

import vandekadsye.tanghe.ActionAndPool.ForseeableAction;

public class ForseeableActionTest {

	private ForseeableAction fa1, fa2;
	
	public ForseeableActionTest() throws IllegalArgumentException {
		
		fa1 = new ForseeableAction(1);
		fa2 = new ForseeableAction(2);
		
	}
	
	@Test
	public void testIsReady() {
		
		assertTrue(fa1.isReady());
		assertTrue(fa2.isReady());
		
		assertFalse(fa1.isInProgress());
		assertFalse(fa2.isInProgress());
		
		assertFalse(fa1.isFinished());
		assertFalse(fa2.isFinished());
		
	}

	@Test
	public void testIsInProgress() {

		fa2.doStep();
		
		assertFalse(fa2.isReady());
		assertTrue(fa2.isInProgress());
		assertFalse(fa2.isFinished());
		
	}

	@Test
	public void testIsFinished() {
		
		fa1.doStep();
		fa2.doStep();
		fa2.doStep();
		
		assertFalse(fa1.isReady());
		assertFalse(fa2.isReady());
		
		assertFalse(fa1.isInProgress());
		assertFalse(fa2.isInProgress());
		
		assertTrue(fa1.isFinished());
		assertTrue(fa2.isFinished());
		
	}

}
