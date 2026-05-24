package model;

public class LiveStreaming {

    private String ID_streaming;
    private Account account;
    private String dataInizio;
    private String dataFine;
    private String titolo;
    private String tipo;

    public LiveStreaming(String ID_streaming, Account account,
                         String dataInizio, String dataFine,
                         String titolo, String tipo) {

        this.ID_streaming = ID_streaming;
        this.account = account;
        this.dataInizio = dataInizio;
        this.dataFine = dataFine;
        this.titolo = titolo;
        this.tipo = tipo;
    }

    // Getter & Setter
    public String getID_streaming() {
        return ID_streaming;
    }

    public void setID_streaming(String ID_streaming) {
        this.ID_streaming = ID_streaming;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getDataInizio() {
        return dataInizio;
    }

    public void setDataInizio(String dataInizio) {
        this.dataInizio = dataInizio;
    }

    public String getDataFine() {
        return dataFine;
    }

    public void setDataFine(String dataFine) {
        this.dataFine = dataFine;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
