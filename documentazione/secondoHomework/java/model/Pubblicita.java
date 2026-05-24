package model;

public class Pubblicita extends Video {

    private String nomeResponsor;
    private String linkEsterno;
    private boolean skip;

    public Pubblicita(String idVideo, Account account,
                      String titolo, String descrizione,
                      String tipo, int ore, int minuti,
                      int secondi,
                      String nomeResponsor,
                      String linkEsterno,
                      boolean skip) {

        super(idVideo, account, titolo, descrizione,
                tipo, ore, minuti, secondi);

        this.nomeResponsor = nomeResponsor;
        this.linkEsterno = linkEsterno;
        this.skip = skip;
    }

    // Getter & Setter
    public String getNomeResponsor() {
        return nomeResponsor;
    }

    public void setNomeResponsor(String nomeResponsor) {
        this.nomeResponsor = nomeResponsor;
    }

    public String getLinkEsterno() {
        return linkEsterno;
    }

    public void setLinkEsterno(String linkEsterno) {
        this.linkEsterno = linkEsterno;
    }

    public boolean isSkip() {
        return skip;
    }

    public void setSkip(boolean skip) {
        this.skip = skip;
    }
}
