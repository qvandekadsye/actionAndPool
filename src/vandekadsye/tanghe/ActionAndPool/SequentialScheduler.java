package vandekadsye.tanghe.ActionAndPool;

import java.util.List;

import vandekadsye.tanghe.ActionAndPool.Exceptions.ActionFinishedException;

public class SequentialScheduler<A extends Action> extends Scheduler {

	public SequentialScheduler() {	
    
        super();
    
    }
    
    public SequentialScheduler(List<A> actions) {
    
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
