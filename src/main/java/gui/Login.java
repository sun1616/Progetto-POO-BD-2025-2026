package gui;

import controller.Controller;
import Exception.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class Login {
    private JPanel mainPanel;
    private JTextField emailTextField;
    private JButton entraButton;
    private JButton registratiButton;
    private JPasswordField passwordTextField;
    private JFrame frame;

    private Controller controller;

    /**
     * Instantiates a new Login con frame iniziale di dimensione 400,300.
     * Questo frame è frame principale di tutto il programmma
     * Frame principale 1
     */
    public Login() {
        controller = new Controller();
        try {
            controller.getALLAccounts();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        frame = new JFrame("RiftView");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.add(mainPanel);

        // Registra account
        registratiButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {

                // 1. Acquisisce i dati inseriti email, password e nome dall'utende e controlla
                String email = emailTextField.getText();
                String password = String.valueOf(passwordTextField.getPassword());

                    // Controllo di @ e lettera maiuscola
                if(!email.contains("@") || password.toLowerCase().equals(password)) {
                    JOptionPane.showMessageDialog(null, "Registra fallita\nControlla se ha messo @ in email e almeno una lettera maiuscola in password");
                    return;
                }

                String nome = JOptionPane.showInputDialog(null, "Registrazione quasi finito!\nInserisci username");

                if (nome == null || nome.trim().isBlank()) {
                    return;
                }

                // 2. Richiede al controller di registrare un account
                try {
                    controller.registra(nome, email, password);
                    JOptionPane.showMessageDialog(null, "Registrazione con successo!\nAccount creato!");

                }  catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Errore del database.", "Errore", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Prova ad accedere un account esistente
        entraButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 1. Acquisisce i dati inseriti email, password e nome dall'utende e controlla

                String email = emailTextField.getText();
                String password = String.valueOf(passwordTextField.getPassword());

                    // Controllo di @ e lettera maiuscola
                if(!email.contains("@") || password.toLowerCase().equals(password)) {
                    JOptionPane.showMessageDialog(null, "Login fallita\nControlla se ha messo @ in email e almeno una lettera maiuscola in password");
                    return;
                }

                // 2. Richiede al controller di provaere ad accedere un account
                try {
                    controller.login(email, password);
                    JOptionPane.showMessageDialog(null, "Ben ritornato!");
                    switchPanel(frame, new Home(controller, frame).getMainPanel());

                } catch (AccountNotFoundedException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });
    }

    /**
     * Switch panel.
     * Cancella conenuti di frame principale e Passare al panel indicato, poi refresh
     *
     * @param frame    the frame
     * @param newPanel the new panel
     */
    public static void switchPanel(JFrame frame, JPanel newPanel) {
        frame.getContentPane().removeAll();
        frame.add(newPanel);
        frame.getContentPane().revalidate();
        frame.getContentPane().repaint();
    }

    /**
     * Frame creator Jframe.
     * Restuisce un Jframe indipendente
     *
     * @param framename the framename
     * @param width     the width
     * @param height    the height
     * @param mainPanel the main panel
     * @return the Jframe
     */
    public static JFrame frameCreator(String framename, int width, int height, JPanel mainPanel) {
        JFrame frame = new JFrame(framename);
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.add(mainPanel);
        frame.setVisible(true);

        return frame;
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     * @throws SQLException the sql exception
     */
    public static void main(String[] args) throws SQLException {
        Login login = new Login();
        login.frame.setVisible(true);
    }
}
