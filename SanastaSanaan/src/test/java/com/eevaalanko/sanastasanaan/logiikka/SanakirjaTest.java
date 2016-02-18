/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eevaalanko.sanastasanaan.logiikka;

import java.util.ArrayList;
import java.util.Arrays;

import java.util.Collection;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;

/**
 *
 * @author Eeva
 */
public class SanakirjaTest {

    static ArrayList lista;
    static ArrayList tyhjaLista;
    static Sanakirja sanakirja;

    @BeforeClass
    public static void setUpClass() throws Exception {
        lista = new ArrayList<>();
        lista.add("testisana1");
        tyhjaLista = new ArrayList<>();
        sanakirja = new Sanakirja();
        sanakirja.lisaaSanalista("test2", tyhjaLista);
        sanakirja.lisaaSanalista("test", lista);

    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    /**
     * Test of lisaaSanalista method, of class Sanakirja.
     */
    @Test
    public void testLisaaSanalista() {
        ArrayList lista2 = sanakirja.annaSanalista("test");
        assertEquals(Arrays.asList("testisana1"), lista2);
    }

    /**
     * Test of poistaSanalista method, of class Sanakirja.
     */
    @Test
    public void testPoistaSanalista() {
        sanakirja.poistaSanalista("test");
        assertEquals(sanakirja.annaSanalista("test"), null);
    }

    /**
     * Test of annaSanalista method, of class Sanakirja. //
     */
    @Test
    public void testAnnaSanalista() {
        sanakirja.lisaaSanalista("test", lista);
        assertEquals(sanakirja.annaSanalista("test"), lista);
    }

    /**
     * Test of annaAvainsanat method, of class Sanakirja.
     */
    @Test
    public void testAnnaAvainsanat() {
        Collection avainlista = sanakirja.annaAvainsanat();
        Object[] l = avainlista.toArray();
        List k = Arrays.asList(l);
        assertEquals(Arrays.asList("test2", "test"), k);
    }

    @Test
    public void testLaskeSanaLista() {
        int maara = sanakirja.laskeSanalista("test");
        assertEquals(maara, 1);
    }

    @Test
    public void testLaskeOlematonSanaLista() {
        int maara = sanakirja.laskeSanalista("vaara");
        assertEquals(maara, 0);
    }

    @Test
    public void testLaskeTyhjaSanaLista() {
        int maara = sanakirja.laskeSanalista("test2");
        assertEquals(maara, 0);
    }
}
