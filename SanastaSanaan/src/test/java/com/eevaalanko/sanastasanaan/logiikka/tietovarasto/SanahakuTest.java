/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eevaalanko.sanastasanaan.logiikka.tietovarasto;

import static com.eevaalanko.sanastasanaan.logiikka.tietovarasto.Sanahaku.*;
import static com.eevaalanko.sanastasanaan.logiikka.tietovarasto.Sanavarasto.*;
import java.io.IOException;
import java.util.ArrayList;
import javax.xml.parsers.ParserConfigurationException;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

/**
 *
 * @author Eeva
 */
public class SanahakuTest {

    static Node nodelista;
    static int pituus;

    @BeforeClass
    public static void setUpClass() throws ParserConfigurationException, SAXException, IOException {
        nodelista = haeNodelista();
        pituus = laskePituus(nodelista);
    }

    /**
     * Test of haeRandomAvainSana method, of class Sanahaku.
     */
    @Test
    public void testHaeRandomAvainSana() {
        String result = haeRandomAvainSana(nodelista, pituus);
        assertNotNull(result);
    }

    @Test
    public void testHaeRandomAvainSanaPituus() {
        String result = haeRandomAvainSana(nodelista, pituus);
        int sananpituus = result.length();
        assert (sananpituus > 7);
    }

    /**
     * Test of minimipituus method, of class Sanahaku.
     */
    @Test
    public void testMinimipituus() {
        String sana = "testisana";
        boolean result = minimipituus(sana, 7);
        assertEquals(true, result);
    }

    @Test
    public void testVaaraMinimipituus() {
        String sana = "testi";
        boolean result = minimipituus(sana, 7);
        assertEquals(false, result);
    }

    /**
     * Test of laskePituus method, of class Sanahaku.
     */
    @Test
    public void testLaskePituus() {
        int oletuspituus = 188221;
        int pituus = laskePituus(nodelista);
        assertEquals(oletuspituus, pituus);

    }

    /**
     * Test of random method, of class Sanahaku.
     */
    @Test
    public void testRandom() {
        int result = random(pituus);
        assert (pituus >= result);

    }

    /**
     * Test of haeSanalista method, of class Sanahaku.
     */
    @Test
    public void testHaeSanalista() {
        String avainsana = "öylätti";
        ArrayList sanalista = haeSanalista(avainsana, nodelista);
        Object[] oletusarray = {"IT", "itä", "lätti", "lätti", "lätty", "työ", "täi", "täti", "yli", "yli-", "yliö", "yltä", "ylä-", "YT", "yö", "äly", "öylätti"};
        assertArrayEquals(sanalista.toArray(), oletusarray);
    }

    /**
     * Test of luoSanataulu method, of class Sanahaku.
     */
    @Test
    public void testLuoTyhjaSanataulu() {
        int[] sanataulu = luoSanataulu("");
        int[] oletusarray = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        assertArrayEquals(sanataulu, oletusarray);
    }

    public void testLuoSanataulu() {
        int[] sanataulu = luoSanataulu("abö");
        int[] oletusarray = {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1};
        assertArrayEquals(sanataulu, oletusarray);
    }

    /**
     * Test of vertaaTauluja method, of class Sanahaku.
     */
    @Test
    public void testVertaaTyhjiaTauluja() {
        int[] avainsanataulu = null;
        int[] sanataulu = null;
        boolean result = vertaaTauluja(avainsanataulu, sanataulu);
        assertEquals(false, result);
    }

    @Test
    public void testVertaaVaaranSananTaulua() {
        int[] avainsanataulu = {0, 0, 1};
        int[] sanataulu = {1, 0, 0};
        boolean result = vertaaTauluja(avainsanataulu, sanataulu);
        assertEquals(false, result);
    }

    @Test
    public void testVertaaOikeanSananTaulua() {
        int[] avainsanataulu = {0, 0, 1};
        int[] sanataulu = {0, 0, 1};
        boolean result = vertaaTauluja(avainsanataulu, sanataulu);
        assertEquals(true, result);
    }

}
