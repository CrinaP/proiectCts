package testPackage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import static junit.framework.Assert.assertEquals;
import junit.framework.TestCase;
import model.Produs;


public class TestProdus extends TestCase {
    private static BufferedReader reader;
    
	
	public static void setUpBeforeClass() throws Exception {
		reader = new BufferedReader(new FileReader("Date.txt"));
	}

	
	public static void tearDownAfterClass() throws Exception {
		reader.close();
	}
    
    Produs p ;
    Produs p2;
    Produs p3;
    
    public TestProdus(String testName) {
        super(testName);
    }
    
    @Override
    protected void setUp() throws Exception {
        p = new Produs(105, "Prd001", 150.5, 3);
        p2= new Produs(200,"Prod002", 254.3, 2);
       p3=new Produs("Crina");
        super.setUp();
    }
    
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
    
    
    public void testUpperCase()
    {
        assertEquals("Prd001", p.getNume());
    }
   
    

    // Testam sa vedem daca se poate crea o noua instanta de produse
    public void testConstructor() {
            boolean correct = true;
            try{
                    ArrayList<Produs> list = new ArrayList<>();
                    list.add(p);
                    new Produs(list);
            }catch(Exception e){
                    correct = false;
            }
            assertTrue(correct);
	}
    
    // Testam sa vedem daca lista din instanta de Produse este la fel cu lista pe care o pasam ca parametru la instantierea lui Produse
	
	public void testConstructor2() throws Exception{
		ArrayList<Produs> list = new ArrayList<>();
		list.add(p2);
		
		Produs produs = new Produs(list);
		assertEquals(list, produs.getListaProduse());
	}
        
        public void testgetPret()
        {
            assertEquals(254.3, p2.getPret());
        }
        
        public void testMaxPret(){
            Double pret = p.getPret();
            boolean ok;
            if(pret < Double.MAX_VALUE)
                ok = true;
            else
                ok=false;
            assertEquals(true, ok);
      
        }
        
        public void testListaProduseNotNULL(){
            ArrayList<Produs> lista = new ArrayList<Produs>();
            lista.add(p);
            assertNotNull(lista);
		
	}
        
        public void testListaGoala()
        {
            ArrayList<Produs> lst = new ArrayList<Produs>();
            lst = null;
            assertNull(lst);
        }

        
        public void testProdus() {
		Produs p = new Produs(4);
		Produs pr= p.returneaza(p, 5);
		
		assertSame(p, pr);
	}
        
        
}

  