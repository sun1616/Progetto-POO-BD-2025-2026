package gui;

import controller.Controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class AddVideo {
    private JButton cancelButton;
    private JButton uploadButton;
    private JTextField titoloTextField;
    private JTextField tupoTextField;
    private JTextField descrizioneTextField;
    private JTextField durataTextField;
    private JPanel mainPanel;

    private JFrame frame;
    private Controller controller;

    /**
     * Instantiates a new Add video.
     * Frame Indipendente
     * Viene creato da Video
     *
     * @param controller the controller
     * @param videoPadre the video padre
     */
    public AddVideo(Controller controller, Video videoPadre) {
        this.controller = controller;

        frame = Login.frameCreator("Add Video", 400, 300, mainPanel);

        // Il bottone per aggiungere un nuovo video
        uploadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 1. prendere dati inseriti e controlla
                String titolo = titoloTextField.getText();
                String descrizione = descrizioneTextField.getText();
                String tipo = tupoTextField.getText();
                String durata_secondiStr = durataTextField.getText();
                int durata_secondi = 0;


                if (titolo.isBlank() || descrizione.isBlank() || tipo.isBlank() || durata_secondiStr.isBlank()) {
                    JOptionPane.showMessageDialog(null, "Upload falito\nControlla se hai scritto qualcosa in tutte le celle");
                    return;
                }

                try {
                    durata_secondi = Integer.parseInt(durata_secondiStr);
                }  catch (NumberFormatException e1) {
                    JOptionPane.showMessageDialog(null, "Upload falito\nControlla se hai scrito solo numeri naturali in cella \"durata\"");
                    return;
                }
                if (durata_secondi <= 0) {
                    JOptionPane.showMessageDialog(null, "Upload falito\ndurata non può essere negativo o 0");
                    return;
                }
                // 2. prova ad aggiungere nel db e locale videos
                //    una volta fatto, si chiude da solo
                try {
                    controller.aggiungiVideo(titolo, descrizione, tipo, durata_secondi);
                    JOptionPane.showMessageDialog(null, "Upload con successo!");
                    videoPadre.refreshVideoTable();
                    frame.dispose();
                }  catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Errore del database.", "Errore", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Il bottone per chiudere frame
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });

        // Listner di frame, quando utende lo chiude manda un segnale al Video
        frame.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent e) {
                videoPadre.clearAddVideoReference();
            }
        });
    }

    /**
     * Frame To front.
     */
    public void toFront() {
        frame.toFront();
    }
}

