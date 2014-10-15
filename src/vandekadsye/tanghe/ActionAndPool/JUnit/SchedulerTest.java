package vandekadsye.tanghe.ActionAndPool.JUnit;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import vandekadsye.tanghe.ActionAndPool.ForseeableAction;
import vandekadsye.tanghe.ActionAndPool.SequentialScheduler;

public class SchedulerTest {

	@Test
	public void testIsReady() {
		ArrayList<ForseeableAction> list = new ArrayList<ForseeableAction>();
		list.add(new ForseeableAction(0));
		list.add(new ForseeableAction(1));
		
		SequentialScheduler s = new SequentialScheduler(list);
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
