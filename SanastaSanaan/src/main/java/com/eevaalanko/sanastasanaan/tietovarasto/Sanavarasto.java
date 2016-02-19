/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eevaalanko.sanastasanaan.tietovarasto;

import com.eevaalanko.sanastasanaan.logiikka.Sanakirja;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Sanavarasto lukee sanat tekstitiedostoista ja lisaa ne sanakirjaolion
 * sanakirja HashMapiin.
 *
 * @author Eeva
 */
public class Sanavarasto {

    /**
     * Sanakirja-luokan ilmentyma sanakirja.
     */
    public Sanakirja sanakirja = new Sanakirja();

    /**
     * Konstruktori toteuttaa luokan metodin lueTiedotot().
     */
    public Sanavarasto() {
        this.lueTiedostot();
    }

    /**
     * Metodi lukee sanat tekstitiedostoista, lisaa jokaisen tiedoston nimen
     * avaimeksi ja sisallon listan muodossa arvoksi Sanakirja-luokan ilmentyman
     * sanakirja HashMapiin.
     *
     */
    public void lueTiedostot() {
        File[] files = new File("sanavarasto").listFiles();
        for (File file : files) {

            BufferedReader in = null;
            ArrayList<String> lista = new ArrayList<>();
            try {
                in = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
                for (String line = in.readLine(); line != null; line = in.readLine()) {
                    String[] sanat = line.split("\\s+");
                    lista.addAll(Arrays.asList(sanat));
                }
                in.close();
            } catch (IOException e) {
                System.exit(1);
            }
            String fileName = file.getName();
            fileName = fileName.substring(0, fileName.lastIndexOf("."));
            this.sanakirja.lisaaSanalista(fileName, lista);

        }

    }
}
