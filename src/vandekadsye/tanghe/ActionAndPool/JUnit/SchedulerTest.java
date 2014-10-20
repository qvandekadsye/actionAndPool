package vandekadsye.tanghe.ActionAndPool.JUnit;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import vandekadsye.tanghe.ActionAndPool.ForseeableAction;
import vandekadsye.tanghe.ActionAndPool.SequentialScheduler;
import vandekadsye.tanghe.ActionAndPool.Exceptions.ActionFinishedException;

public class SchedulerTest {

	@Test
	public void testIsReady() {
		List<ForseeableAction> list = new ArrayList<ForseeableAction>();
		list.add(new ForseeableAction(1));
		list.add(new ForseeableAction(2));
		
		SequentialScheduler s = new SequentialScheduler(list);
		assertFalse(s.isFinished());
		try {
			s.doStep();
		} catch (ActionFinishedException e) {
			fail();
		}
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
	public void testScheduler() {
		fail("Not yet implemented");
	}

	@Test
	public void testSchedulerListOfAction() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetActions() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddAction() {
		fail("Not yet implemented");
	}

}
