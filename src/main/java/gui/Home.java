package gui;

import controller.Controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class Home {
    private JButton streamingButton;
    private JButton videoButton;
    private JPanel mainPanel;
    private JCheckBox clientePremiumCheckBox;

    private Controller controller;
    private JFrame frame;

    /**
     * Instantiates a new Home.
     * Frame Principale 2
     * @param controller the controller
     * @param frame      the frame
     */
    public Home(Controller controller, JFrame frame) {
        this.frame = frame;
        this.controller = controller;

        /*streamingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });*/

        // Il Bottone per passare a frame 3 Video e ingrandire il frame a 800 600
        videoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setSize(800, 600);
                Login.switchPanel(frame, new Video(controller, frame, Home.this).getMainPanel());
            }
        });

        // Un checkbox per settare lo stato cliente premium
        clientePremiumCheckBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    controller.setVip(true);
                } else if (e.getStateChange() == ItemEvent.DESELECTED) {
                    controller.setVip(false);
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
}
