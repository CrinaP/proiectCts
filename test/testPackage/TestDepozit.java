

package testPackage;

import junit.framework.TestCase;
import model.Depozit;


public class TestDepozit extends TestCase  {
    
    Depozit d;
    Depozit d2;
    
    public TestDepozit(String testName) {
        super(testName);
    }
    
    @Override
    protected void setUp() throws Exception {
        
       d=new Depozit(001, "Lemne");
       d2=new Depozit("Maria");
        
        super.setUp();
    }
    
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

   public void testMaxID(){
            int id = d.getId();
            boolean ok;
            if(id < Integer.MAX_VALUE)
                ok = true;
            else
                ok=false;
            assertEquals(true, ok);
      
        }
   
   public void testNume()
    {
        assertEquals("Maria", d2.getNume());
    }
  
}
