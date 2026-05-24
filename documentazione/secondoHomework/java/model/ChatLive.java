package model;

public class ChatLive {

    private final String ID_chat;
    private LiveStreaming streaming;
    private Account account;
    private String commento[];

    public ChatLive(String ID_chat, LiveStreaming streaming,
                    Account account, String commento[]) {

        this.ID_chat = ID_chat;
        this.streaming = streaming;
        this.account = account;
        this.commento = commento;
    }

    // Getter & Setter
    public String getID_chat() {
        return ID_chat;
    }

    public LiveStreaming getStreaming() {
        return streaming;
    }

    public void setStreaming(LiveStreaming streaming) {
        this.streaming = streaming;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String[] getCommento() {
        return commento;
    }
}

