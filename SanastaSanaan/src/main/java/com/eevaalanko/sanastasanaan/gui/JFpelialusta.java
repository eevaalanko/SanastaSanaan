/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eevaalanko.sanastasanaan.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.TextArea;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Eeva
 */
public class JFpelialusta extends JFrame {

    public Color cEka = new Color(122, 187, 203);
    public Color cToka = new Color(0, 204, 204);
    public Color cKolmas = new Color(150, 159, 161);
    public Color cNeljas = new Color(0, 128, 128);
    public Color cViides = new Color(51, 255, 255);
    public JPanel paVasen = new JPanel(new FlowLayout(FlowLayout.LEFT));
    public JPanel paOikea = new JPanel(new FlowLayout(FlowLayout.LEFT));
    public JPanel paPohja = new JPanel(new GridLayout(1, 2));
    public JFormattedTextField tfSana = new JFormattedTextField();
    public JButton btLisaaSana = new JButton("Lisää sana");
    public JLabel jlTimer = new JLabel("00:00:00");
    public JLabel jlValittuAvainsana = new JLabel();
    public TextArea taHyvaksytyt = new TextArea();

    public JFpelialusta() {
        this.tfSana.setPreferredSize(new Dimension(200, 24));
        this.add(paPohja);
        this.setSize(620, 350);
        asetteleKomponentit();
    }

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
    }

}
