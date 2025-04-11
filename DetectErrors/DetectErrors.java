package DetectErrors;
import Position.Position;
import java.util.ArrayList;
import Pieces.*;

/*
 * This executes in order to detect errors or
 * check. Returns true if any is detected.
 */
public class DetectErrors {
    public DetectErrors() {

    }

    // checks bad input in 'from'
    public Boolean detectBadInput(Position from) {
        if (from.getRow() == -1 || from.getColumn() < 0 || from.getColumn() > 7)
            return true;
        return false;
    }

    // no piece found
    public Boolean detectNoPieceFound(Pieces[][] pieceMatrix, Position from) {
        if (pieceMatrix[from.getRow()][from.getColumn()] == null)
            return true;
        return false;
    }

    // checks out of bounds in 'to'
    public Boolean detectOutOfBounds(Position to) { 
        if (to.getRow() < 0 || to.getRow() > 7 || to.getColumn() < 0 || to.getColumn() > 7)
            return true;
        return false;
    }

    // wrong player turn
    public Boolean detectWrongTurn(Pieces[][] pieceMatrix, String currentTurn, Position from) {
        if (!pieceMatrix[from.getRow()][from.getColumn()].getColor().equals(currentTurn))
            return true;
        return false;
    }

    // piece movement violation
    public Boolean detectMovementViolation(Pieces[][] pieceMatrix, Position from, Position to) {
        ArrayList<Position> moves = new ArrayList<>();
        pieceMatrix[from.getRow()][from.getColumn()].possibleMoves(pieceMatrix, moves);
        if (moves.size() == 0)
            return true;
        else {
            for (int i = 0; i < moves.size(); i++) {
                if (moves.get(i).getRow() == to.getRow() && moves.get(i).getColumn() == to.getColumn())
                    return false;
            }
        }
        return true;   
    }

    // friendly piece block
    public Boolean detectFriendlyPiece(Pieces[][] pieceMatrix, String currentTurn, Position to) {
        if (pieceMatrix[to.getRow()][to.getColumn()].getColor().equals(currentTurn))
            return true;
        return false;
    }

    // still in check
    // find a way to pre make the move since here it hasn't made the move yet, resulting in infinite check 
    public Boolean detectStillInCheck(Pieces[][] pieceMatrix, String currentTurn, Position from, Position to) {
        Pieces[][] tempMatrix = new Pieces[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                pieceMatrix[i][j] = pieceMatrix[i][j];
            }
        }

        tempMatrix[to.getRow()][to.getColumn()] = tempMatrix[from.getRow()][from.getColumn()];
        tempMatrix[from.getRow()][from.getColumn()] = null;

        Position kingPosition = null;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (tempMatrix[i][j] != null && tempMatrix[i][j].getColor().equals(currentTurn) && tempMatrix[i][j].getType().equals("King")) {
                    kingPosition = new Position(i, j);
                    break;
                }
            }
        }

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (tempMatrix[i][j] != null && !tempMatrix[i][j].getColor().equals(currentTurn)) {
                    ArrayList<Position> opponentMoves = new ArrayList<>();
                    tempMatrix[i][j].possibleMoves(tempMatrix, opponentMoves);
                    for (Position move : opponentMoves) {
                        if (move.equals(kingPosition)) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
}
