package Pieces;
import Position.Position;
import java.util.ArrayList;

public class Knight extends Pieces {
    public Knight (String color, Position position) {
        super(color, position);
    }
    @Override
    public void displayPiece() {
        if (getColor().equals("White"))
            System.out.print("wN ");
        else
            System.out.print("bN ");
    }
    @Override
    public String getType() {
        return "Knight";
    }
    @Override
    public void possibleMoves(Pieces[][] pieceMatrix, ArrayList<Position> moves) {
        // 
    }
}
