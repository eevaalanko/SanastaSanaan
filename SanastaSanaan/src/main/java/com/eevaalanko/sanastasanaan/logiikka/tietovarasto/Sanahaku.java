/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eevaalanko.sanastasanaan.logiikka.tietovarasto;

import java.util.ArrayList;
import org.w3c.dom.Node;

/**
 * Luokka arpoo sanavarastosta avainsanoja, vertaa sanojen kirjainsisaltoja ja
 * niiden maaria, tutkii voiko avainsanan kirjaimista muodostua toinen annettu
 * sana ja hakee sanavarastosta kaikki avainsanan kirjaimista muodostuvat sanat.
 *
 * @author Eeva
 */
public final class Sanahaku {

    /**
     * Metodi hakee satunnanvaraisen sanan sanalistasta.
     *
     * @param nodelista solmu, jonka sisällä sanalista
     * @param pituus sanalistan pituus
     * @return String avainsana
     */
    public static String haeRandomAvainSana(Node nodelista, int pituus) {    //hakee sana xml-filusta
        String avainsana = "";
        boolean sanaLoytyi = false;
        while (!sanaLoytyi) {
            int paikka = random(pituus);
            boolean b = nodelista.getChildNodes().item(paikka).hasChildNodes();
            if (b) {
                String s = nodelista.getChildNodes().item(paikka).getChildNodes().item(0).getTextContent();
                if (minimipituus(s, 7)) {              //asetetaan minimipituus
                    avainsana = s;
                    break;
                }
            }
        }
        return avainsana;
    }

    /**
     * Metodi asettaa haetulle avainsanalle minimipituuden.
     *
     * @param sana avainsana, jonka pituutta tutkitaan
     * @param pituus haluttu minimipituus
     * @return paluttaa toden, jos pituus on oikea, epatoden, jos ei ole.
     */
    public static boolean minimipituus(String sana, int pituus) {  //asettaa sanalle minimipituusen
        if (sana.length() >= pituus) {
            return true;
        }
        return false;
    }

    /**
     * Metodi laskee solmun pituuden.
     *
     * @param nodelista tarkasteltava solmu
     * @return solmun pituus
     */
    public static int laskePituus(Node nodelista) {
        int pituus = nodelista.getChildNodes().getLength(); //sanalistan pituus
        return pituus;
    }

    /**
     * Metodi etsii satunnaisen luvun paikaksi valilla 1 - listan pituus.
     *
     * @param pituus listan pituus
     * @return satunnainen paikka
     */
    public static int random(int pituus) {
        int paikka = (int) (Math.random() * pituus);
        return paikka;
    }

    /**
     * Metodi hakee listasta kaikki sanat, joita avainsanan kirjaimista
     * muodostuu.
     *
     * @param avainsana syotetty avainsana
     * @param nodelista solmu sisaltaa sanalistan, josta sanat etsitaan
     * @return ArrayList sanalista, kaikki loydetyt sanat
     */
    public static ArrayList haeSanalista(String avainsana, Node nodelista) {
        ArrayList<String> sanalista = new ArrayList<>();
        int pituus = laskePituus(nodelista);
        int[] avaintaulu = luoSanataulu(avainsana);
        String sana;
        for (int i = 0; i < pituus; i++) {
            Node node = nodelista.getChildNodes().item(i).getChildNodes().item(0);
            if (node != null) {
                sana = node.getTextContent();
                int[] sanataulu = luoSanataulu(sana);
                boolean b = vertaaTauluja(avaintaulu, sanataulu);
                if (b) {
                    sanalista.add(sana);
                }
            }
        }
        return sanalista;
    }

    /**
     * Luo annetusta sanasta Integertaulukon, jossa nakyy sanan kirjainten maara
     * ja indeksi taulukossa.
     *
     * @param sana annettu syote
     * @return Integertaulukko sanataulu
     */
    public static int[] luoSanataulu(String sana) {
        String aakkoset = "abcdefghijklmnopqrstuvwxyzåäö";
        int[] sanataulu = new int[29];          //aakkosten määrä
        sana = sana.toLowerCase();
        for (int i = 0; i < sana.length(); i++) {
            int index = aakkoset.indexOf(sana.charAt(i));
            try {
                sanataulu[index] += 1;
            } catch (Exception e) {
//                System.out.println("tuntematon char" + index);
            }
        }
        return sanataulu;
    }

    /**
     * Vertaa taulujen arvojen lukumaaria. Indeksin paikka vastaa kirjainta ja
     * sisalto kirjaimen lukumaaraa. Jos avainsanataulussa sanataulua vastaavan
     * kirjaimen maara on suurempi, palauttaa epatoden, muuten toden.
     *
     * @param avainsanataulu syote
     * @param sanataulu syote
     * @return tosi, epatosi
     */
    public static boolean vertaaTauluja(int[] avainsanataulu, int[] sanataulu) {
        boolean b = false;
        if (sanataulu != null && avainsanataulu != null) {
            b = true;
            for (int i = 0; i < sanataulu.length; i++) {
                if (sanataulu[i] > avainsanataulu[i]) {
                    b = false;
                    break;
                }
            }
        }
        return b;
    }
}
