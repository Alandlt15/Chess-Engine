package Pieces;
import Position.Position;
import java.util.ArrayList;

public class Rook extends Pieces {
    public Rook (String color, Position position) {
        super(color, position);
    }
    @Override
    public void displayPiece() {
        if (getColor().equals("White"))
            System.out.print("wR ");
        else
            System.out.print("bR ");
    }
    @Override
    public void possibleMoves(Pieces[][] pieceMatrix, ArrayList<Position> moves) {
        // when rook is in the edge

        // when rook is anywhere but edge
    }
}