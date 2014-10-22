package vandekadsye.tanghe.ActionAndPool.JUnit;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import vandekadsye.tanghe.ActionAndPool.ForseeableAction;
import vandekadsye.tanghe.ActionAndPool.SequentialScheduler;
import vandekadsye.tanghe.ActionAndPool.Exceptions.ActionFinishedException;

public class SequentialSchedulerTest {

	@Test
	public void testProgression() {
		List<ForseeableAction> list = new ArrayList<ForseeableAction>();
		list.add(new ForseeableAction(1));
		list.add(new ForseeableAction(2));
		
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
		
		assertTrue(s.getAction(0).isReady());
		assertFalse(s.getAction(0).isInProgress());
		assertFalse(s.getAction(0).isFinished());
		
		assertTrue(s.getAction(1).isReady());
		assertFalse(s.getAction(1).isInProgress());
		assertFalse(s.getAction(1).isFinished());
		
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
		
		assertFalse(s.getAction(0).isReady());
		assertFalse(s.getAction(0).isInProgress());
		assertTrue(s.getAction(0).isFinished());
		
		assertTrue(s.getAction(1).isReady());
		assertFalse(s.getAction(1).isInProgress());
		assertFalse(s.getAction(1).isFinished());
		
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
		
		assertFalse(s.getAction(0).isReady());
		assertFalse(s.getAction(0).isInProgress());
		assertTrue(s.getAction(0).isFinished());
		
		assertFalse(s.getAction(1).isReady());
		assertTrue(s.getAction(1).isInProgress());
		assertFalse(s.getAction(1).isFinished());
		
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
