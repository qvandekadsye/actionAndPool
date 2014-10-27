package vandekadsye.tanghe.ActionAndPool.JUnit;

import static org.junit.Assert.*;

import org.junit.Test;

import vandekadsye.tanghe.ActionAndPool.FairScheduler;
import vandekadsye.tanghe.ActionAndPool.Exceptions.ActionFinishedException;

public class FairSchedulerTest extends ForseeableActionTest {

	public FairScheduler fs;
	
	public FairSchedulerTest() {
		
		super();
		
		fs = new FairScheduler();
		fs.addAction(fa1);
		fs.addAction(fa2);
		
	}
	
	@Test
	public void testDoStep() throws ActionFinishedException {
		
		super.testIsReady();
		
		fs.doStep();
		
		super.testIsInProgress();
		
	}

	@Test
	public void testFairScheduler() {
		fail("Not yet implemented");
	}

	@Test
	public void testFairSchedulerListOfAction() {
		fail("Not yet implemented");
	}

}
