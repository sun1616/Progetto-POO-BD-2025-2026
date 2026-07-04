package model;

/**
 * The type Video.
 */
public class Video {

    private final String id_video;
    private final String id_account;
    private String titolo;
    private String descrizione;
    private String tipo;
    private int numeroLike;
    private int numeroVisual;
    private int durata_secondi;

    /**
     * Instantiates a new Video.
     *
     * @param id_video       the id video
     * @param id_account     the id account
     * @param titolo         the titolo
     * @param descrizione    the descrizione
     * @param tipo           the tipo
     * @param durata_secondi the durata secondi
     */
    public Video(String id_video, String id_account, String titolo,
                 String descrizione, String tipo, int durata_secondi) {

        this.id_video = id_video;
        this.id_account = id_account;
        this.titolo = titolo;
        this.descrizione = descrizione;
        this.tipo = tipo;
        this.numeroLike = 0;
        this.numeroVisual = 0;
        this.durata_secondi = durata_secondi;
    }

    /**
     * Instantiates a new Video.
     *
     * @param id_video       the id video
     * @param id_account     the id account
     * @param titolo         the titolo
     * @param descrizione    the descrizione
     * @param tipo           the tipo
     * @param numeroLike     the numero like
     * @param numeroVisual   the numero visual
     * @param durata_secondi the durata secondi
     */
    public Video(String id_video, String id_account, String titolo,
                 String descrizione, String tipo,
                 int numeroLike, int numeroVisual, int durata_secondi) {

        this.id_video = id_video;
        this.id_account = id_account;
        this.titolo = titolo;
        this.descrizione = descrizione;
        this.tipo = tipo;
        this.numeroLike = numeroLike;
        this.numeroVisual = numeroVisual;
        this.durata_secondi = durata_secondi;
    }

    /**
     * Gets id video.
     *
     * @return the id video
     */
// Getter & Setter
    public String getId_video() {
        return id_video;
    }

    /**
     * Gets id account.
     *
     * @return the id account
     */
    public String getId_account() {
        return id_account;
    }

    /**
     * Gets titolo.
     *
     * @return the titolo
     */
    public String getTitolo() {
        return titolo;
    }

    /**
     * Sets titolo.
     *
     * @param titolo the titolo
     */
    public void setTitolo(String titolo) {
        this.titolo = titolo;
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
     * Gets tipo.
     *
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Sets tipo.
     *
     * @param tipo the tipo
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
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
     * Add numero like int.
     *
     * @return the int
     */
    public int addNumeroLike() {
        this.numeroLike++;
        return this.numeroLike;
    }

    /**
     * Add numero like int.
     *
     * @param num the num
     * @return the int
     */
    public int addNumeroLike(int num) {
        this.numeroLike += num;
        return this.numeroLike;
    }

    /**
     * Gets numero visual.
     *
     * @return the numero visual
     */
    public int getNumeroVisual() {return numeroVisual;}

    /**
     * Add numero visual int.
     *
     * @return the int
     */
    public int addNumeroVisual() {
        return ++numeroVisual;
    }

    /**
     * Add numero visual int.
     *
     * @param num the num
     * @return the int
     */
    public int addNumeroVisual(int num) {
        numeroVisual += num;
        return this.numeroVisual;
    }

    /**
     * Gets durata secondi.
     *
     * @return the durata secondi
     */
    public Integer getDurata_secondi() {
        return  (Integer) durata_secondi;
    }

    /**
     * Sets durata secondi.
     *
     * @param durata_secondi the durata secondi
     */
    public void setDurata_secondi(int durata_secondi) {
        this.durata_secondi = durata_secondi;
    }

}

