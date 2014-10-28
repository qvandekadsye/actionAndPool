package vandekadsye.tanghe.ActionAndPool;

import java.util.NoSuchElementException;

import vandekadsye.tanghe.ActionAndPool.Exceptions.ActionFinishedException;

public class TakeResourceAction<R extends Resource> extends Action {
	private ResourcePool<R> pool;
	private ResourcefulUser<R> user;
	private boolean hasStarted;
	
	/**
	 * @param poolToUse The pool of resource to use.
	 * @param aUser The user who will store the resource.
	 */
	public TakeResourceAction(ResourcePool<R> poolToUse, ResourcefulUser<R> aUser)
	{
		this.pool=poolToUse;
		this.user = aUser;
		
		hasStarted = false;
	}

	@Override
	public boolean isReady() {
		if(!hasStarted && !isFinished())
    		return true;
    	else
    		return false;
	}

	@Override
	public boolean isInProgress() {
		if(!isFinished() && !isReady())
			return true;
		else
			return false;
	}

	@Override
	public boolean isFinished() {
		if(user.getResource()==null)
		{
			return false;
		}
			
		else
		{
			return true;
		}
	}

	@Override
	public void doStep() throws ActionFinishedException {
		
		hasStarted = true;
		
		System.out.print("trying to take resource from pool " +this.pool.getResourceType()+"... ");
		if(!isFinished())
		{
			try {
				user.setResource(pool.provideResource());
				System.out.println("success");
			} catch(NoSuchElementException e) {
				System.out.println("failed");
			}
			
		}
		else
			throw new ActionFinishedException();
		
	}

}
