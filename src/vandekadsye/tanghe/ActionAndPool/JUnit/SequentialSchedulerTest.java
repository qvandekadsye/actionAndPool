package vandekadsye.tanghe.ActionAndPool.JUnit;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import vandekadsye.tanghe.ActionAndPool.Action;
import vandekadsye.tanghe.ActionAndPool.ForseeableAction;
import vandekadsye.tanghe.ActionAndPool.SequentialScheduler;
import vandekadsye.tanghe.ActionAndPool.Exceptions.ActionFinishedException;

public class SequentialSchedulerTest extends ForseeableActionTest {

	@Test
	public void testProgression() throws ActionFinishedException {
		List<Action> list = new ArrayList<Action>();
		Action a1 = new ForseeableAction(1);
		Action a2 = new ForseeableAction(2);
		Action a3 = new ForseeableAction(3);
		list.add(a1);
		list.add(a2);
		list.add(a3);
		
		SequentialScheduler s = new SequentialScheduler(list);
		testIsReady(s);
		testIsReady(a1);
		testIsReady(a2);
		testIsReady(a3);
		
		// Step 1/1 for a1 
		s.doStep();
		testIsInProgress(s);
		testIsFinished(a1);
		testIsReady(a2);
		testIsReady(a3);
		
		// Step 1/2 for a2
		s.doStep();
		testIsInProgress(s);
		testIsFinished(a1);
		testIsInProgress(a2);
		testIsReady(a3);
		
		// Step 2/2 for a2
		s.doStep();
		testIsInProgress(s);
		testIsFinished(a1);
		testIsFinished(a2);
		testIsReady(a3);
		
		// Step 1/3 for a3
		s.doStep();
		testIsInProgress(s);
		testIsFinished(a1);
		testIsFinished(a2);
		testIsInProgress(a3);
		
		// Step 2/3 for a3
		s.doStep();
		testIsInProgress(s);
		testIsFinished(a1);
		testIsFinished(a2);
		testIsInProgress(a3);
		
		// Step 3/3 for a3
		s.doStep();
		testIsFinished(s);
		testIsFinished(a1);
		testIsFinished(a2);
		testIsFinished(a3);
		
		try {
			s.doStep();
			fail("Should throw an ActionFinishedException but did not.");
		} catch(ActionFinishedException e) {
			// Nothing to do here
		}
		
	}

}
