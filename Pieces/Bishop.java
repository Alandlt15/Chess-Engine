package Pieces;
import Position.Position;
import java.util.ArrayList;

public class Bishop extends Pieces {
    public Bishop (String color, Position position) {
        super(color, position);
    }
    @Override
    public void displayPiece() {
        if (getColor().equals("White"))
            System.out.print("wB ");
        else
            System.out.print("bB ");
    }
    @Override
    public String getType() {
        return "Bishop";
    }
    @Override
    public void possibleMoves(Pieces[][] pieceMatrix, ArrayList<Position> moves) {
        // when bishop is in edge

        // when bishop is anywhere but edge
    }
}
