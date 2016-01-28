/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eevaalanko.sanastasanaan.tietovarasto;

import java.util.ArrayList;
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
        ArrayList lista = sanasto.get(alkusana);
        return lista;
    }
    public Object[] annaAvainsanat(){
        Object[] avainlista = sanasto.keySet().toArray();
        return avainlista;
    }

}
