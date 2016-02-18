/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eevaalanko.sanastasanaan.logiikka;

import com.eevaalanko.sanastasanaan.tietovarasto.Sanavarasto;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author Eeva
 */
public class HyvaksytytSanatTest {

    static Sanavarasto varasto;
    static ArrayList lista;
    static HyvaksytytSanat instance;

    @Before
    public void setUp() {
        instance = new HyvaksytytSanat("TESTI");
        instance.lisaaSana("te");
    }

    @Test
    public void testTarkistaOikeaSana() {
        boolean b = instance.tarkistaSana("te");
        assertEquals(b, true);
    }

    @Test
    public void testTarkistaVaaraSana() {
        boolean b = instance.tarkistaSana("vaara");
        assertEquals(b, false);
    }

    @Test
    public void testTarkistaVaaraAvainsana() {
        HyvaksytytSanat instance2 = new HyvaksytytSanat();
        boolean b = instance2.tarkistaSana("sana");
        assertEquals(b, false);
    }

    @Test
    public void testLisaaSana() {
        boolean b = instance.lisaaSana("se");
        assertEquals(b, true);
    }

    @Test
    public void testLisaaLisattySana() {
        boolean b = instance.lisaaSana("te");
        assertEquals(b, false);
    }

    @Test
    public void testLisaaVaaraSana() {
        boolean b = instance.lisaaSana("vaara");
        assertEquals(b, false);
    }

    @Test
    public void testOnJoLisatty() {
        boolean b = instance.onJoLisatty("te");
        assertEquals(b, true);
    }

    @Test
    public void testEiOleLisatty() {
        boolean b = instance.onJoLisatty("se");
        assertEquals(b, false);
    }

    @Test
    public void testPoistaSanat() {
        instance.poistaSanat();
        assertEquals(instance.laskeSanat(), 0);
    }

    @Test
    public void testLaskeSanatJosTyhja() {
        instance.poistaSanat();
        int maara = instance.laskeSanat();
        assertEquals(maara, 0);
    }

    @Test
    public void testLaskeSanat() {
        int maara = instance.laskeSanat();
        assertEquals(maara, 1);
    }

}
