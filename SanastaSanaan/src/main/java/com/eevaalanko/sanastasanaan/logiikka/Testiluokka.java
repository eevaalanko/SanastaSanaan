/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eevaalanko.sanastasanaan.logiikka;

import com.eevaalanko.sanastasanaan.tietovarasto.*;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author Eeva
 */
public class Testiluokka {

    Sanavarasto varasto = new Sanavarasto();

    public boolean tarkistaSana(String alkusana, String tarkistettava) {
        ArrayList lista = varasto.sanakirja.annaSanalista(alkusana);
        return lista.contains(tarkistettava);
    }

    public boolean aikaLoppu() {
        //kun java swing timer on pyörinyt 2 minuuttia todo: 
        return true;
    }

    public static void main(String[] args) {
        Sanavarasto varasto = new Sanavarasto();
        System.out.println("" + varasto.sanakirja.annaSanalista("sanapeli"));
        System.out.println("koe");
        Testiluokka testi = new Testiluokka();
        boolean tarkistaSana = testi.tarkistaSana("sanapeli", "peli");
        System.out.println(tarkistaSana);
    }
}
