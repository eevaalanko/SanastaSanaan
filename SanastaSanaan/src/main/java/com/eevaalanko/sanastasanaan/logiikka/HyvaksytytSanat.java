/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eevaalanko.sanastasanaan.logiikka;

import com.eevaalanko.sanastasanaan.tietovarasto.Sanavarasto;
import java.util.ArrayList;

/**
 *
 * @author Eeva
 */
public class HyvaksytytSanat {

    Sanavarasto varasto = new Sanavarasto();

    public ArrayList hyvaksytyt;

    public HyvaksytytSanat() {
        hyvaksytyt = new ArrayList<>();
    }

    public boolean tarkistaSana(String alkusana, String tarkistettava) {
        ArrayList lista = varasto.sanakirja.annaSanalista(alkusana);
        return lista.contains(tarkistettava);
    }

    public boolean lisaaSana(String alkusana, String tarkistettava) {
        boolean tarkistaSana = this.tarkistaSana(alkusana, tarkistettava);
        boolean onJoLisatty = this.onJoLisatty(tarkistettava);
        if (tarkistaSana && !onJoLisatty) {
            hyvaksytyt.add(tarkistettava);
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

    public String toString() {
        return this.hyvaksytyt.toString();
    }

    public int laskeSanat() {
        if (hyvaksytyt.isEmpty()) {
            return 0;
        }
        return this.hyvaksytyt.size();
    }

}
