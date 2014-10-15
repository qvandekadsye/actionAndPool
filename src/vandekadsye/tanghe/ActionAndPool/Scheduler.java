package vandekadsye.tanghe.ActionAndPool;

import java.util.ArrayList;
import java.util.List;

public abstract class Scheduler extends Action {

    protected List<Action> actions;
    protected int progress;
    
    public Scheduler() {
    
        actions = new ArrayList<Action>();
        progress = 0;
    
    }
    
    public Scheduler(List<? extends Action> actions) {
    
        this.actions = (List<Action>) actions;
        progress = 0;
    
    }
    
    
    public List<Action> getActions() {
    
        return actions;
    
    }
    
    public void addAction(Action a) {
    
        actions.add(a);
    
    }
    
    public boolean isReady() {
    	
    	if(!isInProgress() && !isFinished())
    		return true;
    	else
    		return false;
    	
    }
    
    public boolean isInProgress() {
    	
    	if(this.progress > 0 && !isFinished())
    		return true;
    	else
    		return false;
    	
    }
    
    public boolean isFinished() {
    
        return actions.isEmpty();
    
    }

}
