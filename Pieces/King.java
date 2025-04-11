package Pieces;
import Position.Position;
import java.util.ArrayList;

public class King extends Pieces {
    private Boolean check;
    public King (String color, Position position) {
        super(color, position);
        this.check = false;
    }
    private void setCheckTrue() {
        this.check = true;
    }
    public Boolean getCheckStatus() {
        return check;
    }
    @Override
    public void displayPiece() {
        if (getColor().equals("White"))
            System.out.print("wK ");
        else
            System.out.print("bK ");
    }
    @Override
    public String getType() {
        return "King";
    }
    @Override
    public void possibleMoves(Pieces[][] pieceMatrix, ArrayList<Position> moves) {
        // when king is in edge

        // when king is anywhere but edge
    }
}
