/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eevaalanko.sanastasanaan.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JOptionPane;

class AlsInfo implements ActionListener {

    public AlsInfo() throws IOException {
        super();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String teksti = "Muodosta mahdollisimman monta eri sanaa avainsanan kirjaimista ennen kuin aika loppuu.\n"
                + "Mitä enemmän sanoja, sen enemmän pisteitä.\n"
                + "Sanojen tulee olla suomenkielisiä ja perusmuodossa, yksikössä tai monikossa. \n"
                + "Erisnimet ja yhdyssanat eivät kelpaa.";
        JOptionPane.showMessageDialog(null, teksti, "Sanasta sanaan- peliohjeet", JOptionPane.INFORMATION_MESSAGE);

    }

}
