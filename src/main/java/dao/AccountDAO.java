package dao;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * The interface Account dao.
 */
public interface AccountDAO {
    /**
     * Add account.
     *
     * @param id_account the id account
     * @param nome       the nome
     * @param email      the email
     * @param password   the password
     * @throws SQLException the sql exception
     */
    void addAccount(String id_account, String nome, String email, String password) throws SQLException;

    /**
     * Account add iscritti.
     *
     * @param follower_id  the follower id
     * @param following_id the following id
     * @throws SQLException the sql exception
     */
    void Account_add_iscritti(String follower_id, String following_id) throws SQLException;

    /**
     * Account add video.
     *
     * @param id_account the id account
     * @throws SQLException the sql exception
     */
    void Account_add_video(String id_account) throws SQLException;

    /**
     * Account add streaming.
     *
     * @param id_account the id account
     * @throws SQLException the sql exception
     */
    void Account_add_streaming(String id_account) throws SQLException;

    /**
     * Gets all accounts dao.
     *
     * @param id_accounts the id accounts
     * @param nomes       the nomes
     * @param emails      the emails
     * @param passwords   the passwords
     * @throws SQLException the sql exception
     */
    void getALLAccountsDAO(ArrayList<String> id_accounts, ArrayList<String> nomes,
                           ArrayList<String> emails, ArrayList<String> passwords, ArrayList<Integer> numero_iscritti,
                           ArrayList<Integer> numero_videos, ArrayList<Integer> numero_streaming) throws SQLException;
}
