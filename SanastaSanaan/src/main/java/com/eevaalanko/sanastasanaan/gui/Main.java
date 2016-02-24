/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eevaalanko.sanastasanaan.gui;

import static com.eevaalanko.sanastasanaan.gui.TyyliLuokka.*;
import com.eevaalanko.sanastasanaan.logiikka.kayttologiikka.HyvaksytytSanat;
import com.eevaalanko.sanastasanaan.logiikka.tietovarasto.Sanavarasto;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.SimpleDateFormat;
import javax.swing.JFrame;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 * Ohjelman SanastaSanaan graafinen kayttoliittyma.
 *
 * @author Eeva
 */
public class Main extends JFrame {

    /**
     * Luokkien Sanavarasto, HyvaksytytSanat ja AlsInfo- ilmentymien alustus.
     * Paneelien ja otsikoiden luonti, painikkeiden luonti: btInfo
     * avaa peliohjeet, btAloita kaynnistaa ajastimen ja aloittaa pelin,
     * Pudotusvalikko cbValinta sisaltaa viisi avainsanaa,joista pelaaja voi valita.
     *
     */
    public JFpelialusta peli;
    private final Sanavarasto varasto = new Sanavarasto();
    private final AlsInfo ai = new AlsInfo();
    public HyvaksytytSanat hyvaksytyt;

    public JPanel paEka = new JPanel(new FlowLayout(FlowLayout.LEFT));
    public JPanel paToka = new JPanel(new FlowLayout(FlowLayout.LEFT));
    public JPanel paPohja = new JPanel(new GridLayout(2, 1));
    public JButton btAloita = new JButton("ALOITA PELI");
    public JButton btInfo = new JButton("OHJEET");
    public JLabel jlInfo = new JLabel("Lue peliohjeet:               ");
    public JLabel jlEka = new JLabel("Valitse avainsana:            ");
    public Object[] avainlista;
    public JComboBox cbValinta;


    /**
     * Konstruktori maarittaa komponenttien kokoja ja alustaa ajastimen ja lisaa
     * siihen tapahtumankuuntelijan. Toteuttaa metodin asetteleKomponentit().
     * Asettaa oletusmetodin, joka sammuttaa ohjelman suljettaessa.
     *
     * @throws ParserConfigurationException Indicates a serious configuration error
     * @throws SAXException basic error or warning information from either the
     * XML parser or the application
     * @throws java.io.IOException if stream to a File cannot be written to or
     * closed
     */
    public Main() throws IOException, ParserConfigurationException, SAXException {
        varasto.hae();
        avainlista = varasto.sanakirja.annaAvainsanat();
        cbValinta = new JComboBox(avainlista);
        this.cbValinta.setPreferredSize(new Dimension(150, 24));
        this.setSize(200, 200);
        this.setTitle("Sanasta sanaan");
        this.setLocation(100, 150);
        asetteleKomponentit();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    /**
     * Metodi asettelee komponentit Jpanel alustaan ja asettaa alustan JFrame
     * SanastaSanaanGuihin. Asettaa JFrame'ille standardikoon. Lisaa
     * tapahtumankuuntelijat painikkeisiin. Lisaa vareja elementteihin.
     */
    public void asetteleKomponentit() {
        paEka.add(jlEka);
        paEka.add(cbValinta);
        paEka.add(btAloita);
        paToka.add(jlInfo);
        paToka.add(btInfo);
        paPohja.add(paEka);
        paPohja.add(paToka);
        paEka.setBackground(cEka);
        paToka.setBackground(cToka);
        cbValinta.setBackground(cToka);
        cbValinta.setForeground(Color.WHITE);
        btInfo.setBackground(cNeljas);
        btInfo.setForeground(Color.WHITE);
        btAloita.setBackground(cViides);
        jlInfo.setForeground(Color.yellow);
        jlInfo.setFont(fEka);
        jlEka.setForeground(Color.yellow);
        jlEka.setFont(fEka);
        this.add(paPohja);
        this.setSize(620, 350);
        btAloita.addActionListener(new AlsAloita());
        btInfo.addActionListener(ai);
    }


    /**
     * Sisainen tapahtumenkuuntelijaluokka kaynnistaa ajastimen ja luo uuden
     * peliframen.
     */
    class AlsAloita implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String avainsana = cbValinta.getSelectedItem().toString();
            hyvaksytyt = new HyvaksytytSanat(avainsana, varasto);
            peli = new JFpelialusta(hyvaksytyt);
            peli.setSize(620, 350);        
            peli.jlValittuAvainsana.setText(avainsana);  
            peli.setVisible(true);
        }
    }

    /**
     * Luo ja avaa ohjelman graafisen kayttoliittyman.
     *
     * @param args Unused.
     * @throws ParserConfigurationException Indicates a serious configuration error
     * @throws SAXException basic error or warning information from either the
     * XML parser or the application
     * @throws java.io.IOException if stream to a File cannot be written to or
     * closed
     */
    public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException {
        Main akkuna = new Main();
        akkuna.setVisible(true);
    }
}
