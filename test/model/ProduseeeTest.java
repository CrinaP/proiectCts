/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import junit.framework.TestCase;

/**
 *
 * @author Crina-pc
 */
public class ProduseeeTest extends TestCase {
    
    public ProduseeeTest(String testName) {
        super(testName);
    }
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }
    
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * Test of add method, of class Produseee.
     */
    public void testAdd() {
        System.out.println("add");
        String a = "";
        String b = "";
        Produseee instance = new Produseee();
        int expResult = 0;
        int result = instance.add(a, b);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
