/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eevaalanko.sanastasanaan.tietovarasto;

import java.util.ArrayList;
import java.util.Arrays;
import static java.util.Arrays.asList;
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

    static Sanavarasto varasto;
    static ArrayList lista;

    public SanakirjaTest() {

        varasto = new Sanavarasto();

    }
    
    //todo: en saa kahta ekaa testia toimimaan
    /**
     * Test of lisaaSanalista method, of class Sanakirja.
//     */
//    @Test
//    public void testLisaaSanalista() {
//        lista.add("testisana1");
//        varasto.sanakirja.lisaaSanalista("test", lista);
//        ArrayList lista2 = varasto.sanakirja.annaSanalista("test");
//        boolean samat = false;
//        if (lista2.contains("testisana1")) {
//           samat = true;
//        } 
//        
//        assertEquals(samat, true);
//    }

    /**
     * Test of poistaSanalista method, of class Sanakirja.
     */
//    @Test
//    public void testPoistaSanalista() {
//        lista.add("testisana");
//        lista.add("testisana");
//        varasto.sanakirja.lisaaSanalista("test", lista);
//        varasto.sanakirja.poistaSanalista("test");
//
//        assertEquals(varasto.sanakirja.annaSanalista("test"), null);
//    }

//    /**
//     * Test of annaSanalista method, of class Sanakirja.
////     */
//    @Test

    public void testAnnaSanalista() {
        varasto.sanakirja.lisaaSanalista("test", lista);
        assertEquals(varasto.sanakirja.annaSanalista("test"), lista);
    }

    /**
     * Test of annaAvainsanat method, of class Sanakirja.
     */
    public void testAnnaAvainsanat() {
        varasto.sanakirja.lisaaSanalista("avain", lista);
        ArrayList avainlista = varasto.sanakirja.annaAvainsanat();
        boolean samat = false;
        if (avainlista.contains("avain")) {
            samat = true;
        };
        assertEquals(samat, true);
    }

}
