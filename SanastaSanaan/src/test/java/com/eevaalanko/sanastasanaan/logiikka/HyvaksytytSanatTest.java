/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eevaalanko.sanastasanaan.logiikka;

import com.eevaalanko.sanastasanaan.tietovarasto.Sanakirja;
import com.eevaalanko.sanastasanaan.tietovarasto.Sanavarasto;
import java.util.ArrayList;
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
        lista.add("testisana1");
        lista.add("testsana2");
        varasto.sanakirja.lisaaSanalista("test", lista);
        instance.lisaaSana("test", "testisana1");
    }

    public void testTarkistaVaaraSana() {
        String tarkistettava = "wrongWord";
        String avainsana = "test";
        boolean expResult = false;
        boolean result = instance.tarkistaSana(avainsana, tarkistettava);
        assertEquals(expResult, result);
    }

    public void testTarkistaOikeaSana() {
        String tarkistettava = "testisana1";
        String avainsana = "test";
        boolean expResult = true;
        boolean result = instance.tarkistaSana(avainsana, tarkistettava);
        assertEquals(expResult, result);
    }

    public void testOnJoLisattyEiOle() {
        String lisattySana = "testisana1";
        boolean onJoLisatty = instance.onJoLisatty(lisattySana);
        assertEquals(onJoLisatty, false);
    }

    public void testOnJoLisatty() {
        String lisattySana = "testisana1";
        boolean onJoLisatty = instance.onJoLisatty(lisattySana);
        assertEquals(onJoLisatty, true);
    }

    public void testLaskeSanat() {
        int maara = instance.laskeSanat();
        assertEquals(maara, 1);
    }

    public void testLisaaOikeaSana() {
        boolean lisaaSana = instance.lisaaSana("test", "testisana1");
        assertEquals(lisaaSana, true);
    }
    
        public void testLisaaVaaraSana() {
        boolean lisaaSana = instance.lisaaSana("test", "testisana3");
        assertEquals(lisaaSana, false);
    }
   public void testLisaaLisattySana(){
       instance.lisaaSana("test", "testisana1");
       boolean lisaaSanaUudestaan = instance.lisaaSana("test", "testisana1");
       assertEquals(lisaaSanaUudestaan, false);
       
   }
}
