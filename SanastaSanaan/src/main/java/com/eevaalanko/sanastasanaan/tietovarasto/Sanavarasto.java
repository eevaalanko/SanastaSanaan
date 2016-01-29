/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eevaalanko.sanastasanaan.tietovarasto;

import com.eevaalanko.sanastasanaan.logiikka.Sanakirja;
import java.util.ArrayList;

/**
 *
 * @author Eeva
 */
public class Sanavarasto {

    /**
     *
     */
    public Sanakirja sanakirja = new Sanakirja();

    public Sanavarasto() {
        ArrayList<String> testi = new ArrayList<>();
        testi.add("te");
        testi.add("ei");
        testi.add("se");
        testi.add("sei");
        testi.add("itse");
        this.sanakirja.lisaaSanalista("testi", testi);

        ArrayList<String> sanapeliLista = new ArrayList<>();
        sanapeliLista.add("sana");
        sanapeliLista.add("sapeli");
        sanapeliLista.add("saali");
        sanapeliLista.add("sali");
        sanapeliLista.add("salpa");
        sanapeliLista.add("aie");
        sanapeliLista.add("ane");
        sanapeliLista.add("ase");
        sanapeliLista.add("ne");
        sanapeliLista.add("neli");
        sanapeliLista.add("naali");
        sanapeliLista.add("peli");
        sanapeliLista.add("eli");
        sanapeliLista.add("ei");
        sanapeliLista.add("lapa");
        sanapeliLista.add("lei");
        this.sanakirja.lisaaSanalista("sanapeli", sanapeliLista);

    }

    /**
     *
     * @return
     */
  

}
