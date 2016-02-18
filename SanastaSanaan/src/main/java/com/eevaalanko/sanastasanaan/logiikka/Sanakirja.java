/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eevaalanko.sanastasanaan.logiikka;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

/**
 *
 * @author Eeva
 */
public class Sanakirja {

    public HashMap< String, ArrayList> sanasto;

    /**
     * Alustaa uuden HashMapin sanasto
     */
    public Sanakirja() {
        sanasto = new HashMap<>();
    }

    /**
     * Lisaa HashMapiin sanasto avaimen listattava ja arvon lista
     *
     * @param listattava kayttajan antama syote
     * @param lista kayttajan antama syote
     */
    
    public void lisaaSanalista(String listattava, ArrayList lista) {
        sanasto.put(listattava, lista);
    }

    /**
     * Poistaa HashMapista sanasto avaimen listattava ja avaimen arvon.
     *
     * @param listattava kayttajan antama syote
     */
    
    public void poistaSanalista(String listattava) {
        sanasto.remove(listattava);
    }
    
    /**
     * Palauttaa HashMap sanastosta annetun avaimen mukaisen arvon eli sanalistan.
     * @param alkusana kayttajan antama syote
     * @return null, jos syotetta ei ole avaimena, muuten avaimen mukaisen ArrayListin
     */

    public ArrayList annaSanalista(String alkusana) {
        ArrayList<String> lista = new ArrayList<>();
        lista = sanasto.get(alkusana);
        if (!sanasto.containsKey(alkusana)) {
            return null;
        }
        return lista;
    }
    
    /**
     * Laskee syotteen palauttaman sanalistan koon.
     * @param alkusana kayttajan antama syote
     * @return listan koko, jos lista on tyhja, return 0.
     */

    public int laskeSanalista(String alkusana) {
        if (sanasto.get(alkusana) != null) {
            ArrayList lista = sanasto.get(alkusana);
            if (lista.isEmpty()) {
                return 0;
            } else {
                return lista.size();
            }
        }
        return 0;
    }
    
    /**
     * Palauttaa kaikki HashMap sanaston avaimet.
     * @return avainsanat kokoelmana
     */
  
    public Object[] annaAvainsanat() {
        Collection c = sanasto.keySet();
        Object avainlista[] = c.toArray(new Object[c.size()]);
        return avainlista;
    }

}
