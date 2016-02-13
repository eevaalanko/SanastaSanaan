/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eevaalanko.sanastasanaan.logiikka;

import com.eevaalanko.sanastasanaan.tietovarasto.Sanavarasto;
import java.util.ArrayList;
import java.util.Collection;
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
public class HyvaksytytSanatTest {

    static Sanavarasto varasto;
    static ArrayList lista;
    static HyvaksytytSanat instance;

    public HyvaksytytSanatTest() {
//        varasto.sanakirja.annaSanalista("TESTI");

    }

    public void testTarkistaOikeaAvainsana() {
        boolean b = instance.tarkistaAvainsana("TESTI");
        boolean c = varasto.sanakirja.annaAvainsanat().contains("TESTI");
        assertEquals(b, c);
    }

    public void testTarkistaVaaraAvainsana() {
        boolean b = instance.tarkistaAvainsana("VAARA");
        boolean c = varasto.sanakirja.annaAvainsanat().contains("VAARA");
        assertEquals(b, c);
    }

    public void testTarkistaMuuttuukoOikeallaAvainsanalla() {
        instance.tarkistaAvainsana("TESTI");
        String avainsana = instance.avainsana;
        assertEquals(avainsana, "TESTI");
    }

    public void testTarkistaMuuttuukoVaarallaAvainsanalla() {
        instance.tarkistaAvainsana("VAARA");
        String avainsana = instance.avainsana;
        assertEquals(avainsana, "");
    }

    public void testTarkistaOnko() {
        Collection c = varasto.sanakirja.annaAvainsanat();
// then
        assertTrue(c.contains("TESTI"));
    }
        public void testTarkistaEikoOle() {
        Collection c = varasto.sanakirja.annaAvainsanat();
// then
        assertFalse(c.contains("ftftft"));
    }
//
//    public void testTarkistaVaaraSana() {
//        String tarkistettava = "wrongWord";
//        String avainsana = "TESTI";
//        boolean expResult = false;
//        boolean result = instance.tarkistaSana(avainsana);
//        assertEquals(expResult, result);
//    }
//
//    public void testTarkistaOikeaSana() {
//        String tarkistettava = "testisana1";
//        String avainsana = "test";
//        boolean expResult = true;
//        boolean result = instance.tarkistaSana("te");
//        assertEquals(expResult, result);
//    }
//
//    public void testOnJoLisattyEiOle() {
//        String lisattySana = "testisana1";
//        boolean onJoLisatty = instance.onJoLisatty(lisattySana);
//        assertEquals(onJoLisatty, false);
//    }
//
//    public void testOnJoLisatty() {
//        String lisattySana = "testisana1";
//        boolean onJoLisatty = instance.onJoLisatty(lisattySana);
//        assertEquals(onJoLisatty, true);
//    }
//
//    public void testLisaaOikeaSana() {
//        boolean lisaaSana = instance.lisaaSana("test", "testisana1");
//        assertEquals(lisaaSana, true);
//    }
//
//    public void testLisaaVaaraSana() {
//        boolean lisaaSana = instance.lisaaSana("test", "testisana3");
//        assertEquals(lisaaSana, false);
//    }
//
//    public void testLisaaLisattySana() {
//        boolean lisaaSanaUudestaan = instance.lisaaSana("test", "testisana1");
//        assertEquals(lisaaSanaUudestaan, false);
//
//    }
//
//    public void testLaskeSanatJosTyhja() {
//        instance.poistaSana("testisana1");
//        int maara = instance.laskeSanat();
//        assertEquals(maara, 0);
//    }
//
//    public void testLaskeSanat() {
//        int maara = instance.laskeSanat();
//        assertEquals(maara, 1);
//    }

}
