package HandleBoardActivity;
import MoveHistory.MoveHistory;
import Position.Position;
import Pieces.*;

/*
 * This executes if no erros have been detected.
 * Meaning, an event will take place on the board,
 * that can either result in check, or checkmate.
 * 
 * To do:
 * Add Stalemate Logic
 * Add En Passant Logic
 */
public class HandleBoardActivity {
    //class keeps track of moves for each player might move to board class
    MoveHistory moves;

    public HandleBoardActivity() {
        this.moves = new MoveHistory();
    }
    
    //move piece if to is empty
    private boolean move() {
        return checkCheckmate();
    }

    //move piece and capture piece
    private boolean moveAndCapture() {
        return checkCheckmate();
    }

    //move pawn and upgrade 
    private boolean pawnPromotion() {
        return checkCheckmate();
    }

    //swap king and rook
    private boolean castle() {
        return checkCheckmate();
    }

    //checks if king is trapped
    private boolean checkCheckmate() {
        return false;
    }
    // should return true if checkmate found
    public boolean performActivity(Pieces[][] pieceMatrix, String move, Position from, Position to) {
        pieceMatrix[to.getRow()][to.getColumn()] = pieceMatrix[from.getRow()][from.getColumn()];
        pieceMatrix[from.getRow()][from.getColumn()] = null;
        return false;
    }
}
