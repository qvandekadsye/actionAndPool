package vandekadsye.tanghe.ActionAndPool;

import vandekadsye.tanghe.ActionAndPool.Exceptions.ActionFinishedException;

public abstract class Action {
	
	/**
	 * @return whether if the action is ready or not.
	 */
	public abstract boolean isReady();
	
	/**
	 * @return whether if the action is in progress or not
	 */
	public abstract boolean isInProgress();

    /**
     * @return whether if the action is finished or not
     */
    public abstract boolean isFinished();
    
    /**
     * Do a new step in the action
     */
    public abstract void doStep() throws ActionFinishedException;

}
