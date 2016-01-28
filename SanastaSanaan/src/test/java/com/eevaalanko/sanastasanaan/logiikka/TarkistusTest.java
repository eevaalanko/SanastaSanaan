/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eevaalanko.sanastasanaan.logiikka;

import com.eevaalanko.sanastasanaan.tietovarasto.Sanakirja;
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
public class TarkistusTest {

    static Sanakirja kirja;
    static HyvaksytytSanat hyvaksytytsanat;

    public TarkistusTest() {
        ArrayList lista = new ArrayList<>();
        lista.add("testisana1");
        lista.add("testsana2");
        kirja = new Sanakirja();
        kirja.lisaaSanalista("test", lista);
    }


    @Test
    public void testTarkistaVaaraSana() {

        String tarkistettava = "wrongWord";
        HyvaksytytSanat instance = new HyvaksytytSanat();
        boolean expResult = false;
        boolean result = instance.tarkistaSana(tarkistettava, kirja);
        assertEquals(expResult, result);
    }

    public void testTarkistaOikeaSana() {

        String tarkistettava = "testisana1";
        HyvaksytytSanat instance = new HyvaksytytSanat();
        boolean expResult = true;
        boolean result = instance.tarkistaSana(tarkistettava, kirja);
        assertEquals(expResult, result);
    }

}
