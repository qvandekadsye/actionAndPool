public class TestResourcePool extends JUnit {

    public class ResourceForTest implements Resource {

        public String description() {
        
            return "For test";
        
        }

    }

    @Test
    public void testProvideResource()  {
        
        ResourcePool<ResourceForTest> pool = new ResourcePool<ResourceForTest>(1);
        ResourceForTest res = pool.provideResource();
        assertNotNull(res);

        try {
            pool.provideResource();
            fail();
        } catch(NoSuchElementException e) {
            assertTrue(true);
        }
        
    }
    
    
    @Test(expected=IllegalArgumentException)
    public void testFreeResource() throws IllegalArgumentException {
    
        ResourcePool r = new ResourcePool();
        r.freeResource();
    
    }

}
