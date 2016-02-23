/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eevaalanko.sanastasanaan.logiikka.tietovarasto;

import com.eevaalanko.sanastasanaan.logiikka.kayttologiikka.Sanakirja;
import static com.eevaalanko.sanastasanaan.logiikka.tietovarasto.Sanahaku.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/**
 * Sanavarasto lukee sanat tekstitiedostoista ja lisaa ne sanakirjaolion
 * sanakirja HashMapiin.
 *
 * @author Eeva
 */
public class Sanavarasto {

    /**
     * Sanakirja-luokan ilmentyma sanakirja.
     */
    public Sanakirja sanakirja;

    /**
     * Konstruktori.
     */
    public Sanavarasto() {
        sanakirja = new Sanakirja();
    }

    /**
     * Metodi hakee kaikki sanat sisaltavan noden xml-tiedostosta.
     *
     * @throws ParserConfigurationException Indicates a serious configuration error
     * @throws SAXException basic error or warning information from either the
     * XML parser or the application
     * @throws java.io.IOException if stream to a File cannot be written to or
     * closed
     * @return haettu Node
     */
    public static Node haeNodelista() throws ParserConfigurationException, SAXException, IOException {
        FileInputStream fis = new FileInputStream("sanavarasto/kotus-sanalista_v1.xml");
        InputSource is = new InputSource(fis);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        dbFactory.setFeature("http://apache.org/xml/features/nonvalidating/load-dtd-grammar", false);
        dbFactory.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        org.w3c.dom.Document doc = dBuilder.parse(is);
        Node nodelista = (Node) doc.getChildNodes().item(2);
        return nodelista;
    }

    /**
     * Metodi hakee viisi sanaa xml-tiedostosta,lisaa ne avaimiksi ja lisaa
     * haetun sanalistan arvoksi Sanakirja-luokan ilmentyman sanakirja
     * HashMapiin.
     *
     * @throws javax.xml.parsers.ParserConfigurationException Indicates a serious configuration error
     * @throws org.xml.sax.SAXException basic error or warning information from either the
     * XML parser or the application
     * @throws java.io.IOException if stream to a File cannot be written to or closed
     */
    public void hae() throws ParserConfigurationException, SAXException, IOException {
        Node nodelista = haeNodelista();
        int pituus = laskePituus(nodelista);
        for (int i = 0; i < 5; i++) {
            String avainsana = haeRandomAvainSana(nodelista, pituus);
            ArrayList sanalista = haeSanalista(avainsana, nodelista);
            sanakirja.lisaaSanalista(avainsana, sanalista);
//            debug
//            System.out.println("avainsana: " + avainsana);
//            System.out.println("sanalista: " + sanalista.toString());
        }
    }

    /**
     * Metodi hakee sanan xml-tiedostosta,lisaa sen avaemiksi ja lisaa haetun
     * sanalistan arvoksi Sanakirja-luokan ilmentyman sanakirja HashMapiin.
     *
     * @param avainsana syote
     * @throws ParserConfigurationException Indicates a serious configuration error
     * @throws SAXException basic error or warning information from either the
     * XML parser or the application
     * @throws IOException if stream to a File cannot be written to or closed
     */
    public void haeAnnetullaSanalla(String avainsana) throws ParserConfigurationException, SAXException, IOException {
        Node nodelista = haeNodelista();
        ArrayList sanalista = haeSanalista(avainsana, nodelista);
        sanakirja.lisaaSanalista(avainsana, sanalista);
//            debug
//            System.out.println("avainsana: " + avainsana);
//            System.out.println("sanalista: " + sanalista.toString());
//            System.out.println("pituus:"+ sanakirja.laskeSanalista(avainsana));
    }

}
