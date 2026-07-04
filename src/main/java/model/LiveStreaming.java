package model;

/**
 * The type Live streaming.
 */
public class LiveStreaming {

    private String id_streaming;
    private Account account;
    private String dataInizio;
    private String dataFine;
    private String titolo;
    private String tipo;

    /**
     * Instantiates a new Live streaming.
     *
     * @param id_streaming the id streaming
     * @param account      the account
     * @param dataInizio   the data inizio
     * @param dataFine     the data fine
     * @param titolo       the titolo
     * @param tipo         the tipo
     */
    public LiveStreaming(String id_streaming, Account account,
                         String dataInizio, String dataFine,
                         String titolo, String tipo) {

        this.id_streaming = id_streaming;
        this.account = account;
        this.dataInizio = dataInizio;
        this.dataFine = dataFine;
        this.titolo = titolo;
        this.tipo = tipo;
    }

    /**
     * Gets id streaming.
     *
     * @return the id streaming
     */
// Getter & Setter
    public String getId_streaming() {
        return id_streaming;
    }

    /**
     * Sets id streaming.
     *
     * @param id_streaming the id streaming
     */
    public void setId_streaming(String id_streaming) {
        this.id_streaming = id_streaming;
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
     * Sets account.
     *
     * @param account the account
     */
    public void setAccount(Account account) {
        this.account = account;
    }

    /**
     * Gets data inizio.
     *
     * @return the data inizio
     */
    public String getDataInizio() {
        return dataInizio;
    }

    /**
     * Sets data inizio.
     *
     * @param dataInizio the data inizio
     */
    public void setDataInizio(String dataInizio) {
        this.dataInizio = dataInizio;
    }

    /**
     * Gets data fine.
     *
     * @return the data fine
     */
    public String getDataFine() {
        return dataFine;
    }

    /**
     * Sets data fine.
     *
     * @param dataFine the data fine
     */
    public void setDataFine(String dataFine) {
        this.dataFine = dataFine;
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
}
