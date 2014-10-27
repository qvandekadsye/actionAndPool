package vandekadsye.tanghe.ActionAndPool;

import java.util.List;
import java.util.NoSuchElementException;

import vandekadsye.tanghe.ActionAndPool.Exceptions.ActionFinishedException;

public class FairScheduler extends Scheduler {

    private int currentAction;

    public FairScheduler() {
    
    	super();
        currentAction = -1;
    
    }
    
    /**
     * Constructor
     * @param actions a list of actions the scheduler will work with.
     */
    public FairScheduler(List<Action> actions) {
    
    	super(actions);
        currentAction = -1;
        
    }
    
    /**
     * Does a step.
     * @throws ActionFinishedException
     */
    public void doStep() throws ActionFinishedException {
    	
    	currentAction++;
    	hasStarted = true;
    	
    	if(this.currentAction >= this.getActions().size())
            this.currentAction = 0;
    	
    	if(!this.getAction(currentAction).isFinished()) {
        
        	try {
            
        		this.getActions().get(this.currentAction).doStep();
            
	            if(this.getActions().get(this.currentAction).isFinished()) {
	            	
	            	System.out.println("An action is finished in fscheduler:"+this.getActions().get(this.currentAction).getClass().getName());
	                this.getActions().remove(this.currentAction);
	                
	            }
            
        	} catch(NoSuchElementException e) {
        		
        		System.out.println("Taking resource failed!");
        		
        	}
        
        }
    
    }

}
