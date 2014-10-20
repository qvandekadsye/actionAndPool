package vandekadsye.tanghe.ActionAndPool;

import java.util.List;

import vandekadsye.tanghe.ActionAndPool.Exceptions.ActionFinishedException;

public class SequentialScheduler extends Scheduler {

    public SequentialScheduler() {
    
        super();
    
    }
    
    public SequentialScheduler(List<? extends Action> actions) {
    
        super(actions);
    
    }

    public void doStep() throws ActionFinishedException {
        
        if(!this.isFinished()) {
        
            this.getActions().get(0).doStep();
            if (this.getActions().get(0).isFinished())
                this.getActions().remove(0);
        
        }
        
    }

}
