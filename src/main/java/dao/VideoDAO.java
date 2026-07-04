package dao;

import model.Account;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * The interface Video dao.
 */
public interface VideoDAO {
    /**
     * Add video.
     *
     * @param id_video       the id video
     * @param id_account     the id account
     * @param titolo         the titolo
     * @param descrizione    the descrizione
     * @param tipo           the tipo
     * @param durata_secondi the durata secondi
     * @throws SQLException the sql exception
     */
    void addVideo(String id_video, String id_account, String titolo,
                  String descrizione, String tipo, int durata_secondi) throws SQLException;

    /**
     * Add like.
     *
     * @param id_video the id video
     * @throws SQLException the sql exception
     */
    void addLike(String id_video) throws SQLException;

    /**
     * Add like.
     *
     * @param id_video the id video
     * @param value    the value
     * @throws SQLException the sql exception
     */
    void addLike(String id_video, int value) throws SQLException;

    /**
     * Add visual.
     *
     * @param id_video the id video
     * @throws SQLException the sql exception
     */
    void addVisual(String id_video) throws SQLException;

    /**
     * Add visual.
     *
     * @param id_video the id video
     * @param value    the value
     * @throws SQLException the sql exception
     */
    void addVisual(String id_video, int value) throws SQLException;

    /**
     * Gets all videos dao.
     *
     * @param id_videos     the id videos
     * @param id_accounts   the id accounts
     * @param titoli        the titoli
     * @param descrizioni   the descrizioni
     * @param tipi          the tipi
     * @param numeri_visual the numeri visual
     * @param numeri_like   the numeri like
     * @param durataSecondi the durata secondi
     * @throws SQLException the sql exception
     */
    void getALLVideosDAO(ArrayList<String> id_videos, ArrayList<String> id_accounts, ArrayList<String> titoli,
                         ArrayList<String> descrizioni, ArrayList<String> tipi, ArrayList<Integer> numeri_visual,
                         ArrayList<Integer> numeri_like, ArrayList<Integer> durataSecondi) throws SQLException;

}
