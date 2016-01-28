package com.eevaalanko.sanastasanasaan.gui;


import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Ajastin extends JPanel {

        private Timer timer;
        private long startTime = -1;
        private long duration = 100000;

        private JLabel label;

        public Ajastin() {
            setLayout(new GridBagLayout());
            timer = new Timer(10, (ActionEvent e) -> {
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
            });
            timer.setInitialDelay(0);
            addMouseListener(new MouseAdapter() {
//                public void mouseClicked(MouseEvent e) {
//                    if (!timer.isRunning()) {
//                        startTime = -1;
//                        timer.start();
//                    }
//                }
            });
            label = new JLabel("...");
            add(label);
        }
        
        public void startTimer(){
              if (!timer.isRunning()) {
                        startTime = -1;
                        timer.start();
                    }
            
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 50);
        }

    }