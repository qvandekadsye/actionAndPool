package vandekadsye.tanghe.ActionAndPool;

public class ResourcefulUser <R extends Resource> {
	protected R resource;
	
	/**
	 * @return the Resource of the ResourcefulUser
	 */
	public R getResource()
	{
		return resource;
	}
	
	/**
	 * Change the resource of the resourcefulUser
	 * @param resource is the new resource.
	 */
	public void setResource(R resource)
	{
		this.resource=resource;
	}
	
	/**
	 * Suppress th resource of the resourcefulUser.
	 */
	public void resetResource()
	{
		this.resource=null;
	}

}
