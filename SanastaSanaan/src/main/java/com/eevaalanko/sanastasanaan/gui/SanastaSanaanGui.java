/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eevaalanko.sanastasanaan.gui;

import com.eevaalanko.sanastasanaan.tietovarasto.Sanavarasto;
import java.awt.event.*;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;

import javax.swing.JFrame;

/**
 *
 * @author Eeva
 */
public final class SanastaSanaanGui extends JFrame {

    private Ajastin ajastin;
    private final Sanavarasto varasto = new Sanavarasto();

    private final Color cEka = new Color(122, 187, 203);
    private final Color cToka = new Color(0, 204, 204);
    private final Color cKolmas = new Color(0, 128, 128);
    private final Color cNeljas = new Color(150, 159, 161);
    private final Color cViides = new Color(51, 255, 255);

    private final JPanel paEka = new JPanel(new FlowLayout(FlowLayout.LEFT));
    private final JPanel paToka = new JPanel(new FlowLayout(FlowLayout.LEFT));
    private final JPanel paKolmas = new JPanel(new FlowLayout(FlowLayout.LEFT));
    private final JPanel paVika = new JPanel(new FlowLayout(FlowLayout.LEFT));
    private final JPanel paPohjaVasen = new JPanel(new GridLayout(3, 1)); // 4 iv 1
    private final JPanel paPohjaOikea = new JPanel(new GridLayout(1, 0));
    private final JPanel paAlusta = new JPanel(new GridLayout(0, 2));

    private final JButton btAloita = new JButton("Aloita peli.");
    private final JButton btLisaaSana = new JButton("Lisää sana");
    private final JButton btInfo = new JButton("INFO");
    private final JLabel jlPisteet = new JLabel("Amat victoria curam.");
    private final JLabel jlEka = new JLabel("Valitse sana:            ");

    private final ArrayList avainlista;

    private final JComboBox cbValinta;
    private final JFormattedTextField tfSana;

    public SanastaSanaanGui() throws IOException {
        ajastin = new Ajastin();

        this.tfSana = new JFormattedTextField("                                 ");

        this.avainlista = varasto.sanakirja.annaAvainsanat();
        Object o[] = (Object[]) (Object) avainlista;
        this.cbValinta = new JComboBox(o);
        this.tfSana.setMinimumSize(null);
        this.setSize(200, 200);
        this.setTitle("Sanasta sanaan");
        this.setLocation(100, 150);
        asetteleKomponentit();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void asetteleKomponentit() {
        paEka.add(jlEka);
        paEka.add(cbValinta);
        paEka.add(btAloita);

        paToka.add(tfSana);
        paToka.add(btLisaaSana);

        paVika.add(jlPisteet);
        paVika.add(btInfo);
        paPohjaOikea.add(ajastin);

        paPohjaVasen.add(paEka);
        paPohjaVasen.add(paToka);
        //   paPohjaVasen.add(paKolmas);
        paPohjaVasen.add(paVika);

        paEka.setBackground(cEka);
        paToka.setBackground(cToka);
        paKolmas.setBackground(cKolmas);
        paVika.setBackground(cNeljas);
        cbValinta.setBackground(cToka);
        btLisaaSana.setBackground(cEka);
        btInfo.setBackground(cViides);

        paAlusta.add(paPohjaVasen);
        paAlusta.add(paPohjaOikea);

        this.add(paAlusta);
        this.setSize(620, 350);

        btAloita.addActionListener(new AlsAjastin());
        btLisaaSana.addActionListener(new AlsTarkista());
        btInfo.addActionListener(new AlsInfo());

    }

    class AlsTarkista implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

        }

    }

    class AlsAjastin implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            ajastin.startTimer();
        }
    }

    class AlsVastaukset implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

    class AlsInfo implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String teksti = "Muodosta mahdollisimman monta sanaa avainsanan kirjaimista ennen kuin aika loppuu.\n"
                    + "Mitä enemmän sanoja, sen enemmän pisteitä.\n";
            JOptionPane.showMessageDialog(null, teksti, "Sanasta sanaan-peliohjeet", JOptionPane.INFORMATION_MESSAGE);

        }
    }

    public static void main(String[] args) throws IOException {
        SanastaSanaanGui akkuna = new SanastaSanaanGui();
        akkuna.setVisible(true);

    }

}
