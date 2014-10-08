package vandekadsye.tanghe.ActionAndPool;

import java.util.List;

public class FairScheduler extends Scheduler {

    private int currentAction;

    public FairScheduler() {
    
    	super();
        currentAction = 0;
        
    
    }
    
    public FairScheduler(List<Action> actions) {
    
    	super(actions);
        currentAction = 0;
        
    
    }
    
    public void doStep() {
    
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
