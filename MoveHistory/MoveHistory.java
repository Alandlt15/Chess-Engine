package MoveHistory;
import java.util.ArrayList;

public class MoveHistory {
    ArrayList<String> moveHistory;
    ArrayList<String> whiteCapturedPieces;
    ArrayList<String> blackCapturedPieces;

    public MoveHistory() {
        this.moveHistory = new ArrayList<>();
        this.whiteCapturedPieces = new ArrayList<>();
        this.blackCapturedPieces = new ArrayList<>();
    }
    public void addMovesToHistory(String move) {
        moveHistory.add(move);
    }
    public void addToWhiteCaptured(String piece) {
        whiteCapturedPieces.add(piece);
    }
    public void addToBlackCaptured(String piece) {
        blackCapturedPieces.add(piece);
    }
}
