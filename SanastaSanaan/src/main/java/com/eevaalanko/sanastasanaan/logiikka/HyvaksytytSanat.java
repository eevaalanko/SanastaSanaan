/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eevaalanko.sanastasanaan.logiikka;

import com.eevaalanko.sanastasanaan.tietovarasto.Sanavarasto;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author Eeva
 */
public class HyvaksytytSanat {

    Sanavarasto varasto = new Sanavarasto();
    public String avainsana;

    public ArrayList<String> hyvaksytyt;

    public HyvaksytytSanat() {
    }

    public HyvaksytytSanat(String avainsana) {
        hyvaksytyt = new ArrayList<>();
        this.avainsana = avainsana;
    }

    public boolean tarkistaSana(String tarkistettava) {
        ArrayList<String> lista = varasto.sanakirja.annaSanalista(this.avainsana);
        if (lista != null) {
            return lista.contains(tarkistettava);
        }
        return false;
    }

    public boolean lisaaSana(String tarkistettava) {
        boolean tarkistaSana = this.tarkistaSana(tarkistettava);
        boolean onJoLisatty = this.onJoLisatty(tarkistettava);
        if (tarkistaSana && !onJoLisatty) {
            hyvaksytyt.add(tarkistettava);
            return true;
        }
        return false;
    }

    public boolean onJoLisatty(String tarkistettava) {
        return this.hyvaksytyt.contains(tarkistettava);
    }

    public int laskeSanat() {
        if (hyvaksytyt.isEmpty()) {
            return 0;
        }
        return this.hyvaksytyt.size();
    }

    public void poistaSanat() {
        this.hyvaksytyt.clear();
    }

}
