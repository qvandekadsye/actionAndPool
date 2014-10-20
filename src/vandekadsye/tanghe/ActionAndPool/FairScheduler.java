package vandekadsye.tanghe.ActionAndPool;

import java.util.List;

import vandekadsye.tanghe.ActionAndPool.Exceptions.ActionFinishedException;

public class FairScheduler extends Scheduler {

    private int currentAction;

    public FairScheduler() {
    
    	super();
        currentAction = 0;
        
    
    }
    
    /**
     * Constructor
     * @param actions a list of actions the scheduler will work with.
     */
    public FairScheduler(List<Action> actions) {
    
    	super(actions);
        currentAction = 0;
        
    
    }
    
    /**
     * Does a step.
     * @throws ActionFinishedException
     */
    public void doStep() throws ActionFinishedException {
    
        if(!this.isFinished()) {
        
            this.getActions().get(this.currentAction).doStep();
            if(this.getActions().get(this.currentAction).isFinished())
                this.getActions().remove(this.currentAction);
            
            else {
            
                this.currentAction++;
                if(this.currentAction > this.getActions().size())
                    this.currentAction = 0;
                
            }
        
        }
    
    }

}
