/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eevaalanko.sanastasanaan.gui;

import static com.eevaalanko.sanastasanaan.gui.TyyliLuokka.*;
import com.eevaalanko.sanastasanaan.logiikka.kayttologiikka.HyvaksytytSanat;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * Ikkuna yksittaiselle pelille. BtLisaaSanan avulla kayttaja lisaa uusia sanoja.
 *
 * @author Eeva
 */
class JFpelialusta extends JFrame {

    public JPanel paVasen = new JPanel(new FlowLayout(FlowLayout.LEFT));
    public JPanel paOikea = new JPanel(new FlowLayout(FlowLayout.LEFT));
    public JPanel paPohja = new JPanel(new GridLayout(1, 2));
    public JFormattedTextField tfSana = new JFormattedTextField();
    public JButton btLisaaSana = new JButton("Lisää sana");
    public JLabel jlTimer = new JLabel("00:00:00");
    public JLabel jlValittuAvainsana = new JLabel();
    public TextArea taHyvaksytyt = new TextArea();
    public Timer timer;
    public long startTime = -1;
    public long duration = 100000;
    public HyvaksytytSanat hyvaksytyt;
    
    /**
     * Konstruktori maarittaa komponentteja ja kaynnistaa ajastimen. 
     * @param hs HyvaksytytSanat-luokan ilmentyma
     */
    public JFpelialusta(HyvaksytytSanat hs) {
        this.hyvaksytyt = hs;
        this.btLisaaSana.addActionListener(new AlsLisaaSana());
        this.tfSana.addActionListener(new AlsLisaaSana());
        this.tfSana.setPreferredSize(new Dimension(200, 24));
        this.add(paPohja);
        this.timer = new Timer(10, (ActionListener) new AlsAjastin());
        this.timer.start();
        asetteleKomponentit();
        this.setTitle("Sanasta sanaan");
        this.setSize(620, 350);
    }
    
      /**
     * Metodi asettelee komponentit ja lisaa tyyleja elementteihin.
     */
    public void asetteleKomponentit() {
        paPohja.add(paVasen);
        paPohja.add(paOikea);
        paVasen.add(tfSana);
        paVasen.add(btLisaaSana);
        paOikea.add(jlTimer);
        paOikea.add(jlValittuAvainsana);
        paOikea.add(taHyvaksytyt);
        paVasen.setBackground(cToka);
        paOikea.setBackground(cNeljas);
        btLisaaSana.setBackground(cEka);
        btLisaaSana.setForeground(Color.WHITE);
        jlTimer.setBackground(cEka);
        jlTimer.setForeground(Color.white);
        jlValittuAvainsana.setForeground(Color.yellow);
        jlValittuAvainsana.setFont(fEka);
    }

    /**
     * Sisainen tapahtumankuuntelijaluokka saataa ajastinta ja laukaisee metodin
     * naytatulokset() kun aika loppuu.
     */
    class AlsAjastin implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (startTime < 0) {
                startTime = System.currentTimeMillis();
            }
            long now = System.currentTimeMillis();
            long clockTime = now - startTime;
            if (clockTime >= duration) {
                clockTime = duration;
                timer.stop();
                jlTimer.setText("00:00:00");
                naytaTulokset();
            }
            SimpleDateFormat df = new SimpleDateFormat("mm:ss:SSS");
            jlTimer.setText(df.format(duration - clockTime));
        }
    }

    /**
     * Sisainen tapahtumankuuntelijaluokka sanojenlisaykseen.
     */
    class AlsLisaaSana implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String sana = tfSana.getText();
            boolean ok = hyvaksytyt.lisaaSana(sana);
            if (ok) {
                taHyvaksytyt.append(sana + "\n");
            }
            tfSana.setText("");
            Cursor cursor = new Cursor(0);
            tfSana.setCursor(cursor);
        }
    }

    /**
     * Laskee hyvaksytyt sanat.Avaa tulokset sisaltavan JOptionPane paneelin.
     */
    public void naytaTulokset() {
        String avainsana = jlValittuAvainsana.getText();
        int oikeaMaara = hyvaksytyt.varasto.sanakirja.laskeSanalista(avainsana);
        int saatuMaara = hyvaksytyt.laskeSanat();
        String teksti = "Tuloksesi sanasta " + avainsana + ": " + saatuMaara + "/" + oikeaMaara;
        JOptionPane.showMessageDialog(null, teksti, "Sanasta sanaan-tulokset", JOptionPane.INFORMATION_MESSAGE);
    }

}
