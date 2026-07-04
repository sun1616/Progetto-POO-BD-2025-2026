package gui;

import controller.Controller;
import Exception.AccountNotFoundedException;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class Account {
    private JLabel numero_streamingLabel;
    private JLabel numero_videoLabel;
    private JLabel numero_iscrittiLabel;
    private JLabel nomeLabel;
    private JLabel idLabel;
    private JButton iscrivitiButton;
    private JButton backButton;
    private JPanel mainPanel;

    private Controller controller;
    private JFrame frame;

    private String accountSelectedId;

    /**
     * Instantiates a new Account.
     * Dimostra info di account selezionato
     * Frame Indipendente
     *
     * @param controller        the controller
     * @param accountSelectedId the account selected id
     */
    public Account(Controller controller, String accountSelectedId) {
        this.controller = controller;
        this.accountSelectedId = accountSelectedId;

        frame = Login.frameCreator("Account info", 400, 300, mainPanel);

        try {
            prepareAccountData();
        } catch (AccountNotFoundedException e) {
            throw new RuntimeException("Account not founded! Aid: " + accountSelectedId);
        }

        // Il bottone per chiudere finestra
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });

        // Il bottone per creare un'iscrizione dall'utente al account selezionato
        iscrivitiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (controller.checkIscrizioneSameAccount()) {
                    JOptionPane.showMessageDialog(null, "Non puoi iscrivere a te stessa!", "Error" , JOptionPane.WARNING_MESSAGE);
                }
                try {
                    controller.addIscritti(accountSelectedId);
                    numero_iscrittiLabel.setText(controller.getAccountNumero_iscritti(accountSelectedId).toString());
                    JOptionPane.showMessageDialog(null, "Account iscritto con successo!");
                } catch (AccountNotFoundedException ex) {
                    throw new RuntimeException("Account not founded! Aid: " + accountSelectedId);
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Iscrizione ripetetiva!", "Error", JOptionPane.ERROR_MESSAGE);
                    throw new RuntimeException("Iscrizione ripetetiva!  Aid: " + accountSelectedId);
                }
            }
        });

    }

    /**
     * Prepare account data.
     *
     * @throws AccountNotFoundedException the account not founded exception
     */
    public void prepareAccountData() throws AccountNotFoundedException {
        nomeLabel.setText(" " + controller.getAccountNome(accountSelectedId));
        idLabel.setText(" " + accountSelectedId);
        numero_iscrittiLabel.setText(controller.getAccountNumero_iscritti(accountSelectedId).toString());
        numero_videoLabel.setText(controller.getAccountNumero_video(accountSelectedId).toString());
        numero_streamingLabel.setText(controller.getAccountNumero_streaming(accountSelectedId).toString());
    }

}
