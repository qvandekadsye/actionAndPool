package vandekadsye.tanghe.ActionAndPool.JUnit;

import static org.junit.Assert.*;

import org.junit.Test;

import vandekadsye.tanghe.ActionAndPool.Action;
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
	
	public void testIsReady(Action fa) {
		
		assertTrue(fa.isReady());
		assertFalse(fa.isInProgress());
		assertFalse(fa.isFinished());
		
	}

	public void testIsInProgress(Action fa) {
		
		assertFalse(fa.isReady());
		assertTrue(fa.isInProgress());
		assertFalse(fa.isFinished());
		
	}

	public void testIsFinished(Action fa) {
		
		assertFalse(fa.isReady());
		assertFalse(fa.isInProgress());
		assertTrue(fa.isFinished());
		
	}

}
