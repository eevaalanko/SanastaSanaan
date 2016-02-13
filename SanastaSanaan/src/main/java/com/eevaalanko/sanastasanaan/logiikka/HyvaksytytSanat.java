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

    public ArrayList<String> hyvaksytyt;
    public String avainsana;

    public HyvaksytytSanat() {
        hyvaksytyt = new ArrayList<>();
        avainsana = "";
    }

    public boolean tarkistaAvainsana(String alkusana) {
        Collection c = varasto.sanakirja.annaAvainsanat();
        if(c.isEmpty()||c == null){
            return false;
        }
       
       else if (c.contains(alkusana)) {
            this.avainsana = alkusana;
            return true;
        } else {
        }
        this.avainsana = "";
        return false;
    }

    public boolean tarkistaSana(String tarkistettava) {
        if (tarkistaAvainsana(this.avainsana)) {
            ArrayList<String> lista = varasto.sanakirja.annaSanalista(this.avainsana);
            return lista.contains(tarkistettava);
        }
        return false;
    }

    public boolean lisaaSana(String alkusana, String tarkistettava) {
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

    @Override
    public String toString() {
        return this.hyvaksytyt.toString();
    }

    public int laskeSanat() {
        if (hyvaksytyt.isEmpty()) {
            return 0;
        }
        return this.hyvaksytyt.size();
    }

    public void poistaSana(String poistettava) {
        if (this.hyvaksytyt.contains(poistettava)) {
            this.hyvaksytyt.remove(poistettava);
        }
    }

}
