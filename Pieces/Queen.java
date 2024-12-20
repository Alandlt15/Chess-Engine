package Pieces;
import Position.Position;
import java.util.ArrayList;

public class Queen extends Pieces {
    public Queen (String color, Position position) {
        super(color, position);
    }
    @Override
    public void displayPiece() {
        if (getColor().equals("White"))
            System.out.print("wQ ");
        else
            System.out.print("bQ ");
    }
    @Override
    public void possibleMoves(Pieces[][] pieceMatrix, ArrayList<Position> moves) {
        // when queen is in the edge

        // when queen is anywhere but edge
    }
}
