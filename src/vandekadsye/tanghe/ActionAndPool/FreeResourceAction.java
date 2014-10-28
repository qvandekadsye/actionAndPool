package vandekadsye.tanghe.ActionAndPool;

import vandekadsye.tanghe.ActionAndPool.Exceptions.ActionFinishedException;

public class FreeResourceAction<R extends Resource> extends Action{
	private ResourcePool<R> pool;
	private ResourcefulUser<R> user;
	private boolean hasStarted;
	
	/**
	 * @param poolToUse the pool taking the resource.
	 * @param aUser the user that will release the resource.
	 */
	public FreeResourceAction(ResourcePool<R> poolToUse, ResourcefulUser<R> aUser)
	{
		this.pool=poolToUse;
		this.user=aUser;
		
		hasStarted = false;
	}

	@Override
	public boolean isReady() {
		if(!isInProgress() && !isFinished())
			return true;
		else
			return false;
	}

	@Override
	public boolean isInProgress() {
		return (hasStarted && !isFinished());
	}

	@Override
	public boolean isFinished() {
		if(user.getResource()!=null)
		{
			System.out.println("Resource is not free");
			return false;
		}
		else
		{
			System.out.println("freeing resource from pool " + pool.getResourceType());
			return true;
		}
	}

	@Override
	public void doStep() throws ActionFinishedException {
		
		hasStarted = true;
		
		if(!isFinished())
		{
			pool.freeResource(user.getResource());
			user.resetResource();
		}
		else
			throw new ActionFinishedException();
	}

}
