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

    public Sanakirja() {
        sanasto = new HashMap<>();
    }

    public void lisaaSanalista(String listattava, ArrayList lista) {
        sanasto.put(listattava, lista);
    }

    public void poistaSanalista(String listattava) {
        sanasto.remove(listattava);
    }

    public ArrayList annaSanalista(String alkusana) {
        ArrayList<String> lista = new ArrayList<>();
        lista = sanasto.get(alkusana);
        if (!sanasto.containsKey(alkusana)) {
            return null;
        }
        return lista;
    }

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

    public Collection annaAvainsanat() {
        Collection avainlista = sanasto.keySet();
        return avainlista;
    }

}
