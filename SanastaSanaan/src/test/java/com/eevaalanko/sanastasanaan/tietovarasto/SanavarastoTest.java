/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eevaalanko.sanastasanaan.tietovarasto;

import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Eeva
 */
public class SanavarastoTest {
     static Sanavarasto varasto;

    public SanavarastoTest() {
        varasto = new Sanavarasto();
    }

    public void testLueOikeaTiedosto() {
         ArrayList lista = varasto.sanakirja.sanasto.get(this);

    }
    public void testLueVaaraTiedosto(){
        
    }
     public void testLueTyhjaTiedosto(){
        
    }

}
