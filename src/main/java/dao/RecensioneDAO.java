package dao;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * The interface Recensione dao.
 */
public interface RecensioneDAO {
    /**
     * Aggiungi recensione.
     *
     * @param id_recensione the id recensione
     * @param id_video      the id video
     * @param id_account    the id account
     * @param descrizione   the descrizione
     * @throws SQLException the sql exception
     */
    public void aggiungiRecensione(String id_recensione, String id_video, String id_account, String descrizione) throws SQLException;

    /**
     * Aumenta like.
     *
     * @param id_recensione the id recensione
     * @throws SQLException the sql exception
     */
    public void aumenta_like(String id_recensione) throws SQLException;

    /**
     * Gets all recensione.
     *
     * @param id_recensioni the id recensioni
     * @param id_videos     the id videos
     * @param id_accounts   the id accounts
     * @param descrizioni   the descrizioni
     * @param numeri_Like   the numeri like
     * @throws SQLException the sql exception
     */
    public void getAllRecensione(ArrayList<String> id_recensioni, ArrayList<String> id_videos, ArrayList<String> id_accounts,
                                 ArrayList<String> descrizioni, ArrayList<Integer> numeri_Like) throws SQLException;
}
