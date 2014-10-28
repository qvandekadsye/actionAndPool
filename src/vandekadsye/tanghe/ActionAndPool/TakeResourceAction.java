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
		if(!isInProgress() && !isFinished())
    		return true;
    	else
    		return false;
	}

	@Override
	public boolean isInProgress() {
		if(isFinished()==false && isReady()==false)
			return true;
		else
			return false;
	}

	@Override
	public boolean isFinished() {
		if(user.getResource()==null)
		{
			System.out.println("Ressource is not taken");
			return false;
		}
			
		else
		{
			System.out.println("Ressource is taken");
			return true;
		}
	}

	@Override
	public void doStep() throws ActionFinishedException {
		System.out.println("Trying to take " +this.pool.getClass().getName());
		if(!isReady())
		{
			user.setResource(pool.provideResource());
			
		}
		
	}

}
