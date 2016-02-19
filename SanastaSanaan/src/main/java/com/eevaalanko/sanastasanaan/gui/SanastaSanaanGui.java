/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eevaalanko.sanastasanaan.gui;

import com.eevaalanko.sanastasanaan.logiikka.HyvaksytytSanat;
import com.eevaalanko.sanastasanaan.tietovarasto.Sanavarasto;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.SimpleDateFormat;
import javax.swing.JFrame;

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
    private final Sanavarasto varasto = new Sanavarasto();
    private final AlsInfo ai = new AlsInfo();
    public HyvaksytytSanat hyvaksytyt;
    private final Color cEka = new Color(122, 187, 203);
    private final Color cToka = new Color(0, 204, 204);
    private final Color cKolmas = new Color(150, 159, 161);
    private final Color cNeljas = new Color(0, 128, 128);
    private final Color cViides = new Color(51, 255, 255);
    private final JPanel paEka = new JPanel(new FlowLayout(FlowLayout.LEFT));
    private final JPanel paToka = new JPanel(new FlowLayout(FlowLayout.LEFT));
    private final JPanel paKolmas = new JPanel(new FlowLayout(FlowLayout.LEFT));
    private final JPanel paNeljas = new JPanel(new FlowLayout(FlowLayout.LEFT));
    private final JPanel paPohjaVasen = new JPanel(new GridLayout(3, 1)); 
    private final JPanel paPohjaOikea = new JPanel(new GridLayout(1, 0));
    private final JPanel paAlusta = new JPanel(new GridLayout(0, 2));
    private final JButton btAloita = new JButton("Aloita peli.");
    private final JButton btLisaaSana = new JButton("Lisää sana");
    public JButton btInfo = new JButton("OHJEET");
    private final JLabel jlPisteet = new JLabel("Amat victoria curam.");
    private final JLabel jlEka = new JLabel("Valitse avainsana:            ");
    private final JLabel jlValittuAvainsana = new JLabel();
    public JLabel jlTimer = new JLabel("00:00:00");
    public Object[] avainlista;
    private  JComboBox cbValinta;
    private final JFormattedTextField tfSana = new JFormattedTextField();
    private final TextArea taHyvaksytyt = new TextArea();
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
    public SanastaSanaanGui() throws IOException {
        avainlista = varasto.sanakirja.annaAvainsanat();
        cbValinta = new JComboBox(avainlista);
        this.cbValinta.setPreferredSize(new Dimension(150, 24));
        this.tfSana.setPreferredSize(new Dimension(200, 24));
        this.timer = new Timer(10, (ActionListener) new AlsAjastin());
        this.setSize(200, 200);
        this.setTitle("Sanasta sanaan");
        this.setLocation(100, 150);
        asetteleKomponentit();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    /**
     * Metodi asettelee komponentit Jpanel alustaan. Asettaa alustan JFrame'iin.
     * Asettaa JFrame'ille standardikoon. Lisaa tapahtumankuuntelijat
     * painikkeisiin.
     */
    public void asetteleKomponentit() {
        paEka.add(jlEka);
        paEka.add(cbValinta);
        paEka.add(btAloita);
        paToka.add(tfSana);
        paToka.add(btLisaaSana);
        paKolmas.add(jlPisteet);
        paKolmas.add(btInfo);
        paNeljas.add(jlTimer);
        paNeljas.add(jlValittuAvainsana);
        paNeljas.add(taHyvaksytyt);
        paPohjaVasen.add(paEka);
        paPohjaVasen.add(paKolmas);
        paPohjaVasen.add(paKolmas);
        paPohjaOikea.add(paNeljas);
        paEka.setBackground(cEka);
        paToka.setBackground(cToka);
        paKolmas.setBackground(cKolmas);
        paNeljas.setBackground(cNeljas);
        cbValinta.setBackground(cToka);
        btLisaaSana.setBackground(cEka);
        btInfo.setBackground(cViides);
        jlTimer.setBackground(cEka);
        jlTimer.setForeground(Color.white);
        jlValittuAvainsana.setForeground(Color.yellow);
        paAlusta.add(paPohjaVasen);
        paAlusta.add(paPohjaOikea);
        this.add(paAlusta);
        this.setSize(620, 350);
        btAloita.addActionListener(new AlsAloita());
        btLisaaSana.addActionListener(new AlsLisaaSana());
        btInfo.addActionListener(ai);
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
        }
    }

    /**
     * Sisainen tapahtumenkuuntelijaluokka kaynnistaa ajastimen ja lisaa
     * sanojenlisayspaneelin peliin.
     */
    class AlsAloita implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            timer.start();
            String avainsana = cbValinta.getSelectedItem().toString();
            jlValittuAvainsana.setText(avainsana);
            hyvaksytyt = new HyvaksytytSanat(avainsana);
            paPohjaVasen.add(paToka);
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
                jlTimer.setText("00:00:00");
                naytaTulokset();
            }
            SimpleDateFormat df = new SimpleDateFormat("mm:ss:SSS");
            jlTimer.setText(df.format(duration - clockTime));
        }
    }

    /**
     * Laskee hyvaksytyt sanat.Avaa tulokset sisaltavan JOptionPane paneelin.
     */
    public void naytaTulokset() {
        String avainsana = jlValittuAvainsana.getText();
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
     */
    public static void main(String[] args) throws IOException {
        SanastaSanaanGui akkuna = new SanastaSanaanGui();
        akkuna.setVisible(true);
    }
}
