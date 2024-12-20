package GameMode;

public abstract class GameMode {
    private String player1Name;
    private String player2Name;
    private String currentTurn;

    public GameMode (String player1, String player2) {
        this.player1Name = player1;
        this.player2Name = player2;
        this.currentTurn = "White";
    }
    public String getPlayer1Name() {
        return player1Name;
    }
    public String getPlayer2Name() {
        return player2Name;
    }
    public String getCurrentTurn() {
        return currentTurn;
    }
    public void toggleTurn() {
        currentTurn = currentTurn.equals("White") ? "Black" : "White";
    }
}

