/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eevaalanko.sanastasanaan.logiikka;

import com.eevaalanko.sanastasanaan.tietovarasto.Sanakirja;
import java.util.ArrayList;

/**
 *
 * @author Eeva
 */
public class HyvaksytytSanat {

    private ArrayList hyvaksytyt;

    public HyvaksytytSanat() {
        hyvaksytyt = new ArrayList<>();
    }

    public boolean tarkistaSana(String tarkistettava, Sanakirja kirja) {
        ArrayList lista = kirja.annaSanalista(tarkistettava);
        if (lista.contains(tarkistettava)) {
            return true;
        }
        return false;
    }

    public boolean lisaaSana(String tarkistettu, Sanakirja kirja) {
        boolean oikea = this.tarkistaSana(tarkistettu, kirja);
        if (oikea) {
            hyvaksytyt.add(tarkistettu);
            return true;
        }
        return false;
    }

    public boolean onJoLisatty(String tarkistettava) {
        if (this.hyvaksytyt.contains(tarkistettava)) {
            return true;
        }
        return false;
    }
    
    public int laskeSanat(){
        return this.hyvaksytyt.size();
        
    }

}
