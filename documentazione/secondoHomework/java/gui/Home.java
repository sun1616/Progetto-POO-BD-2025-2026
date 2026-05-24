package gui;

import controller.Controller;
import Exception.*;
import model.Account;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class Home {
    private JPanel mainPanel;
    private JTextField emailTextField;
    private JButton entraButton;
    private JButton registratiButton;
    private JPasswordField passwordTextField;
    private static JFrame frameHome;
    private Controller controller;

    public static void main(String[] args) {
        frameHome = new JFrame("Home");
        frameHome.setContentPane(new Home().mainPanel);
        frameHome.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameHome.pack();
        frameHome.setVisible(true);

    }

    public Home() {
        controller = new Controller();
        controller.createAccount();

        // Registra account, manca la parte di database
        registratiButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {

                String email = emailTextField.getText();
                String password = String.valueOf(passwordTextField.getPassword());

                try {
                    if(controller.registra(email, password)) {
                        String username = JOptionPane.showInputDialog(null, "Registrazione con successo!\nInserisci username");
                        Account nuovoAccount = new Account("admin1", username, email, password);
                        controller.aggiungiAccount(nuovoAccount);
                        JOptionPane.showMessageDialog(null, "Account creato!");
                    } else {
                        throw new RegistraException("Registra fallita");
                    }
                } catch (RegistraException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });


        entraButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = emailTextField.getText();
                String password = String.valueOf(passwordTextField.getPassword());

                try {
                    if(controller.login(email, password)) {
                        JOptionPane.showMessageDialog(null, "Ben ritornato!");
                    } else {
                        throw new AccountNotFoundedException("Login fallita, controlla email/password");
                    }
                } catch (AccountNotFoundedException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });
    }

}
