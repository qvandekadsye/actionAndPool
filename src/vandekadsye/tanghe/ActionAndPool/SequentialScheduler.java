package vandekadsye.tanghe.ActionAndPool;

import java.util.List;

public class SequentialScheduler extends Scheduler {

    public SequentialScheduler() {
    
        super();
    
    }
    
    public SequentialScheduler(List<Action> actions) {
    
        super(actions);
    
    }

    public void doStep() {
        
        if(!this.isFinished()) {
        
            this.getActions().get(0).doStep();
            if (this.getActions().get(0).isFinished())
                this.getActions().remove(0);
        
        }
        
    }

}
