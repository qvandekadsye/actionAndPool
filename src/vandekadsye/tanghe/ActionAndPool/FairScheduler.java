package vandekadsye.tanghe.ActionAndPool;

import java.util.List;

public class FairScheduler extends Scheduler {

    private int currentAction;

    public FairScheduler() {
    
        currentAction = 0;
        super();
    
    }
    
    public FairScheduler(List<Action> actions) {
    
        currentAction = 0;
        super(actions);
    
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
