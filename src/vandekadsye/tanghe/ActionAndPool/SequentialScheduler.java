package vandekadsye.tanghe.ActionAndPool;

import java.util.List;

import vandekadsye.tanghe.ActionAndPool.Exceptions.ActionFinishedException;

public class SequentialScheduler extends Scheduler {

	public SequentialScheduler() {	
    
        super();
    
    }
    
    public SequentialScheduler(List<Action> actions) {
    
        super(actions);
    
    }

    public void doStep() throws ActionFinishedException {
        
        if(!this.isFinished()) {
        
            ((Action) this.getActions().get(0)).doStep();
            
            if (((Action) this.getActions().get(0)).isFinished())
            {	
            
                this.getActions().remove(0);
            }
            
            hasStarted = true;
        
        }
        
        else
        	throw new ActionFinishedException();
        
    }

}
