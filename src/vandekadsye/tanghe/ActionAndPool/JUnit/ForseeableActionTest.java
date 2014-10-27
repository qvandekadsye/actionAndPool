package vandekadsye.tanghe.ActionAndPool.JUnit;

import static org.junit.Assert.*;

import org.junit.Test;

import vandekadsye.tanghe.ActionAndPool.ForseeableAction;
import vandekadsye.tanghe.ActionAndPool.Exceptions.ActionFinishedException;

public class ForseeableActionTest {
	
	@Test
	public void testAll() throws ActionFinishedException {
		
		ForseeableAction fa = new ForseeableAction(2);
		
		testIsReady(fa);
		
		fa.doStep();
		testIsInProgress(fa);
		
		fa.doStep();
		testIsFinished(fa);
		
	}
	
	public void testIsReady(ForseeableAction fa) {
		
		assertTrue(fa.isReady());
		assertFalse(fa.isInProgress());
		assertFalse(fa.isFinished());
		
	}

	public void testIsInProgress(ForseeableAction fa) {
		
		assertFalse(fa.isReady());
		assertTrue(fa.isInProgress());
		assertFalse(fa.isFinished());
		
	}

	public void testIsFinished(ForseeableAction fa) {
		
		assertFalse(fa.isReady());
		assertFalse(fa.isInProgress());
		assertTrue(fa.isFinished());
		
	}

}
