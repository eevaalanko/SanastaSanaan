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

    Sanavarasto varasto;
    public String avainsana;
    public ArrayList<String> hyvaksytyt;


    /**
     * Alustaa uuden Sanavarasto-luokan ilmentyman varasto Alustaa listan
     * ArrayList hyvaksytyt
     *
     * @param avainsana asettaa alkuarvon Stringille avainsana
     */
    public HyvaksytytSanat(String avainsana) {
        varasto = new Sanavarasto();
        hyvaksytyt = new ArrayList<>();
        this.avainsana = avainsana;
    }

    /**
     * Tarkistaa loytyyko annettu sana avainsanan mukaisesta sanalistasta
     * HashMapista varasto.sanakirja.
     *
     * @param tarkistettava kayttajan antama syote
     * @return true, soa sana loytyy, false, jos sanaa ei loydy
     */
    public boolean tarkistaSana(String tarkistettava) {
        ArrayList<String> lista = varasto.sanakirja.annaSanalista(this.avainsana);
        if (lista != null) {
            return lista.contains(tarkistettava);
        }
        return false;
    }

    /**
     * Tarkistaa sanan luokan metodeilla tarkistaSana ja onLisatty. Jos nama
     * ovat oikein, lisaa sanan luokan ArrayListiin hyvaksytyt.
     *
     * @param tarkistettava kayttajan antama syote
     * @return true, jos lisays onnistuu, muuten false
     */
    public boolean lisaaSana(String tarkistettava) {
        boolean tarkistaSana = this.tarkistaSana(tarkistettava);
        boolean onJoLisatty = this.onJoLisatty(tarkistettava);
        if (tarkistaSana && !onJoLisatty) {
            hyvaksytyt.add(tarkistettava);
            return true;
        }
        return false;
    }

    /**
     * Tarkistaa, onko annettu sana jo ArrayListissa hyvaksytyt.
     *
     * @param tarkistettava kayttajan antama syote
     * @return true, jos loytyy ArrayListista hyvaksytyt, false jos ei loydy
     */
    public boolean onJoLisatty(String tarkistettava) {
        return this.hyvaksytyt.contains(tarkistettava);
    }

    /**
     * Laskee ArrayListissa hyvaksytyt olevat sanat.
     *
     * @return 0, jos lista on tyhja, muuten listan koko
     */
    public int laskeSanat() {
        if (hyvaksytyt.isEmpty()) {
            return 0;
        }
        return this.hyvaksytyt.size();
    }

    /**
     * Tyhjentaa ArrayListin Hyvaksytyt
     */
    public void poistaSanat() {
        this.hyvaksytyt.clear();
    }

}
