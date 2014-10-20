package vandekadsye.tanghe.ActionAndPool.JUnit;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import vandekadsye.tanghe.ActionAndPool.Action;
import vandekadsye.tanghe.ActionAndPool.FairScheduler;
import vandekadsye.tanghe.ActionAndPool.ForseeableAction;

public class FairSchedulerTest extends SchedulerTest {

	@Test
	public void testDoStep() {
		
		List<Action> actions = new ArrayList<Action>();
		actions.add(new ForseeableAction(3));
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
