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
        testi.add("setti");
        testi.add("itse");
        this.sanakirja.lisaaSanalista("TESTI", testi);

        ArrayList<String> sanapeliLista = new ArrayList<>();
        sanapeliLista.add("sana");
        sanapeliLista.add("sapeli");
        sanapeliLista.add("saali");
        sanapeliLista.add("sali");
        sanapeliLista.add("salpa");
        sanapeliLista.add("sei");
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
        this.sanakirja.lisaaSanalista("SANAPELI", sanapeliLista);

        ArrayList<String> kapistely = new ArrayList<>();
        kapistely.add("käpy");
        kapistely.add("käly");
        kapistely.add("käsi");
        kapistely.add("käet");
        kapistely.add("kylä");
        kapistely.add("kypsä");
        kapistely.add("äly");
        kapistely.add("äes");
        kapistely.add("piste");
        kapistely.add("pistely");
        kapistely.add("itse");
        kapistely.add("isä");
        kapistely.add("iskeä");
        kapistely.add("säie");
        kapistely.add("säkit");
        kapistely.add("se");
        kapistely.add("sekit");
        kapistely.add("sei");
        kapistely.add("te");
        kapistely.add("tie");
        kapistely.add("eli");
        kapistely.add("ei");
        kapistely.add("lisä");
        kapistely.add("yli");
        kapistely.add("ylitse");
        kapistely.add("yskä");
        kapistely.add("ylkä");
        this.sanakirja.lisaaSanalista("KÄPISTELY", kapistely);

    }

    /**
     *
     * @return
     */
}
