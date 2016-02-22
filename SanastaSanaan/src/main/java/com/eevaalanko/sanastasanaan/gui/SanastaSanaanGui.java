/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eevaalanko.sanastasanaan.gui;

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
public class SanastaSanaanGui extends JFrame {

    /**
     * Luokkien Sanavarasto, HyvaksytytSanat ja AlsInfo- ilmentymien alustus.
     * Varien ja paneelien ja otsikoiden luonti, painikkeiden luonti: btInfo
     * avaa peliohjeet, btAloita kaynnistaa ajastimen ja aloittaa pelin,
     * btLisaaSanan avulla kayttaja lisaa uusia sanoja, pudotusvalikko
     * cbValinnasta kayttaja valitsee haluamansa avainsanan. Ajastimen alkuajan
     * ja ajan keston asetus. Pudotusvalikko sisaltaa avainsanat.
     *
     */
    public JFpelialusta peli;
    private final Sanavarasto varasto = new Sanavarasto();
    private final AlsInfo ai = new AlsInfo();
    public HyvaksytytSanat hyvaksytyt;
    public Color cEka = new Color(122, 187, 203);
    public Color cToka = new Color(0, 204, 204);
    public Color cKolmas = new Color(150, 159, 161);
    public Color cNeljas = new Color(0, 128, 128);
    public Color cViides = new Color(51, 255, 255);
    public JPanel paEka = new JPanel(new FlowLayout(FlowLayout.LEFT));
    public JPanel paToka = new JPanel(new FlowLayout(FlowLayout.LEFT));
    public JPanel paPohja = new JPanel(new GridLayout(2, 1));
    public JButton btAloita = new JButton("Aloita peli.");
    public JButton btInfo = new JButton("OHJEET");
    public JLabel jlValitus = new JLabel("Amat victoria curam.");
    public JLabel jlEka = new JLabel("Valitse avainsana:            ");
    public Object[] avainlista;
    public JComboBox cbValinta;
    public Timer timer;
    public long startTime = -1;
    public long duration = 100000;

    /**
     * Konstruktori maarittaa komponenttien kokoja ja alustaa ajastimen ja lisaa
     * siihen tapahtumankuuntelijan. Toteuttaa metodin asetteleKomponentit().
     * Asettaa oletusmetodin, joka sammuttaa ohjelman suljettaessa.
     *
     * @throws IOException if stream to aFile cannot be written to or closed.
     */
    public SanastaSanaanGui() throws IOException, ParserConfigurationException, SAXException {
        varasto.hae();
        avainlista = varasto.sanakirja.annaAvainsanat();
        cbValinta = new JComboBox(avainlista);
        this.cbValinta.setPreferredSize(new Dimension(150, 24));

        this.timer = new Timer(10, (ActionListener) new AlsAjastin());
        this.setSize(200, 200);
        this.setTitle("Sanasta sanaan");
        this.setLocation(100, 150);
        asetteleKomponentit();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    /**
     * Metodi asettelee komponentit Jpanel alustaanja asettaa alustan JFrame
     * SanastaSanaanGuihin. Asettaa JFrame'ille standardikoon. Lisaa
     * tapahtumankuuntelijat painikkeisiin. Lisaa vareja elementteihin.
     */
    public void asetteleKomponentit() {
        paEka.add(jlEka);
        paEka.add(cbValinta);
        paEka.add(btAloita);
        paToka.add(jlValitus);
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
        jlValitus.setForeground(Color.yellow);
        jlEka.setForeground(Color.yellow);
        this.add(paPohja);
        this.setSize(620, 350);
        btAloita.addActionListener(new AlsAloita());
        btInfo.addActionListener(ai);
    }

    /**
     * Sisainen tapahtumankuuntelijaluokka sanojenlisaykseen.
     */
    class AlsLisaaSana implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String sana = peli.tfSana.getText();
            boolean ok = hyvaksytyt.lisaaSana(sana);
            if (ok) {
                peli.taHyvaksytyt.append(sana + "\n");
            }
            peli.tfSana.setText("");
            Cursor cursor = new Cursor(0);
            peli.tfSana.setCursor(cursor);

        }
    }

    /**
     * Sisainen tapahtumenkuuntelijaluokka kaynnistaa ajastimen ja luo uuden
     * peliframen.
     */
    class AlsAloita implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            peli = new JFpelialusta();
            peli.setSize(620, 350);
            peli.btLisaaSana.addActionListener(new AlsLisaaSana());
            peli.tfSana.addActionListener(new AlsLisaaSana());
            timer.start();
            String avainsana = cbValinta.getSelectedItem().toString();
            peli.jlValittuAvainsana.setText(avainsana);
            hyvaksytyt = new HyvaksytytSanat(avainsana, varasto);
            peli.setVisible(true);
        }
    }

    /**
     * Sisainen tapahtumenkuuntelijaluokka saataa ajastinta.
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
                peli.jlTimer.setText("00:00:00");
                naytaTulokset();
            }
            SimpleDateFormat df = new SimpleDateFormat("mm:ss:SSS");
            peli.jlTimer.setText(df.format(duration - clockTime));
        }
    }

    /**
     * Laskee hyvaksytyt sanat.Avaa tulokset sisaltavan JOptionPane paneelin.
     */
    public void naytaTulokset() {
        String avainsana = peli.jlValittuAvainsana.getText();
        int oikeaMaara = varasto.sanakirja.laskeSanalista(avainsana);
        int saatuMaara = hyvaksytyt.laskeSanat();
        String teksti = "Tuloksesi: " + saatuMaara + "/" + oikeaMaara;
        JOptionPane.showMessageDialog(null, teksti, "Sanasta sanaan-tulokset", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Luo ja avaa ohjelman graafisen kayttoliittyman.
     *
     * @param args Unused.
     * @throws IOException if stream to a File cannot be written to or closed.
     * @throws javax.xml.parsers.ParserConfigurationException
     * @throws org.xml.sax.SAXException
     */
    public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException {
        SanastaSanaanGui akkuna = new SanastaSanaanGui();
        akkuna.setVisible(true);
    }
}
