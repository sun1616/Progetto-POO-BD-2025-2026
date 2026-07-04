package gui;

import controller.Controller;
import Exception.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class AddRecensione {
    private JPanel mainPanel;
    private JButton commentaButton;
    private JButton cancelButton;
    private JTextArea recensioneArea;

    private Controller controller;
    private JFrame frame;

    /**
     * Instantiates a new Add recensione.
     * Frame indipendente.
     * Creato da Recensione
     *
     * @param controller      the controller
     * @param recensionePadre the recensione padre
     */
    public AddRecensione(Controller controller, Recensione recensionePadre) {
        this.controller = controller;

        frame = Login.frameCreator("Add Recensione", 400, 300, mainPanel);

        // Il Bottone per chiudere frame
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });

        // Il bottone per aggiungere una recensione
        commentaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 1. Prende dati e controlla
                String recensione = recensioneArea.getText();
                if(!checkRecensione()) {
                    return;
                }

                // 2. Prova ad aggiungere recensione a db e locale recensioni
                try {
                    controller.aggiungiRecensione(recensione);
                    recensionePadre.refreshRecensione();
                    JOptionPane.showMessageDialog(null, "Recensione aggiunto!", "Recensione", JOptionPane.INFORMATION_MESSAGE);
                    frame.dispose();
                } catch (AccountNotFoundedException ex) {
                    throw new RuntimeException("Account della recensione non trovata");
                } catch (SQLException ex) {
                    throw new RuntimeException("DB Recensione fallita");
                }
            }
        });

        // Listner per mandare segnale al Recensione quando chiude frame
        frame.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent e) {
                recensionePadre.clearAddRencensioneReference();
            }
        });
    }

    /**
     * Check recensione boolean.
     *
     * @return the boolean
     */
    public Boolean checkRecensione() {
        String recensione = recensioneArea.getText();
        if (recensione.isBlank()) {
            JOptionPane.showMessageDialog(null, "Inserisci qualcosa in recensione", "Errore", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    /**
     * To front.
     */
    public void toFront() {
        frame.toFront();
    }
}
