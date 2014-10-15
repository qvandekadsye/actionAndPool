package vandekadsye.tanghe.ActionAndPool.JUnit;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import vandekadsye.tanghe.ActionAndPool.Action;
import vandekadsye.tanghe.ActionAndPool.FairScheduler;

public class FairSchedulerTest extends SchedulerTest {

	@Test
	public void testDoStep() {
		
		List<Action> actions;
		actions.add(new Action());
		FairScheduler scheduler = new FairScheduler(actions);
		
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
