package gui;

import controller.Controller;
import Exception.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class Recensione {
    private JPanel mainPanel;
    private JTextArea descrizioneArea;
    private JComboBox recensioneComboBox;
    private JButton likeButton;
    private JButton viewButton;
    private JButton addRecensioneButton;

    private Controller controller;
    private JFrame frame;
    private AddRecensione addRecensione;

    /**
     * Instantiates a new Recensione.
     * Dimostra le recensioni di un video
     * Frame indipendente
     * Creato da VideoDettaglio
     * @param controller          the controller
     * @param videoDettaglioPadre the video dettaglio padre
     */
    public Recensione(Controller controller, VideoDettaglio videoDettaglioPadre) {
        this.controller = controller;
        addRecensione = null;

        frame = Login.frameCreator("Recensione", 600, 500, mainPanel);

        try {
            controller.getAllRecensione();
        } catch (SQLException e) {
            throw new RuntimeException("Recensione non trovata");
        } catch (AccountNotFoundedException e) {
            throw new RuntimeException("Account rifeito alla recensione non trovata");
        }

        refreshRecensione();

        // Il bottone per aggiungere un Like alla recensione selezionato
        likeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.addLikeToRecensione(recensioneComboBox.getSelectedItem().toString());
                controller.setCurrentRecensioni();
                descrizioneArea.setText(controller.preparaRecensioni());
            }
        });

        // Il bottone per aprire la finestra Account di account selezionato
        viewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String currentAid = controller.getAidFromRid(recensioneComboBox.getSelectedItem().toString());
                    controller.setAccountSelected(currentAid);
                    new Account(controller, currentAid);
                } catch (RecensioneNotFoundedException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        // Il bottone per aprire finestra AddRecensione
        addRecensioneButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (addRecensione == null) {
                    addRecensione = new AddRecensione(controller, Recensione.this);
                } else {
                    addRecensione.toFront();
                }
            }
        });

        // Listner per mandare segnale al VideoDettaglio quando chiude frame
        frame.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent e) {
                videoDettaglioPadre.clearRecensioniReference();
            }
        });
    }

    /**
     * Refresh recensione.
     */
    public void refreshRecensione() {
        controller.setCurrentRecensioni();

        descrizioneArea.setText(controller.preparaRecensioni());

        recensioneComboBox.removeAllItems();
        for (String rid : controller.getAllIDRecensioni()) {
            recensioneComboBox.addItem(rid);
        }
    }

    /**
     * Gets main panel.
     *
     * @return the main panel
     */
    public JPanel getMainPanel() {
        return mainPanel;
    }

    /**
     * frame To front.
     */
    public void toFront() {
        frame.toFront();
    }

    /**
     * Clear add rencensione reference.
     */
    public void clearAddRencensioneReference() {
        this.addRecensione = null;
    }
}
