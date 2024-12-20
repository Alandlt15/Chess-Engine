package HandleBoardActivity;
import MoveHistory.MoveHistory;
import Position.Position;
import Pieces.*;

public class HandleBoardActivity {
    //class keeps track of moves for each player might move to board class
    private MoveHistory history;

    public HandleBoardActivity() {
        this.history = new MoveHistory();
    }
    // all should check for king's check
    private void move() {

    }
    private void moveAndCapture() {

    }
    private void pawnPromotion() {

    }
    private void castle() {

    }
    // should return true if checkmate found
    public boolean performActivity(Pieces[][] pieceMatrix, String move, Position from, Position to) {

    }
}
