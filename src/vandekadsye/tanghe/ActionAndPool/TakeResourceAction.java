package vandekadsye.tanghe.ActionAndPool;

import vandekadsye.tanghe.ActionAndPool.Exceptions.ActionFinishedException;

public class TakeResourceAction extends Action {
	private ResourcePool pool;
	private ResourcefulUser user;
	
	/**
	 * @param poolToUse The pool of resource to use.
	 * @param aUser The user who will store the resource.
	 */
	public TakeResourceAction(ResourcePool poolToUse, ResourcefulUser aUser)
	{
		this.pool=poolToUse;
		this.user = aUser;
	}

	@Override
	public boolean isReady() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isInProgress() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void doStep() throws ActionFinishedException {
		// TODO Auto-generated method stub
		
	}

}
