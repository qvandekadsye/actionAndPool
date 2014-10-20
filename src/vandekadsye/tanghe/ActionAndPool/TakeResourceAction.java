package vandekadsye.tanghe.ActionAndPool;

import vandekadsye.tanghe.ActionAndPool.Exceptions.ActionFinishedException;

public class TakeResourceAction extends Action {
	private ResourcePool<Resource> pool;
	private ResourcefulUser<Resource> user;
	
	/**
	 * @param poolToUse The pool of resource to use.
	 * @param aUser The user who will store the resource.
	 */
	public TakeResourceAction(ResourcePool<Resource> poolToUse, ResourcefulUser<Resource> aUser)
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
		if(user.getResource()==null)
			return false;
		else
			return true;
	}

	@Override
	public void doStep() throws ActionFinishedException {
		if(isReady())
		{
			user.setResource(pool.provideResource());
			
		}
		
	}

}
