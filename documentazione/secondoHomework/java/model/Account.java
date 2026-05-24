package model;

public class Account {
    private final String ID_Account;
    private String nome;
    private String email;
    private String password;
    private int numero_iscritti;
    private int numero_video;
    private int numero_streaming;

    public Account(String ID_Account, String nome, String email, String password) {
        this.ID_Account = ID_Account;
        this.nome = nome;
        this.email = email;
        this.password = password;
        this.numero_iscritti = 0;
        this.numero_video = 0;
        this.numero_streaming = 0;
    }

    // Getter
    public String getID_Account() {
        return ID_Account;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public int getNumero_iscritti() {
        return numero_iscritti;
    }

    public int getNumero_video() {
        return numero_video;
    }

    public int getNumero_streaming() {
        return numero_streaming;
    }

    // Adder
    public int aumenta_numero_iscritti() {
        numero_iscritti++;
        return numero_iscritti;
    }

    public int aumenta_numero_iscritti(int num) {
        numero_iscritti += num;
        return numero_iscritti;
    }

    public int aumenta_numero_video() {
        numero_video++;
        return numero_video;
    }

    public int aumenta_numero_streaming() {
        numero_streaming++;
        return numero_streaming;
    }

    // Login
    public boolean login(String email, String password) {
        if (this.email.equals(email) && this.password.equals(password)) {
            return true;
        }
        return false;
    }
}
