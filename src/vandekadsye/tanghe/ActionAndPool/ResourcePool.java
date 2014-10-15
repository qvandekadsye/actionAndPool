public abstract class ResourcePool<R>
{

	protected List<R> resources;

	public ResourcePool<R>(int nbResources) {

		this.resources = new ArrayList<R>();
		for(int i = 0; i < nbResources; i++) {
			
			// this.resources.add(new R()); → interdit
			this.resources.add(createInstanceOfR());

		}
	}

	public R provideResource() throws NoSuchElementException {

		// TODO write this method

	}

	public void freeResource(R resource) throws IllegalArgumentException {

		// TODO write this method

	}

	public abstract R createInstanceOfR();

}
