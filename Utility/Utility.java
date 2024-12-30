package Utility;
import Position.Position;
import DetectErrors.DetectErrors;
import HandleBoardActivity.HandleBoardActivity;
import MoveHistory.MoveHistory;
import Pieces.*;
import java.util.HashMap;


public class Utility {
    private String errorType;
    private Boolean checkmate;
    private MoveHistory moves;
    private HandleBoardActivity activity;

    public Utility() {
        this.errorType = "";
        this.checkmate = false;
        this.moves = new MoveHistory();
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
    public Boolean checkMove(Pieces[][] pieceMatrix, String currentTurn, String move) {// validates a move
        Position from = processFromPosition(move);
        Position to = processToPosition(move);
        DetectErrors findErrors = new DetectErrors();
        
        if (findErrors.detectBadInput(from, to)) {
            setErrorType("BI");
            return false;
        }
        else if (findErrors.detectNoPieceFound(pieceMatrix, from)) {
            setErrorType("NPAP");
            return false;
        }
        else if (findErrors.detectOutOfBounds(pieceMatrix, to)) {
            setErrorType("OOB");
            return false;
        }
        else if (findErrors.detectWrongTurn(pieceMatrix, currentTurn, from)) {
            setErrorType("WPT");
            return false;
        }
        else if (findErrors.detectMovementViolation(pieceMatrix, from, to)) {
            setErrorType("PMV");
            return false;
        }
        else if (findErrors.detectFriendlyPiece(pieceMatrix, currentTurn, to)) {
            setErrorType("FPB");
            return false;
        }
        else if (findErrors.detectStillInCheck(pieceMatrix, to)) {
            setErrorType("SIC");
            return false;
        }
        else 
        return true;
    }
    public void updateBoard(Pieces[][] pieceMatrix, String move) {// updates state of board
        Position from = processFromPosition(move);
        Position to = processToPosition(move);
        //update board
        setCheckmateStatus(activity.performActivity(pieceMatrix, move, from, to, moves));
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
        int fromColumn = (Integer.parseInt(parts[0].substring(1)) - 1);//might need to flip
        Position from = new Position(processRow(fromRow), fromColumn);
        return from;
    }
    private Position processToPosition(String move) {
        String[] parts = move.split(" ");
        char toRow = parts[0].charAt(4);
        int toColumn = (Integer.parseInt(parts[1].substring(1)) - 1);//might need to flip
        Position to = new Position(processRow(toRow), toColumn);
        return to;
    }
}
