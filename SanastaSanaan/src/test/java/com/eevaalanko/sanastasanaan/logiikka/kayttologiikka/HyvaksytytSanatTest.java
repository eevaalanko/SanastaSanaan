/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eevaalanko.sanastasanaan.logiikka.kayttologiikka;

import com.eevaalanko.sanastasanaan.logiikka.tietovarasto.Sanavarasto;
import java.io.IOException;
import java.util.ArrayList;
import javax.xml.parsers.ParserConfigurationException;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.xml.sax.SAXException;

/**
 *
 * @author Eeva
 */
public class HyvaksytytSanatTest {

    static Sanavarasto varasto;
    static ArrayList lista;
    static HyvaksytytSanat instance;

    @Before
    public void setUp() throws ParserConfigurationException, SAXException, IOException  {
        varasto = new Sanavarasto();
        varasto.haeAnnetullaSanalla("öylätti");
        instance = new HyvaksytytSanat("öylätti", varasto);
        instance.lisaaSana("lätti");
    }

    @Test
    public void testTarkistaOikeaSana() {
        boolean b = instance.tarkistaSana("itä");
        assertEquals(b, true);
    }

    @Test
    public void testTarkistaVaaraSana() {
        boolean b = instance.tarkistaSana("vaara");
        assertEquals(b, false);
    }

    @Test
    public void testTarkistaVaaraAvainsana() {
        HyvaksytytSanat instance2 = new HyvaksytytSanat("vaaraSana",varasto);
        boolean b = instance2.tarkistaSana("sana");
        assertEquals(b, false);
    }

    @Test
    public void testLisaaSana() {
        boolean b = instance.lisaaSana("itä");
        assertEquals(b, true);
    }

    @Test
    public void testLisaaLisattySana() {
        boolean b = instance.lisaaSana("lätti");
        assertEquals(b, false);
    }

    @Test
    public void testLisaaVaaraSana() {
        boolean b = instance.lisaaSana("vaara");
        assertEquals(b, false);
    }

    @Test
    public void testOnJoLisatty() {
        boolean b = instance.onJoLisatty("lätti");
        assertEquals(b, true);
    }

    @Test
    public void testEiOleLisatty() {
        boolean b = instance.onJoLisatty("itä");
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
