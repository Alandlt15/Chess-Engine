package Utility;
import Position.Position;
import DetectErrors.DetectErrors;
import HandleBoardActivity.HandleBoardActivity;
import Pieces.*;
import java.util.HashMap;

/*
 * This executes to:
 * 1. Check for any kind of errors 
 * 2. Update the board
 */
public class Utility {
    private String errorType;
    private Boolean checkmate;
    private HandleBoardActivity activity;

    public Utility() {
        this.errorType = "";
        this.checkmate = false;
        this.activity = new HandleBoardActivity();
    }
    public String getErrorType() {
        return errorType;
    }
    private void setErrorType(String error) {
        this.errorType = error;
    }
    public Boolean getCheckmateStatus() {
        return checkmate;
    }
    private void setCheckmateStatus(Boolean status) {
        this.checkmate = status;
    }

    // validates a move
    public Boolean checkMove(Pieces[][] pieceMatrix, String currentTurn, String move) {
        Position from = processFromPosition(move);
        Position to = processToPosition(move);
        DetectErrors findErrors = new DetectErrors();
        
        if (findErrors.detectBadInput(from)) {
            setErrorType("BI");// Bad Input
            return false;
        }
        else if (findErrors.detectNoPieceFound(pieceMatrix, from)) {
            setErrorType("NPAP");// No Piece At Position
            return false;
        }
        else if (findErrors.detectOutOfBounds(to)) {
            setErrorType("OOB");// Out Of Bounds
            return false;
        }
        else if (findErrors.detectWrongTurn(pieceMatrix, currentTurn, from)) {
            setErrorType("WPT");// Wrong Player Turn
            return false;
        }
        else if (findErrors.detectMovementViolation(pieceMatrix, from, to)) {
            setErrorType("PMV");// Piece Movement Violation
            return false;
        }
        else if (findErrors.detectFriendlyPiece(pieceMatrix, currentTurn, to)) {
            setErrorType("FPB");// Friendly Piece Block
            return false;
        }
        else if (findErrors.detectStillInCheck(pieceMatrix, to)) {
            setErrorType("SIC");// Still In Check
            return false;
        } 
        return true;
    }

    // updates state of board & checkmate status
    public void updateBoard(Pieces[][] pieceMatrix, String move) {
        Position from = processFromPosition(move);
        Position to = processToPosition(move);

        setCheckmateStatus(activity.performActivity(pieceMatrix, move, from, to));
    }

    private int processRow(char row) {
        HashMap<Character, Integer> hashymappy = new HashMap<>();
        hashymappy.put('A', 0);
        hashymappy.put('B', 1);
        hashymappy.put('C', 2);
        hashymappy.put('D', 3);
        hashymappy.put('E', 4);
        hashymappy.put('F', 5);
        hashymappy.put('G', 6);
        hashymappy.put('H', 7);

        Integer rowInt = hashymappy.get(row);
        if (rowInt != null)
            return rowInt;
        else 
            return -1;
    }
    private Position processFromPosition(String move) {
        String[] parts = move.split(" ");
        char fromRow = parts[0].charAt(0);
        int fromColumn = 8 - Integer.parseInt(parts[0].substring(1));
        Position from = new Position(processRow(fromRow), fromColumn);
        return from;
    }
    private Position processToPosition(String move) {
        String[] parts = move.split(" ");
        char toRow = parts[0].charAt(4);
        int toColumn = 8 - Integer.parseInt(parts[0].substring(1));
        Position to = new Position(processRow(toRow), toColumn);
        return to;
    }
}
