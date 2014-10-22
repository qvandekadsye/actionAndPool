package vandekadsye.tanghe.ActionAndPool.JUnit;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import vandekadsye.tanghe.ActionAndPool.Action;
import vandekadsye.tanghe.ActionAndPool.ForseeableAction;
import vandekadsye.tanghe.ActionAndPool.SequentialScheduler;
import vandekadsye.tanghe.ActionAndPool.Exceptions.ActionFinishedException;

public class SequentialSchedulerTest {

	@Test
	public void testProgression() {
		List<Action> list = new ArrayList<Action>();
		Action a1 = new ForseeableAction(1);
		Action a2 = new ForseeableAction(2);
		list.add(a1);
		list.add(a2);
		
		SequentialScheduler s = new SequentialScheduler(list);
		/*
		 * At this time:
		 * 						+-----------------------------------------------+
		 * 						|		 Expected value for object...			|
		 * +--------------------+---------------------------+-------------------+
		 * | Method				|  s	| action1 (1 step)	| action2 (2 steps)	|
		 * +--------------------+---------------------------+-------------------+
		 * | isReady()			| true	| true				| true				| 
		 * +--------------------+---------------------------+-------------------+
		 * | isInProgress()		| false	| false				| false				| 
		 * +--------------------+---------------------------+-------------------+
		 * | isFinished()		| false	| false				| false				| 
		 * +--------------------+---------------------------+-------------------+
		 */
		assertTrue(s.isReady());
		assertFalse(s.isInProgress());
		assertFalse(s.isFinished());
		
		assertTrue(a1.isReady());
		assertFalse(a1.isInProgress());
		assertFalse(a1.isFinished());
		
		assertTrue(a2.isReady());
		assertFalse(a2.isInProgress());
		assertFalse(a2.isFinished());
		
		// Doing a step
		try {
			s.doStep();
		} catch (ActionFinishedException e) {
			fail("Thrown ActionFinishedException at a time it should not.");
		}
		
		
		/*
		 * At this time:
		 * 						+-----------------------------------------------+
		 * 						|		 Expected value for object...			|
		 * +--------------------+---------------------------+-------------------+
		 * | Method				|  s	| action1 (1 step)	| action2 (2 steps)	|
		 * +--------------------+---------------------------+-------------------+
		 * | isReady()			| false	| false				| true				| 
		 * +--------------------+---------------------------+-------------------+
		 * | isInProgress()		| true	| false				| false				| 
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
		
		assertTrue(a2.isReady());
		assertFalse(a2.isInProgress());
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
