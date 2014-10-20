package vandekadsye.tanghe.ActionAndPool;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;


/**
 * Pool of resources. Must be extended.
 * @param <R> the resource to manage in the pool.
 */
public abstract class ResourcePool<R>
{

	protected List<R> resources;
	protected List<R> providedResources;

	/**
	 * Class constructor
	 * @param nbResources the number of resources that the pool will have to manage.
	 */
	public ResourcePool(int nbResources) {

		this.resources = new ArrayList<R>();
		for(int i = 0; i < nbResources; i++) {
			
			// this.resources.add(new R()); → interdit
			this.resources.add(createInstanceOfR());

		}
	}

	/**
	 * Provides a free resource and makes it become not free.
	 * @return a free resource that can be used
	 * @throws NoSuchElementException thrown if there is no resource available. 
	 */
	public R provideResource() throws NoSuchElementException {

		if(resources.isEmpty())
			throw new NoSuchElementException();
		R resource = resources.get(0);
		resources.remove(0);
		providedResources.add(resource);
		
		return resource;

	}

	/**
	 * Makes a provided resource become free
	 * @param resource the provided resource to make free
	 * @throws IllegalArgumentException thrown if the resource is not provided.
	 */
	public void freeResource(R resource) throws IllegalArgumentException {
		
		/**
		 * Should contain the index of the resource in the providedResources attribute.
		 * If the resource is not in the list, then <code>index = -1</code>, so the
		 * IllegalArgumentException is sent.
		 */
		int index = -1;
		
		for(int i = 0; i < providedResources.size(); i++) {
			if(resource.equals(providedResources.get(i))) {
				index = i;
				i = providedResources.size();
			}
		}
		
		if(index == -1)
			throw new IllegalArgumentException();
		
		resources.add(resource);
		providedResources.remove(index);

	}

	/**
	 * Used by the constructor, creates an instance of a resource (necessary to create an instance of a
	 * generic type class. Must be implemented by the subclasses of this class.
	 * @return the instance of the resource.
	 */
	public abstract R createInstanceOfR();

}
