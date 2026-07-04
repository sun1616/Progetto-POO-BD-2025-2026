package model;

/**
 * The type Chat live.
 */
public class ChatLive {

    private final String id_chat;
    private LiveStreaming streaming;
    private Account account;
    private String commento[];

    /**
     * Instantiates a new Chat live.
     *
     * @param id_chat   the id chat
     * @param streaming the streaming
     * @param account   the account
     * @param commento  the commento
     */
    public ChatLive(String id_chat, LiveStreaming streaming,
                    Account account, String commento[]) {

        this.id_chat = id_chat;
        this.streaming = streaming;
        this.account = account;
        this.commento = commento;
    }

    /**
     * Gets id chat.
     *
     * @return the id chat
     */
// Getter & Setter
    public String getId_chat() {
        return id_chat;
    }

    /**
     * Gets streaming.
     *
     * @return the streaming
     */
    public LiveStreaming getStreaming() {
        return streaming;
    }

    /**
     * Sets streaming.
     *
     * @param streaming the streaming
     */
    public void setStreaming(LiveStreaming streaming) {
        this.streaming = streaming;
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
     * Get commento string [ ].
     *
     * @return the string [ ]
     */
    public String[] getCommento() {
        return commento;
    }
}

