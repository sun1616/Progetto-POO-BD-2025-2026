package controller;

import dao.*;
import model.*;
import Exception.*;

import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * The type Controller.
 */
public class Controller {
    private AccountDAOImpl accountDAOImpl;
    private VideoDAOImpl videoDAOImpl;
    private RecensioneDAOImpl recensioneDAOImpl;

    private ArrayList<Account> accounts;
    private ArrayList<Video> videos;
    private ArrayList<Recensione>  recensioni;

    private ArrayList<Recensione>  currentRecensioni;
    private Account currentAccount;
    private Video currentVideo;
    private Account accountSelected;
    private Pubblicita pubblicitaExample;

    private Boolean vip;

    public Controller() {
        accountDAOImpl = new AccountDAOImpl();
        videoDAOImpl = new VideoDAOImpl();
        recensioneDAOImpl = new RecensioneDAOImpl();
        accounts = new ArrayList<>();
        videos = new ArrayList<>();
        recensioni = new ArrayList<>();
        currentRecensioni = new ArrayList<>();
        currentAccount = null;
        currentVideo = null;
        accountSelected = null;
        pubblicitaExample = null;
        vip = false;
    }

    // Funzioni Account

    /**
     * Gets all accounts da DB e salva in locale ArrayList accounts.
     *
     * @throws SQLException the sql exception
     */
    public void getALLAccounts() throws SQLException{
        accounts.clear();

        ArrayList<String> id_account = new ArrayList<>();
        ArrayList<String> nome = new ArrayList<>();
        ArrayList<String> email = new ArrayList<>();
        ArrayList<String> password = new ArrayList<>();
        ArrayList<Integer> numero_iscritti = new ArrayList<>();
        ArrayList<Integer> numero_videos = new ArrayList<>();
        ArrayList<Integer> numero_streaming = new ArrayList<>();

        accountDAOImpl.getALLAccountsDAO(id_account, nome, email, password, numero_iscritti, numero_videos, numero_streaming);

        for (int i = 0; i < id_account.size(); i++) {
            Account a = new Account(id_account.get(i), nome.get(i), email.get(i), password.get(i), numero_iscritti.get(i), numero_videos.get(i), numero_streaming.get(i));
            accounts.add(a);
        }
    }


    /**
     * Gets account con id_account
     * Fa un Querry in accounts
     *
     * @param aid id_account
     * @throws AccountNotFoundedException the AccountNotFounded Exception
     */
    private Account getAccount(String aid) throws AccountNotFoundedException {
        Boolean bool = false;
        Account account = null;
        for (Account a : accounts) {
            if (a.getId_account().equals(aid)) {
                bool = true;
                account = a;
                break;
            }
        }
        if (!bool) {
            throw new AccountNotFoundedException("Account not founded! Controlla AID: " + aid);
        }

        return account;
    }

    /**
     * Gets account nome.
     *
     * @param aid the aid
     * @return the account nome
     * @throws AccountNotFoundedException the account not founded exception
     */
    public String getAccountNome(String aid) throws AccountNotFoundedException {
        return getAccount(aid).getNome();
    }

    /**
     * Gets account numero iscritti.
     *
     * @param aid the aid
     * @return the account numero iscritti
     * @throws AccountNotFoundedException the account not founded exception
     */
    public Integer getAccountNumero_iscritti(String aid) throws AccountNotFoundedException {
        return getAccount(aid).getNumero_iscritti();
    }

    /**
     * Gets account numero video.
     *
     * @param aid the aid
     * @return the account numero video
     * @throws AccountNotFoundedException the account not founded exception
     */
    public Integer getAccountNumero_video(String aid) throws AccountNotFoundedException {
        return getAccount(aid).getNumero_video();
    }

    /**
     * Gets account numero streaming.
     *
     * @param aid the aid
     * @return the account numero streaming
     * @throws AccountNotFoundedException the account not founded exception
     */
    public Integer getAccountNumero_streaming(String aid) throws AccountNotFoundedException {
        return getAccount(aid).getNumero_streaming();
    }

    /**
     * Check iscrizione same account boolean.
     * Restuisce true se sono stessi account
     * @return the boolean
     */
    public Boolean checkIscrizioneSameAccount() {
        return currentAccount.getId_account().equals(accountSelected.getId_account());
    }

    /**
     * Add iscritti.
     *
     * @param aid the aid
     * @throws AccountNotFoundedException the account not founded exception
     * @throws SQLException               the sql exception
     */
    public void addIscritti(String aid) throws AccountNotFoundedException, SQLException {
        accountDAOImpl.Account_add_iscritti(currentAccount.getId_account(), aid);
        getAccount(aid).aumenta_numero_iscritti();
    }

    /**
     * Gets next id accounts in formato ACC001 -> ACC999.
     *
     * @return the next id accounts
     */
    public String getNext_id_account() {
        int count = accounts.size() + 1;
        return "ACC" + String.format("%03d", count);
    }

    /**
     * Registra un account sia in db sia in locale.
     *
     * @param nome     the nome
     * @param email    the email
     * @param password the password
     * @throws SQLException the sql exception
     */
    public void registra(String nome, String email, String password) throws  SQLException {
        accountDAOImpl.addAccount(this.getNext_id_account(), nome, email, password);
        accounts.add(new Account(this.getNext_id_account(), nome, email, password));
    }

    /**
     * Si controlla tutte le email salvate in accounts
     * se la trova uguale, allora controlla password
     *
     * @param email    email inserita dall'utende
     * @param password password inserita dall'utende
     * @return restuisce true solo se trova un account che contiene stesse email e password
     * @throws AccountNotFoundedException the account not founded exception
     */
    public void login(String email, String password) throws AccountNotFoundedException {
        boolean flag = false;

        for (Account a : accounts) {
            if (a.getEmail().equals(email)) {
                if (a.getPassword().equals(password)) {
                    flag = true;
                    currentAccount = a;
                    break;
                }
            }
        }

        if (!flag) {
            throw new AccountNotFoundedException("Login fallita, controlla email/password");
        }
    }

    /**
     * Gets account selected id.
     *
     * @return the account selected id
     */
    public String getAccountSelectedId() {
        return accountSelected.getId_account();
    }

    /**
     * Sets account selected.
     *
     * @param accountSelectedId the account selected id
     */
    public void setAccountSelected(String accountSelectedId) {
        for (Account a : accounts) {
            if (a.getId_account().equals(accountSelectedId)) {
                this.accountSelected = a;
            }
        }
    }

    // Funzioni Video

    /**
     * Gets next id video.
     *
     * @return the next id_video in formato VID001 -> VID999
     */
    public String getNext_id_video() {
        int count = videos.size() + 1;
        return "VID" + String.format("%03d", count);
    }

    /**
     * Gets all videos da db e salva in locale ArraryList videos.
     *
     * @throws SQLException the sql exception
     */
    public void getALLVideos() throws SQLException{
        videos.clear();

        ArrayList<String> id_videos = new ArrayList<>();
        ArrayList<String> id_accounts = new ArrayList<>();
        ArrayList<String> titoli = new ArrayList<>();
        ArrayList<String> descrizioni = new ArrayList<>();
        ArrayList<String> tipi = new ArrayList<>();
        ArrayList<Integer> numeri_like = new ArrayList<>();
        ArrayList<Integer> numeri_visual = new ArrayList<>();
        ArrayList<Integer> durataSecondi = new ArrayList<>();

        videoDAOImpl.getALLVideosDAO(id_videos, id_accounts, titoli, descrizioni, tipi, numeri_like, numeri_visual, durataSecondi);

        for (int i = 0; i < id_videos.size(); i++) {
            Video v = new Video(id_videos.get(i), id_accounts.get(i), titoli.get(i), descrizioni.get(i), tipi.get(i), numeri_like.get(i), numeri_visual.get(i), durataSecondi.get(i));
            videos.add(v);
        }
    }

    /**
     * Aggiungi video.
     *
     * @param titolo         the titolo
     * @param descrizione    the descrizione
     * @param tipo           the tipo
     * @param durata_secondi the durata secondi
     * @throws SQLException the sql exception
     */
    public void aggiungiVideo(String titolo, String descrizione, String tipo, int durata_secondi) throws SQLException {
        videoDAOImpl.addVideo(this.getNext_id_video(), currentAccount.getId_account(), titolo, descrizione, tipo, durata_secondi);
        accountDAOImpl.Account_add_video(currentAccount.getId_account());
        videos.add(new Video(this.getNext_id_video(), currentAccount.getId_account(), titolo, descrizione, tipo, durata_secondi));
        currentAccount.aumenta_numero_video();
    }

    /**
     * Prepare video table data con default table model.
     * Si prende i dati da ArraryList videos
     * @return the default table model
     */
    public DefaultTableModel prepareVideoTableData() {
        String cols[] = {"ID Video", "ID Account", "Titolo", "tipo", "numero like", "numero visual", "durata"};
        DefaultTableModel tableModel = new DefaultTableModel(cols, 0) {
            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }
        };

        for (Video v : videos) {
            Object[] row = new Object[7];
            row[0] = v.getId_video();
            row[1] = v.getId_account();
            row[2] = v.getTitolo();
            row[3] = v.getTipo();
            row[4] = v.getNumeroLike();
            row[5] = v.getNumeroVisual();
            row[6] = v.getDurata_secondi();
            tableModel.addRow(row);
        }

        return tableModel;
    }

    /**
     * Gets video descrizione.
     *
     * @param vid the vid
     * @return the video descrizione
     */
    public String getVideoDescrizione(String vid) {
        for (Video v : videos) {
            if (v.getId_video().equals(vid)) {
                return v.getDescrizione();
            }
        }
        return null;
    }

    /**
     * Sets current video.
     *
     * @param vid the vid
     */
    public void setCurrentVideo(String vid) {
        for (Video v : videos) {
            if (v.getId_video().equals(vid)) {
                currentVideo = v;
            }
        }
    }

    /**
     * Gets current video titolo.
     *
     * @return the current video titolo
     */
    public String getCurrentVideoTitolo() {
        return currentVideo.getTitolo();
    }

    /**
     * Gets current video descerzione.
     *
     * @return the current video descerzione
     */
    public String getCurrentVideoDescerzione() {
        return currentVideo.getDescrizione();
    }

    /**
     * Gets current video numero visual.
     *
     * @return the current video numero visual
     */
    public Integer getCurrentVideoNumeroVisual() {
        return currentVideo.getNumeroVisual();
    }

    /**
     * Gets current video numero like.
     *
     * @return the current video numero like
     */
    public Integer getCurrentVideoNumeroLike() {
        return currentVideo.getNumeroLike();
    }

    /**
     * Add like to current video.
     */
    public void addLikeToCurrentVideo() {
        try {
            videoDAOImpl.addLike(currentVideo.getId_video());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        currentVideo.addNumeroLike();
    }

    /**
     * Add visual to current video.
     */
    public void addVisualToCurrentVideo() {
        try {
            videoDAOImpl.addVisual(currentVideo.getId_video());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        currentVideo.addNumeroVisual();
    }

    /**
     * Gets current video id.
     *
     * @return the current video id
     */
    public String getCurrentVideoId() {
        if (currentVideo == null) {
            return "";
        }
        return currentVideo.getId_video();
    }

    // Funzioni Recensione

    /**
     * Gets all recensione da db e salva in locale ArrayList recensioni.
     *
     * @throws SQLException               the sql exception
     * @throws AccountNotFoundedException the account not founded exception
     */
    public void getAllRecensione() throws SQLException, AccountNotFoundedException {
        recensioni.clear();

        ArrayList<String> id_recensioni = new ArrayList<>();
        ArrayList<String> id_videos = new ArrayList<>();
        ArrayList<String> id_accounts = new ArrayList<>();
        ArrayList<String> descrizioni = new ArrayList<>();
        ArrayList<Integer> numeri_like = new ArrayList<>();

        recensioneDAOImpl.getAllRecensione(id_recensioni, id_videos, id_accounts, descrizioni, numeri_like);

        for (int i = 0; i < id_recensioni.size(); i++) {
            Account a = getAccount(id_accounts.get(i));
            Recensione r = new Recensione(id_recensioni.get(i), id_videos.get(i), a, descrizioni.get(i), numeri_like.get(i));
            recensioni.add(r);
        }
    }

    /**
     * Prepara recensioni del video selezionato.
     *
     * @return the string
     */
    public String preparaRecensioni() {
        StringBuilder rencensioni = new StringBuilder();
        for (Recensione r : currentRecensioni) {
            rencensioni.append(r.toString());
        }
        rencensioni.append("*************************************************************\n");
        return rencensioni.toString();
    }

    /**
     * Gets all id recensioni.
     *
     * @return the all id recensioni
     */
    public ArrayList<String> getAllIDRecensioni() {
        ArrayList<String> id_recensioni = new ArrayList<>();
        for (Recensione r : currentRecensioni) {
            id_recensioni.add(r.getId_recensione());
        }
        return id_recensioni;
    }

    /**
     * Add like to recensione.
     *
     * @param rid the rid
     */
    public void addLikeToRecensione(String rid) {
        for (Recensione r : recensioni) {
            if (r.getId_recensione().equals(rid)) {
                try {
                    recensioneDAOImpl.aumenta_like(rid);
                    r.aumentaNumeroLike();
                } catch (SQLException e) {
                    throw new RuntimeException("Impossibile aumentare numero like, rid: " + rid);
                }
            }
        }
    }

    /**
     * Gets id_account from id_recensione.
     *
     * @param rid the id_recensione
     * @return the aid from rid
     * @throws RecensioneNotFoundedException the recensione not founded exception
     */
    public String getAidFromRid(String rid) throws RecensioneNotFoundedException{
        Boolean bool = false;
        String aid = null;
        for (Recensione r : recensioni) {
            if (r.getId_recensione().equals(rid)) {
                aid = r.getAccount().getId_account();
                bool = true;
                break;
            }
        }

        if (!bool) {
            throw new RecensioneNotFoundedException("ID Account Not Founded from rid: " + rid);
        }
        return aid;
    }

    private String getNext_id_recensione() {
        int count = recensioni.size() + 1;
        return "REC" + String.format("%03d", count);
    }


    /**
     * Aggiungi recensione.
     *
     * @param descrizione the descrizione
     * @throws AccountNotFoundedException the account not founded exception
     * @throws SQLException               the sql exception
     */
    public void aggiungiRecensione(String descrizione) throws AccountNotFoundedException, SQLException {
        recensioneDAOImpl.aggiungiRecensione(getNext_id_recensione(),  getCurrentVideoId(), currentAccount.getId_account(), descrizione);
        recensioni.add(new Recensione(getNext_id_recensione(),  getCurrentVideoId(), currentAccount, descrizione));
    }

    /**
     * Sets current recensioni.
     */
    public void setCurrentRecensioni() {
        currentRecensioni.clear();

        for (Recensione r : recensioni) {
            if (r.getId_video().equals(currentVideo.getId_video())) {
                currentRecensioni.add(r);
            }
        }
    }

    /**
     * Check vip boolean.
     *
     * @return the boolean
     */
// Funzione pubblicità
    public boolean checkVip() {
        return vip;
    }

    /**
     * Sets vip.
     *
     * @param vip the vip
     */
    public void setVip(boolean vip) {
        this.vip = vip;
    }

    /**
     * Sets pubblicita example.
     */
    public void setPubblicitaExample() {
        pubblicitaExample = new Pubblicita("PUB001", "DAB001",
                "La convenienza per te!", "IKEA, decora la tua casa come paradiso!",
                "Pubblicità", 30, 10, "IKEA", "www.ikea.it");
    }

    /**
     * Check skip boolean.
     *
     * @param tempoPassato the tempo passato
     * @return the boolean
     */
    public Boolean checkSkip(int tempoPassato) {
        return pubblicitaExample.checkSkip(tempoPassato);
    }

    /**
     * Gets pubblicita example titolo.
     *
     * @return the pubblicita example titolo
     */
    public String getPubblicitaExampleTitolo() {
        return pubblicitaExample.getTitolo();
    }

    /**
     * Gets pubblicita example durata secondi.
     *
     * @return the pubblicita example durata secondi
     */
    public Integer getPubblicitaExampleDurataSecondi() {
        return pubblicitaExample.getDurata_secondi();
    }

    /**
     * Gets pubblicita example nome responsor.
     *
     * @return the pubblicita example nome responsor
     */
    public String getPubblicitaExampleNomeResponsor() {
        return pubblicitaExample.getNomeResponsor();
    }

    /**
     * Gets pubblicita example t link esterno.
     *
     * @return the pubblicita example t link esterno
     */
    public String getPubblicitaExampleTLinkEsterno() {
        return pubblicitaExample.getLinkEsterno();
    }

    /**
     * Gets pubblicita example durata skip.
     *
     * @return the pubblicita example durata skip
     */
    public Integer getPubblicitaExampleDurataSkip() {
        return pubblicitaExample.getDurata_skip();
    }
}
