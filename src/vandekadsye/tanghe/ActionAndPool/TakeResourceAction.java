package vandekadsye.tanghe.ActionAndPool;

import vandekadsye.tanghe.ActionAndPool.Exceptions.ActionFinishedException;

public class TakeResourceAction<R extends Resource> extends Action {
	private ResourcePool<R> pool;
	private ResourcefulUser<R> user;
	
	/**
	 * @param poolToUse The pool of resource to use.
	 * @param aUser The user who will store the resource.
	 */
	public TakeResourceAction(ResourcePool<R> poolToUse, ResourcefulUser<R> aUser)
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
