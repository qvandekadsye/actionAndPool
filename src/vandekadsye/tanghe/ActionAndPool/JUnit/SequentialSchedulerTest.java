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
		
		/*
		 * At this time:
		 * 						+-----------------------------------------------+
		 * 						|		 Expected value for object...			|
		 * +--------------------+---------------------------+-------------------+
		 * | Method				|  s	| action1 (1 step)	| action2 (2 steps)	|
		 * +--------------------+---------------------------+-------------------+
		 * | isReady()			| false	| false				| false				| 
		 * +--------------------+---------------------------+-------------------+
		 * | isInProgress()		| true	| false				| true				| 
		 * +--------------------+---------------------------+-------------------+
		 * | isFinished()		| false	| true				| false				| 
		 * +--------------------+---------------------------+-------------------+
		 */
		assertFalse(s.isReady());
		assertTrue(s.isInProgress());
		assertFalse(s.isFinished());
		
		assertFalse(a1.isReady());
		assertFalse(a1.isInProgress());
		assertTrue(a1.isFinished());
		
		assertFalse(a2.isReady());
		assertTrue(a2.isInProgress());
		assertFalse(a2.isFinished());
		
		// Doing a step
		try {
			s.doStep();
		} catch(ActionFinishedException e) {
			fail("Thrown ActionFinishedException at a time it should not.");
		}
		
		/*
		 * At this time:
		 * 						+-----------------------------------------------+
		 * 						|		 Expected value for object...			|
		 * +--------------------+---------------------------+-------------------+
		 * | Method				|  s	| action1 (1 step)	| action2 (2 steps)	|
		 * +--------------------+---------------------------+-------------------+
		 * | isReady()			| false	| false				| false				| 
		 * +--------------------+---------------------------+-------------------+
		 * | isInProgress()		| false	| false				| false				| 
		 * +--------------------+---------------------------+-------------------+
		 * | isFinished()		| true	| true				| true				| 
		 * +--------------------+---------------------------+-------------------+
		 */
		assertFalse(s.isReady());
		assertFalse(s.isInProgress());
		assertTrue(s.isFinished());
		
		assertFalse(s.getAction(0).isReady());
		assertFalse(s.getAction(0).isInProgress());
		assertTrue(s.getAction(0).isFinished());
		
		assertFalse(s.getAction(1).isReady());
		assertFalse(s.getAction(1).isInProgress());
		assertTrue(s.getAction(1).isFinished());
		
		try {
			s.doStep();
			fail("Should throw an ActionFinishedException but did not.");
		} catch(ActionFinishedException e) {
			// Nothing to do here
		}
		
	}

}
