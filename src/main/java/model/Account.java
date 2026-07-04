package model;

/**
 * The type Account.
 */
public class Account {
    private final String id_account;
    private String nome;
    private String email;
    private String password;
    private int numero_iscritti;
    private int numero_video;
    private int numero_streaming;

    /**
     * Instantiates a new Account.
     *
     * @param id_account the id account
     * @param nome       the nome
     * @param email      the email
     * @param password   the password
     */
    public Account(String id_account, String nome, String email, String password) {
        this.id_account = id_account;
        this.nome = nome;
        this.email = email;
        this.password = password;
        this.numero_iscritti = 0;
        this.numero_video = 0;
        this.numero_streaming = 0;
    }

    /**
     * Gets id account.
     *
     * @return the id account
     */
// Getter
    public String getId_account() {
        return id_account;
    }

    /**
     * Gets nome.
     *
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * Gets email.
     *
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Gets password.
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Gets numero iscritti.
     *
     * @return the numero iscritti
     */
    public int getNumero_iscritti() {
        return numero_iscritti;
    }

    /**
     * Gets numero video.
     *
     * @return the numero video
     */
    public int getNumero_video() {
        return numero_video;
    }

    /**
     * Gets numero streaming.
     *
     * @return the numero streaming
     */
    public int getNumero_streaming() {
        return numero_streaming;
    }

    /**
     * Aumenta numero iscritti int.
     *
     * @return the int
     */
// Adder
    public int aumenta_numero_iscritti() {
        numero_iscritti++;
        return numero_iscritti;
    }

    /**
     * Aumenta numero iscritti int.
     *
     * @param num the num
     * @return the int
     */
    public int aumenta_numero_iscritti(int num) {
        numero_iscritti += num;
        return numero_iscritti;
    }

    /**
     * Aumenta numero video int.
     *
     * @return the int
     */
    public int aumenta_numero_video() {
        numero_video++;
        return numero_video;
    }

    /**
     * Aumenta numero streaming int.
     *
     * @return the int
     */
    public int aumenta_numero_streaming() {
        numero_streaming++;
        return numero_streaming;
    }

}
