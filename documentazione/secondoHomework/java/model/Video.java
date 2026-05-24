package model;

public class Video {

    private final String ID_video;
    private final Account account;
    private String titolo;
    private String descrizione;
    private String tipo;
    private int numeroLike;
    private int numeroVisual;
    private int ore;
    private int minuti;
    private int secondi;

    public Video(String ID_video, Account account, String titolo,
                 String descrizione, String tipo,
                 int ore, int minuti, int secondi) {

        this.ID_video = ID_video;
        this.account = account;
        this.titolo = titolo;
        this.descrizione = descrizione;
        this.tipo = tipo;
        this.numeroLike = 0;
        this.numeroVisual = 0;
        this.ore = ore;
        this.minuti = minuti;
        this.secondi = secondi;
    }

    // Getter & Setter
    public String getID_video() {
        return ID_video;
    }

    public Account getAccount() {
        return account;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getNumeroLike() {
        return numeroLike;
    }

    public int increseNumeroLike() {
        this.numeroLike++;
        return this.numeroLike;
    }

    public int increseNumeroLike(int num) {
        this.numeroLike += num;
        return this.numeroLike;
    }

    public int increseNumeroVisual() {
        return ++numeroVisual;
    }

    public int increseNumeroVisual(int num) {
        numeroVisual += num;
        return this.numeroVisual;
    }

    public int getOre() {
        return ore;
    }

    public void setOre(int ore) {
        this.ore = ore;
    }

    public int getMinuti() {
        return minuti;
    }

    public void setMinuti(int minuti) {
        this.minuti = minuti;
    }

    public int getSecondi() {
        return secondi;
    }

    public void setSecondi(int secondi) {
        this.secondi = secondi;
    }

}

