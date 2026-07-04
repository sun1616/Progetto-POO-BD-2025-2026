package gui;

import controller.Controller;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class Video {
    private JTable videoTable;
    private JPanel mainPanel;
    private JButton backButton;
    private JButton viewButton;
    private JTextArea descrizioneArea;
    private JButton addNewVideoButton;

    private Controller controller;
    private JFrame frame;
    private AddVideo addVideo;

    /**
     * Instantiates a new Video.
     * Frame Principale 3.
     * Da qui in poi si può andre in diestor al Frame Principale precedente
     *
     * @param controller the controller
     * @param frame      the frame
     * @param homePadre  the home padre
     */
    public Video(Controller controller, JFrame frame, Home homePadre) {
        this.frame = frame;
        this.controller = controller;

        addVideo = null;

        // Prova ad aggiornare dati da db e prensentarli sul table
        try {
            controller.getALLVideos();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        this.refreshVideoTable();

        // Listner che si attiva ogni volta utente seleziona una cella
        // Si aggiorna il video selezionato in controller e il testo di descrizione corrispondente
        ListSelectionModel selectionModel = videoTable.getSelectionModel();
        selectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        selectionModel.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int selectedRow = videoTable.getSelectedRow();
                    int selectedColumn = videoTable.getSelectedColumn();
                    if (selectedRow != -1 && selectedColumn != -1) {
                        controller.setCurrentVideo(videoTable.getValueAt(selectedRow,0).toString());
                        controller.setAccountSelected(videoTable.getValueAt(selectedRow,1).toString());
                        descrizioneArea.setText("Descrizione:\n" + controller.getVideoDescrizione(controller.getCurrentVideoId()));
                    }
                }
            }
        });

        // Il bottone per ritornare a Frame 2 Home e diminuire dimensione a 400,300
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setSize(400, 300);
                Login.switchPanel(frame, homePadre.getMainPanel());
            }
        });

        // Il bottone per passare a Frame 4 VideoDettaglio
        // Se utende non è vip, allora apre anche Frame pubblicita
        viewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (controller.getCurrentVideoId().equals("")) {
                    JOptionPane.showMessageDialog(null, "Errore del selezione\nControlla se hai selezionato un video.", "Errore", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (!controller.checkVip()) {
                    new Pubblicita(controller);
                }

                controller.addVisualToCurrentVideo();
                Video.this.refreshVideoTable();
                Login.switchPanel(frame, new VideoDettaglio(controller, frame, Video.this).getMainPanel());
            }
        });

        // Il bottone per aprire la finestra AddNewVideo
        addNewVideoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Controlla se esiste finestra addVideo
                if (addVideo == null) {
                    addVideo = new AddVideo(controller, Video.this);
                } else {
                    addVideo.toFront();
                }
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
     * Clear add video reference.
     */
    public void clearAddVideoReference() {
        this.addVideo = null;
    }

    /**
     * Aggiornare i dati da db e aggiornare table.
     */
    public void refreshVideoTable() {
        try {
            controller.getALLVideos();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        videoTable.setModel(controller.prepareVideoTableData());
        videoTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        videoTable.getColumnModel().getColumn(2).setPreferredWidth(400);
        videoTable.getTableHeader().setReorderingAllowed(false);
        videoTable.getTableHeader().setResizingAllowed(false);
        videoTable.getRowSorter().toggleSortOrder(0);
    }
}
