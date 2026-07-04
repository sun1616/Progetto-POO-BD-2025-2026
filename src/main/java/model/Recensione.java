package model;

/**
 * The type Recensione.
 */
public class Recensione {

    private String id_recensione;
    private String id_video;
    private Account account;
    private String descrizione;
    private Integer numeroLike;

    /**
     * Instantiates a new Recensione.
     *
     * @param id_recensione the id recensione
     * @param id_video      the id video
     * @param account       the account
     * @param descrizione   the descrizione
     */
    public Recensione(String id_recensione, String id_video,
                      Account account, String descrizione) {

        this.id_recensione = id_recensione;
        this.id_video = id_video;
        this.account = account;
        this.descrizione = descrizione;
        this.numeroLike = 0;
    }

    /**
     * Instantiates a new Recensione.
     *
     * @param id_recensione the id recensione
     * @param id_video      the id video
     * @param account       the account
     * @param descrizione   the descrizione
     * @param numeroLike    the numero like
     */
    public Recensione(String id_recensione, String id_video,
                      Account account, String descrizione, int numeroLike) {

        this.id_recensione = id_recensione;
        this.id_video = id_video;
        this.account = account;
        this.descrizione = descrizione;
        this.numeroLike = numeroLike;
    }

    /**
     * Gets id recensione.
     *
     * @return the id recensione
     */
    public String getId_recensione() {
        return id_recensione;
    }

    /**
     * Sets id recensione.
     *
     * @param id_recensione the id recensione
     */
    public void setId_recensione(String id_recensione) {
        this.id_recensione = id_recensione;
    }

    /**
     * Gets id video.
     *
     * @return the id video
     */
    public String getId_video() {
        return id_video;
    }

    /**
     * Sets id video.
     *
     * @param id_video the id video
     */
    public void setId_video(String id_video) {
        this.id_video = id_video;
    }

    /**
     * Gets account.
     *
     * @return the account
     */
    public Account getAccount() {
        return account;
    }

    /**
     * Gets descrizione.
     *
     * @return the descrizione
     */
    public String getDescrizione() {
        return descrizione;
    }

    /**
     * Sets descrizione.
     *
     * @param descrizione the descrizione
     */
    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    /**
     * Gets numero like.
     *
     * @return the numero like
     */
    public int getNumeroLike() {
        return numeroLike;
    }

    /**
     * Aumenta numero like.
     */
    public void aumentaNumeroLike() {
        numeroLike++;
    }

    /**
     * Si restuisce una recensione in formato
     */
    @Override
    public String toString() {
        return  "*************************************************************\n"
                + account.getNome() + "\n"
                + descrizione + "\n"
                + "Numero like: " + numeroLike + "\n"
                + "ID Recensione: " + id_recensione + "\n";
    }
}

