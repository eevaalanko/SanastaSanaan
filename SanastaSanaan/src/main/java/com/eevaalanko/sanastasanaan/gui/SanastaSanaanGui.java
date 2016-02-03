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
import java.util.Collection;

import javax.swing.JFrame;

/**
 *
 * @author Eeva
 */
public final class SanastaSanaanGui extends JFrame {
    
    private final Sanavarasto varasto = new Sanavarasto();
    private final HyvaksytytSanat hyvaksytyt = new HyvaksytytSanat();
    
    private final Color cEka = new Color(122, 187, 203);
    private final Color cToka = new Color(0, 204, 204);
    private final Color cKolmas = new Color(150, 159, 161);
    private final Color cNeljas = new Color(0, 128, 128);
    private final Color cViides = new Color(51, 255, 255);
    
    private final JPanel paEka = new JPanel(new FlowLayout(FlowLayout.LEFT));
    private final JPanel paToka = new JPanel(new FlowLayout(FlowLayout.LEFT));
    private final JPanel paKolmas = new JPanel(new FlowLayout(FlowLayout.LEFT));
    private final JPanel paNeljas = new JPanel(new FlowLayout(FlowLayout.LEFT));
    private final JPanel paPohjaVasen = new JPanel(new GridLayout(2, 1)); // 4 iv 1
    private final JPanel paPohjaOikea = new JPanel(new GridLayout(1, 0));
    private final JPanel paAlusta = new JPanel(new GridLayout(0, 2));
    
    private final JButton btAloita = new JButton("Aloita peli.");
    private final JButton btLisaaSana = new JButton("Lisää sana");
    private final JButton btInfo = new JButton("OHJEET");
    private final JButton btUusiPeli = new JButton("Uusi peli.");
    
    private final JLabel jlPisteet = new JLabel("Amat victoria curam.");
    private final JLabel jlEka = new JLabel("Valitse avainsana:            ");
    private final JLabel jlValittuAvainsana;
    private final JLabel jlTimer = new JLabel("00:00:00");
    
    private final JComboBox cbValinta;
    private final JFormattedTextField tfSana = new JFormattedTextField();
    private final TextArea taHyvaksytyt = new TextArea();
    
    private Timer timer;
    public long startTime = -1;
    public long duration = 100000;

    public SanastaSanaanGui() throws IOException {
        Collection avainlista = varasto.sanakirja.annaAvainsanat();
        Object o[] = avainlista.toArray(new Object[avainlista.size()]);
        this.cbValinta = new JComboBox(o);
        this.cbValinta.setPreferredSize(new Dimension(150, 24));
        this.jlValittuAvainsana = new JLabel();
        this.tfSana.setPreferredSize(new Dimension(200, 24));
        this.setSize(200, 200);
        this.setTitle("Sanasta sanaan");
        this.setLocation(100, 150);
        asetteleKomponentit();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        timer = new Timer(10, (ActionListener) new AlsAjastin());
        
    }
    
    public void asetteleKomponentit() {
        paEka.add(jlEka);
        paEka.add(cbValinta);
        paEka.add(btAloita);
        
        paToka.add(tfSana);
        paToka.add(btLisaaSana);
        
        paKolmas.add(jlPisteet);
        paKolmas.add(btInfo);
//        paKolmas.add(btUusiPeli);              //todo, ei toimi vielä
        
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
        btInfo.addActionListener(new AlsInfo());
        btUusiPeli.addActionListener(new AlsAloitaAlusta());
    }
    
    class AlsLisaaSana implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent e) {
            String avainsana = jlValittuAvainsana.getText();
            String sana = tfSana.getText();
            boolean ok = hyvaksytyt.lisaaSana(avainsana, sana);
            if (ok) {
                taHyvaksytyt.append(sana + "\n");
            }
            tfSana.setText("");
        }
    }
    
    class AlsAloita implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent e) {
            timer.start();
            jlValittuAvainsana.setText(cbValinta.getSelectedItem().toString());
            paPohjaVasen.add(paToka);
            paPohjaVasen.remove(paEka);
        }
    }
    
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
                timer.restart();
                jlTimer.setText("00:00:00");
                naytaTulokset();
            }
            SimpleDateFormat df = new SimpleDateFormat("mm:ss:SSS");
            jlTimer.setText(df.format(duration - clockTime));
        }
    }
    
    public void naytaTulokset() {
        int oikeaMaara = varasto.sanakirja.laskeSanalista(jlValittuAvainsana.getText());
        int saatuMaara = hyvaksytyt.laskeSanat();
        String teksti = "Tuloksesi: " + saatuMaara + "/" + oikeaMaara;
        JOptionPane.showMessageDialog(null, teksti, "Sanasta sanaan-tulokset", JOptionPane.INFORMATION_MESSAGE);
        
    }
    
    class AlsInfo implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent e) {
            String teksti = "Muodosta mahdollisimman monta eri sanaa avainsanan kirjaimista ennen kuin aika loppuu.\n"
                    + "Mitä enemmän sanoja, sen enemmän pisteitä.\n"
                    + "Sanojen tulee olla suomenkielisiä ja perusmuodossa, yksikössä tai monikossa. \n"
                    + "Erisnimet ja yhdyssanat eivät kelpaa.";
            JOptionPane.showMessageDialog(null, teksti, "Sanasta sanaan- peliohjeet", JOptionPane.INFORMATION_MESSAGE);
            
        }
    }
    
    //TODO: make this work...
    
    class AlsAloitaAlusta implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent e) {
            timer.stop();
            jlTimer.setText("00:00:00");
            jlTimer.removeAll();
            tfSana.setText("");
            taHyvaksytyt.setText("");
            jlValittuAvainsana.setText("");
            
            timer = new Timer(10, (ActionListener) new AlsAjastin());
            paPohjaVasen.remove(paToka);
            paPohjaVasen.add(paEka);
            
            paAlusta.revalidate();
            paAlusta.repaint();
            
        }
    }
    
    public static void main(String[] args) throws IOException {
        SanastaSanaanGui akkuna = new SanastaSanaanGui();
        akkuna.setVisible(true);
        
    }
    
}
