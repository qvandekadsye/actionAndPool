package vandekadsye.tanghe.ActionAndPool.JUnit;

import org.junit.Test;

import vandekadsye.tanghe.ActionAndPool.FairScheduler;
import vandekadsye.tanghe.ActionAndPool.ForseeableAction;
import vandekadsye.tanghe.ActionAndPool.Exceptions.ActionFinishedException;

public class FairSchedulerTest extends ForseeableActionTest {

	public FairScheduler fs;
	public ForseeableAction fa1, fa2, fa3;
	
	public FairSchedulerTest() {
		
		super();
		
		fa1 = new ForseeableAction(1);
		fa2 = new ForseeableAction(2);
		fa3 = new ForseeableAction(3);
		
		fs = new FairScheduler();
		fs.addAction(fa1);
		fs.addAction(fa2);
		fs.addAction(fa3);
		
	}
	
	@Test
	public void testAll() throws ActionFinishedException {
		
		testIsReady(fa1);
		testIsReady(fa2);
		testIsReady(fa3);
		testIsReady(fs);
		
		// Step 1/1 for fa1
		fs.doStep();
		testIsFinished(fa1);
		testIsReady(fa2);
		testIsReady(fa3);
		testIsInProgress(fs);
		
		// Step 1/2 for fa2
		fs.doStep();
		testIsFinished(fa1);
		testIsInProgress(fa2);
		testIsReady(fa3);
		testIsInProgress(fs);
		
		// Step 1/3 for fa3
		fs.doStep();
		testIsFinished(fa1);
		testIsInProgress(fa2);
		testIsInProgress(fa3);
		testIsInProgress(fs);
		
		// Step 2/2 for fa2
		fs.doStep();
		testIsFinished(fa1);
		testIsFinished(fa2);
		testIsInProgress(fa3);
		testIsInProgress(fs);
		
		// Step 2/3 for fa3
		fs.doStep();
		testIsFinished(fa1);
		testIsFinished(fa2);
		testIsInProgress(fa3);
		testIsInProgress(fs);
		
		// Step 3/3 for fa3 (scheduler finished)
		fs.doStep();
		testIsFinished(fa1);
		testIsFinished(fa2);
		testIsFinished(fa3);
		testIsFinished(fs);
		
	}

}
