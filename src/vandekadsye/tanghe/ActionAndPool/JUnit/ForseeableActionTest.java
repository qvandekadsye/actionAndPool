package vandekadsye.tanghe.ActionAndPool.JUnit;

import static org.junit.Assert.*;

import org.junit.Test;

import vandekadsye.tanghe.ActionAndPool.ForseeableAction;
import vandekadsye.tanghe.ActionAndPool.Exceptions.ActionFinishedException;

public class ForseeableActionTest {

	public ForseeableAction fa1, fa2;
	
	public ForseeableActionTest() throws IllegalArgumentException {
		
		fa1 = new ForseeableAction(1);
		fa2 = new ForseeableAction(2);
		
	}
	
	@Test
	public void testAll() throws ActionFinishedException {
		
		testIsReady();
		
		fa2.doStep();
		testIsInProgress();
		
		fa1.doStep();
		fa2.doStep();
		testIsFinished();
		
	}
	
	public void testIsReady() {
		
		assertTrue(fa1.isReady());
		assertTrue(fa2.isReady());
		
		assertFalse(fa1.isInProgress());
		assertFalse(fa2.isInProgress());
		
		assertFalse(fa1.isFinished());
		assertFalse(fa2.isFinished());
		
	}

	public void testIsInProgress() {
		
		assertFalse(fa2.isReady());
		assertTrue(fa2.isInProgress());
		assertFalse(fa2.isFinished());
		
	}

	public void testIsFinished() {
		
		assertFalse(fa1.isReady());
		assertFalse(fa2.isReady());
		
		assertFalse(fa1.isInProgress());
		assertFalse(fa2.isInProgress());
		
		assertTrue(fa1.isFinished());
		assertTrue(fa2.isFinished());
		
	}

}
