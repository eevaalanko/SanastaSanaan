/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eevaalanko.sanastasanasaan.gui;

import java.io.IOException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Eeva
 */
public class SanastaSanaanGuiTest {
    
    public SanastaSanaanGuiTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of asetteleKomponentit method, of class SanastaSanaanGui.
     */
    @Test
    public void testAsetteleKomponentit() throws IOException {
        System.out.println("asetteleKomponentit");
        SanastaSanaanGui instance = new SanastaSanaanGui();
        instance.asetteleKomponentit();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class SanastaSanaanGui.
     */
    @Test
    public void testMain() throws Exception {
        System.out.println("main");
        String[] args = null;
        SanastaSanaanGui.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
