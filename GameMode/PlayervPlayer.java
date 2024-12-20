package GameMode;
import Player.Player;

public class PlayervPlayer extends GameMode {
    private Player player1Color;
    private Player player2Color;

    public PlayervPlayer (String player1, String player2) {
        super(player1, player2);
        this.player1Color = new Player("White");
        this.player2Color = new Player("Black");
    }
    public String getPlayer1Color() {
        return player1Color.getColor();
    }
    public String getPlayer2Color() {
        return player2Color.getColor();
    }
}
