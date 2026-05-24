package controller;

import model.Account;

import java.util.ArrayList;

public class Controller {
    private ArrayList<Account> accounts;

    public Controller() {
        accounts = new ArrayList<>();
    }

    // Registra Account
    // Controlla se nell'email contiene @ e nel password contiene almeno una lettera maiuscola
    public boolean registra(String email, String password){
        boolean flag = false;
        for (Character c : password.toCharArray()) {
            if(Character.isUpperCase(c)) {
                flag = true;
                break;
            }
        }
        return flag && email.contains("@");
    }

    // Crea account finti
    public void aggiungiAccount(Account account){
        accounts.add(account);
    }

    public void createAccount(){
        Account a1 = new Account("1", "Fabrizio1", "fabrizio1@gmail.com", "Bruno1");
        Account a2 = new Account("2", "Fabrizio2", "fabrizio2@gmail.com", "Bruno2");
        Account a3 = new Account("3", "Fabrizio3", "fabrizio3@gmail.com", "Bruno3");
        Account a4 = new Account("4", "Fabrizio4", "fabrizio4@gmail.com", "Bruno4");
        Account a5 = new Account("5", "Fabrizio5", "fabrizio5@gmail.com", "Bruno5");

        aggiungiAccount(a1);
        aggiungiAccount(a2);
        aggiungiAccount(a3);
        aggiungiAccount(a4);
        aggiungiAccount(a5);
    }

    // Check email e password Account
    // Ritorna una lista di stringa
    public ArrayList<String> checkEmail(){
        ArrayList<String> emailList = new ArrayList<>();
        for(Account a : accounts) {
            emailList.add(a.getEmail());
        }
        return emailList;
    }

    public ArrayList<String> checkPassword(){
        ArrayList<String> passwordList = new ArrayList<>();
        for(Account a : accounts) {
            passwordList.add(a.getPassword());
        }
        return passwordList;
    }

    // Login
    // Si controlla tutte le email salvate in accounts, se la trova uguale, allora controlla password
    public boolean login(String email, String password){
        boolean flag = false;
        ArrayList<String> emailList = checkEmail();
        ArrayList<String> passwordList = checkPassword();

        for(String e : emailList){
            if(e.equals(email)){
                for (String p : passwordList){
                    if(p.equals(password)){
                        flag = true;
                        break;
                    }
                }
            }
        }

        return flag;
    }
}
