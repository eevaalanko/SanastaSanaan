/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eevaalanko.sanastasanaan.tietovarasto;

import java.util.ArrayList;
import java.util.HashMap;
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
public class SanakirjaTest {

    static HashMap< String, ArrayList> sTest;
    static Sanakirja instance;
    static ArrayList lista = null;

    public SanakirjaTest() {
        sTest = new HashMap<>();
        instance = new Sanakirja();
    }

    @Before
    public void setUp() {
    }

    /**
     * Test of lisaaSanalista method, of class Sanakirja.
     */
    @Test
    public void testLisaaSanalista() {
        instance.lisaaSanalista("test", lista);
        assertEquals(instance.annaSanalista("test"), lista);
        fail("The test case is a prototype.");
    }

    /**
     * Test of poistaSanalista method, of class Sanakirja.
     */
    @Test
    public void testPoistaSanalista() {
        lista.add("testisana");
        instance.lisaaSanalista("test", lista);
        instance.poistaSanalista("test");

        assertEquals(instance.annaSanalista("test"), null);
    }

    /**
     * Test of annaSanalista method, of class Sanakirja.
     */
    @Test
    public void testAnnaSanalista() {
        instance.lisaaSanalista("test", lista);
        assertEquals(instance.annaSanalista("test"), lista);

    }

    /**
     * Test of annaAvainsanat method, of class Sanakirja.
     */
    @Test
    public void testAnnaAvainsanat() {
        lista.add("testisana");
        instance.lisaaSanalista("test", lista);
        Object[] testi = instance.annaAvainsanat();
        assertEquals(testi.toString(), "test");

    }

}
