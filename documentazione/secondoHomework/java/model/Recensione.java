package model;

public class Recensione {

    private String ID_recensione;
    private Video video;
    private Account account;
    private String descrizione;
    private int numeroLike;

    public Recensione(String ID_recensione, Video video,
                      Account account, String descrizione) {

        this.ID_recensione = ID_recensione;
        this.video = video;
        this.account = account;
        this.descrizione = descrizione;
        this.numeroLike = 0;
    }

    public String getID_recensione() {
        return ID_recensione;
    }

    public void setID_recensione(String ID_recensione) {
        this.ID_recensione = ID_recensione;
    }

    public Video getVideo() {
        return video;
    }

    public void setVideo(Video video) {
        this.video = video;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public int getNumeroLike() {
        return numeroLike;
    }

    public void setNumeroLike(int numeroLike) {
        this.numeroLike = numeroLike;
    }
}

