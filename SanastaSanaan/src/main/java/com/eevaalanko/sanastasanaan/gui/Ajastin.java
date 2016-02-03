package com.eevaalanko.sanastasanaan.gui;

import com.eevaalanko.sanastasanaan.logiikka.HyvaksytytSanat;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Ajastin extends JPanel {

    public Timer timer;
    public long startTime = -1;
    public long duration = 100000;

    /**
     *
     */
    public JLabel label;
    

    public Ajastin() {
        setLayout(new GridBagLayout());

        timer = new Timer(10, new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                if (startTime < 0) {
                    startTime = System.currentTimeMillis();
                }
                long now = System.currentTimeMillis();
                long clockTime = now - startTime;
                if (clockTime >= duration) {
                    clockTime = duration;
                    timer.stop();
                }
                SimpleDateFormat df = new SimpleDateFormat("mm:ss:SSS");
                label.setText(df.format(duration - clockTime));
            }
        });
        timer.setInitialDelay(0);
        label = new JLabel("00:00:00");
        add(label);
    }

    public void startTimer() {
        if (!timer.isRunning()) {
            startTime = -1;
            timer.start();
        }
    }

    class AlsTulokset implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(100, 50);
    }

}
