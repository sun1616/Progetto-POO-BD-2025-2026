package model;

/**
 * The type Pubblicita.
 */
public class Pubblicita extends Video {

    private String nomeResponsor;
    private String linkEsterno;
    private int durata_skip;
    private boolean skip;

    /**
     * Instantiates a new Pubblicita.
     *
     * @param id_video       the id video
     * @param id_account     the id account
     * @param titolo         the titolo
     * @param descrizione    the descrizione
     * @param tipo           the tipo
     * @param durata_secondi the durata secondi
     * @param durata_skip    the durata skip
     * @param nomeResponsor  the nome responsor
     * @param linkEsterno    the link esterno
     */
    public Pubblicita(String id_video, String id_account, String titolo,
                      String descrizione, String tipo, int durata_secondi, int durata_skip,
                      String nomeResponsor, String linkEsterno) {

        super(id_video, id_account, titolo, descrizione, tipo, durata_secondi);

        this.nomeResponsor = nomeResponsor;
        this.linkEsterno = linkEsterno;
        this.durata_skip = durata_skip;
        skip = false;
    }

    /**
     * Gets nome responsor.
     *
     * @return the nome responsor
     */
// Getter
    public String getNomeResponsor() {
        return nomeResponsor;
    }

    /**
     * Gets link esterno.
     *
     * @return the link esterno
     */
    public String getLinkEsterno() {
        return linkEsterno;
    }

    /**
     * Gets durata skip.
     *
     * @return the durata skip
     */
    public Integer getDurata_skip() {
        return (Integer) durata_skip;
    }

    /**
     * Is skip boolean.
     *
     * @return the boolean
     */
    public boolean isSkip() {
        return skip;
    }

    /**
     * Check skip boolean.
     *
     * @param tempoPassato the tempo passato
     * @return the boolean
     */
    public Boolean checkSkip(int tempoPassato) {
        if (getDurata_secondi() - tempoPassato >= durata_skip) {
            skip = true;
            return true;
        }
        return false;
    }
}
