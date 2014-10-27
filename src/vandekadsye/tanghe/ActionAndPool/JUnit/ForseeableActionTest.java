package vandekadsye.tanghe.ActionAndPool.JUnit;

import static org.junit.Assert.*;

import org.junit.Test;

import vandekadsye.tanghe.ActionAndPool.ForseeableAction;

public class ForseeableActionTest {

	private ForseeableAction fa1, fa2;
	
	public ForseeableActionTest() {
		
		fa1 = new ForseeableAction(1);
		fa2 = new ForseeableAction(2);
		
	}
	
	@Test
	public void testIsReady() {
		
		assertTrue(fa1.isReady());
		
	}

	@Test
	public void testIsInProgress() {
		fail("Not yet implemented");
	}

	@Test
	public void testIsFinished() {
		fail("Not yet implemented");
	}

	@Test
	public void testDoStep() {
		fail("Not yet implemented");
	}

	@Test
	public void testForseeableAction() {
		fail("Not yet implemented");
	}

}
