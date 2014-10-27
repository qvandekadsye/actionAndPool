package vandekadsye.tanghe.ActionAndPool.JUnit;

import static org.junit.Assert.*;

import org.junit.Test;

import vandekadsye.tanghe.ActionAndPool.FairScheduler;
import vandekadsye.tanghe.ActionAndPool.ForseeableAction;
import vandekadsye.tanghe.ActionAndPool.Exceptions.ActionFinishedException;

public class FairSchedulerTest extends ForseeableActionTest {

	public FairScheduler fs;
	public ForseeableAction fa1, fa2;
	
	public FairSchedulerTest() {
		
		super();
		
		fa1 = new ForseeableAction(1);
		fa2 = new ForseeableAction(2);
		
		fs = new FairScheduler();
		fs.addAction(fa1);
		fs.addAction(fa2);
		
	}
	
	@Test
	public void testAll() throws ActionFinishedException {
		
		testIsReady(fa1);
		testIsReady(fa2);
		assertTrue(fs.isReady());
		
		fs.doStep();
		assertTrue(fa2.isInProgress());
		testIsFinished(fa1);
		testIsInProgress(fa2);
		assertTrue(fs.isInProgress());
		
		fs.doStep();
		testIsFinished(fa1);
		testIsFinished(fa2);
		assertTrue(fs.isFinished());
		
	}

}
