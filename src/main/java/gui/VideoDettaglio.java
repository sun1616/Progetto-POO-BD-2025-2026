package gui;

import controller.Controller;
import Exception.AccountNotFoundedException;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class VideoDettaglio {
    private JLabel titoloLabel;
    private JButton likeButton;
    private JPanel mainPanel;
    private JLabel numeroVisualLabel;
    private JLabel numeroLikeLabel;
    private JButton recensioniButton;
    private JButton backButton;
    private JLabel uploaderLabel;
    private JLabel videoLabel;
    private JTextArea descrizioneArea;
    private JButton viewUploader;

    private JFrame frame;
    private Controller controller;
    private Account uploader;
    private Recensione recensioni;

    /**
     * Instantiates a new Video dettaglio.
     * Presenta video selezionato
     * Frame Principale 4
     *
     * @param controller the controller
     * @param frame      the frame
     * @param videoPadre the video padre
     */
    public VideoDettaglio(Controller controller, JFrame frame, Video videoPadre) {
        this.frame = frame;
        this.controller = controller;
        uploader = null;
        recensioni = null;

//      URL location = getClass().getResource("/images/videoExample.jpg");
//      videoLabel.setIcon(new ImageIcon(location));

        titoloLabel.setText(controller.getCurrentVideoTitolo());
        try {
            uploaderLabel.setText("Uploader:  " + controller.getAccountNome(controller.getAccountSelectedId()));
        } catch (AccountNotFoundedException e) {
            throw new RuntimeException(e);
        }
        descrizioneArea.setText("Descrizione:\n" + controller.getCurrentVideoDescerzione());
        numeroLikeLabel.setText("Numero Like: " + controller.getCurrentVideoNumeroLike().toString());
        numeroVisualLabel.setText("Numero Visual: " + controller.getCurrentVideoNumeroVisual().toString());

        // Il Bottone per ritornare a Frame 3 Video
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Login.switchPanel(frame, videoPadre.getMainPanel());
            }
        });

        // Il bottone per aggiunge like al video
        likeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.addLikeToCurrentVideo();
                videoPadre.refreshVideoTable();
                numeroLikeLabel.setText("Numero Like: " + controller.getCurrentVideoNumeroLike().toString());
            }
        });

        // Il bottone per aprire la finestra Recensione del video corrispondente
        recensioniButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (recensioni == null) {
                    recensioni = new Recensione(controller, VideoDettaglio.this);
                } else {
                    recensioni.toFront();
                }
            }
        });

        // Il bottone per aprire la Finestra Account del uploader di video
        viewUploader.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    uploader = new Account(controller, controller.getAccountSelectedId());
            }
        });
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
     * Clear recensioni reference.
     */
    public void clearRecensioniReference() {
        recensioni = null;
    }
}
