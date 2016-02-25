/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eevaalanko.sanastasanaan.logiikka.tietovarasto;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.w3c.dom.Node;

/**
 *
 * @author Eeva
 */
public class SanavarastoTest {

    static Sanavarasto varasto;

    @BeforeClass
    public static void setUpClass() {
        varasto = new Sanavarasto();
    }

    /**
     * Test of haeNodelista method, of class Sanavarasto.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testHaeNodelista() throws Exception {
        Node result = varasto.haeNodelista();
        assertNotNull(result);
    }

    /**
     * Test of hae method, of class Sanavarasto.
     */
    @Test
    public void testHae() throws Exception {
        varasto.hae();
        Object[] o = varasto.sanakirja.annaAvainsanat();
        ArrayList lista = varasto.sanakirja.annaSanalista((String) o[0]);
        assertNotNull(o);
        assertNotNull(lista);
    }

    public void testHaeUsempiOikea() throws Exception {
        varasto.hae(5);
        int maara = varasto.sanakirja.sanasto.size();
        assertEquals(maara, 5);
    }

    public void testHaeUseampiVaara() throws Exception {
        varasto.hae(5);
        int maara = varasto.sanakirja.sanasto.size();
        assertEquals((maara==6),false);
    }

    /**
     * Test of haeAnnetullaSanalla method, of class Sanavarasto.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testHaeAnnetullaSanalla() throws Exception {
        varasto.haeAnnetullaSanalla("öylätti");
        ArrayList lista = varasto.sanakirja.annaSanalista("öylätti");
        Object[] oletusarray = {"IT", "itä", "lätti", "lätti", "lätty", "työ", "täi", "täti", "yli", "yli-", "yliö", "yltä", "ylä-", "YT", "yö", "äly", "öylätti"};
        Assert.assertArrayEquals(lista.toArray(), oletusarray);
    }

}
