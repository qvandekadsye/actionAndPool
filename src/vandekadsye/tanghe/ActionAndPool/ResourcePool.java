package vandekadsye.tanghe.ActionAndPool;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public abstract class ResourcePool<R>
{

	protected List<R> resources;
	protected List<R> providedResources;

	public ResourcePool(int nbResources) {

		this.resources = new ArrayList<R>();
		for(int i = 0; i < nbResources; i++) {
			
			// this.resources.add(new R()); → interdit
			this.resources.add(createInstanceOfR());

		}
	}

	public R provideResource() throws NoSuchElementException {

		if(resources.isEmpty())
			throw new NoSuchElementException();
		R resource = resources.get(0);
		resources.remove(0);
		providedResources.add(resource);
		
		return resource;

	}

	public void freeResource(R resource) throws IllegalArgumentException {

		int index = 0;
		
		for(int i = 0; i < providedResources.size(); i++) {
			if(resource.equals(providedResources.get(i))) {
				index = i;
				i = providedResources.size();
			}
		}
		
		resources.add(resource);
		providedResources.remove(index);

	}

	public abstract R createInstanceOfR();

}
