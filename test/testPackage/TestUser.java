package testPackage;



import controllers.MainController;
import junit.framework.TestCase;
import model.User;

public class TestUser extends TestCase {
    
    User u;
    User user;
    
    
    
    public TestUser(String testName) {
        super(testName);
    }
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
        u = new User("Crina","1234");
        u.setCNP("2930710175922");
        user = new User("CrinaP", "236sab*vd");
    }
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
   //@Override
    
    public void testParola()
    {
        assertEquals("236sab*vd", user.getParola());
    }
    
    
    public void testGetSex() {

		String sex = null;
                String userSex = u.getSex();

		if ((Integer.parseInt("" + u.getCNP().charAt(0))) % 2 == 0) {
			sex = "F";
		} else {
			sex = "M";
		}
		assertEquals(sex, userSex);
	}
    public void testVarsta() { 
		int varsta = u.getVarsta();
                assertEquals(22, varsta);
		System.out.println(u.getVarsta());
	}
	
    public void testeVarsta2()
    {
        int varsta=u.getVarsta();
        String valoare=null;
        if(varsta>18)
            valoare="major";
        if(varsta<18)
            valoare="minor";
        assertEquals("major", valoare);
        
    }
    public void testgetCNP() {
		int prima= Integer.parseInt("" +u.getCNP().charAt(0));
		String val=null;
		if(prima>=1&&prima<=6){
			val="roman";
		}
		else{
			val="strain";
		}
		assertEquals("roman", val);
	}
    
  
	public void testcheckCNP() {
            User user=new User(101, "ionela21", "ionela", "2931021394066");
	    assertTrue(user.checkCNP());
	}
        
          public void testSingletonNotNull()
    {
        MainController c=MainController.getInstance();
        assertNotNull(c);
    }
    
}
