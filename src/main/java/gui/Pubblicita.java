package gui;

import controller.Controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Pubblicita {
    private JPanel mainPanel;
    private JButton skipButton;
    private JLabel responsorLabel;
    private JLabel linkEsternoLabel;
    private JLabel skipDurataLabel;
    private JLabel countdownLabel;
    private JLabel titoloLabel;

    private Controller controller;
    private JFrame frame;
    private Timer timer;

    private Integer timeLeft;
    private Integer skipLeft;

    /**
     * Instantiates a new Pubblicita.
     * Frame indipendente
     * Creato da Video
     *
     * @param controller the controller
     */
    public Pubblicita(Controller controller) {
        this.controller = controller;
        frame = new JFrame("Pubblicita");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.add(mainPanel);
        frame.setVisible(true);

        controller.setPubblicitaExample();
        timeLeft = controller.getPubblicitaExampleDurataSecondi();
        skipLeft = controller.getPubblicitaExampleDurataSkip();

        titoloLabel.setText(controller.getPubblicitaExampleTitolo());
        countdownLabel.setText(timeLeft.toString());
        responsorLabel.setText(controller.getPubblicitaExampleNomeResponsor());
        linkEsternoLabel.setText(controller.getPubblicitaExampleTLinkEsterno());
        skipDurataLabel.setText(skipLeft.toString());

        // Un timer per conttare il tempo di pubblicita
        // Ogni secondo aggiorna e controllla timeLeft e skipLeft
        // Poi si presenta nella finestra
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (timeLeft > 0) {
                    timeLeft--;
                    countdownLabel.setText(timeLeft.toString());

                    if(skipLeft > 0) {
                        skipLeft--;
                        skipDurataLabel.setText(skipLeft.toString());
                        if (skipLeft == 0) {
                            skipButton.setEnabled(true);
                        }
                    }
                } else {
                    timer.stop();
                    frame.dispose();
                }
            }
        });
        timer.start();

        // Il bottone per chiudere frame
        skipButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
    }

    /**
     * frame To front.
     */
    public void toFront() {
        frame.toFront();
    }
}
