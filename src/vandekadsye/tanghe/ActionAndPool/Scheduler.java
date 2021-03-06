package vandekadsye.tanghe.ActionAndPool;

import java.util.ArrayList;
import java.util.List;

/**
 * Manages a list of actions.
 * @param <A> the type of action
 */
public abstract class Scheduler extends Action {

    protected List<Action> actions;
    protected boolean hasStarted;
    
    public Scheduler() {
    
        actions = new ArrayList<Action>();
        hasStarted = false;
    
    }
    
    /**
     * @param actions2 a list of actions. Must be of type <code>List&lt;A&gt;</code> where A extends <code>Action</code>
     */
    public Scheduler(List<Action> actions2) {
    
        this.actions = actions2;
        hasStarted = false;
    
    }
    
    /**
     * @return a list of actions to be processed
     */
    public List<Action> getActions() {
    
        return actions;
    
    }
    
    public Action getAction(int index) {
    	return getActions().get(index);
    }
    
    /**
     * Adds <code>a</code> to the list of actions to process.
     * @param a the action to add to the list.
     */
    public void addAction(Action a) {
    
        actions.add(a);
    
    }
    
    @Override
    public boolean isReady() {
    	
    	if(!isInProgress() && !isFinished())
    		return true;
    	else
    		return false;
    	
    }
    
    @Override
    public boolean isInProgress() {
    	
    	if(this.hasStarted && !isFinished())
    		return true;
    	else
    		return false;
    	
    }
    
    @Override
    public boolean isFinished() {
    
        return actions.isEmpty();
    
    }

}
