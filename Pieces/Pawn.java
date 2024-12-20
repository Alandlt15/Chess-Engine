package Pieces;
import Position.Position;
import java.util.ArrayList;

public class Pawn extends Pieces {
    private Boolean initialMoveMade;
    private Boolean pawnPromotion;
    public Pawn (String color, Position position) {
        super(color, position);
        this.initialMoveMade = false;
        this.pawnPromotion = false;
    }
    private Boolean getInitialMoveMade() {
        return initialMoveMade;
    }
    private void setInitialMoveMadeTrue() {
        this.initialMoveMade = true;
    }
    private void setPawnPromotion() {
        this.pawnPromotion = true;
    }
    public Boolean getPawnPromotion() {
        return pawnPromotion;
    }
    @Override
    public void displayPiece() {
        if (getColor().equals("White"))
            System.out.print("wP ");
        else
            System.out.print("bP ");
    }
    @Override
    public void possibleMoves(Pieces[][] pieceMatrix, ArrayList<Position> moves) {
        int rowDirection = getColor().equals("White") ? -1 : 1;
        int targetRow = getPosition().getRow() + rowDirection;

        // when a pawn is at the end of column change this to handle pawn promotion
        if (targetRow < 0 || targetRow > 7)
            return;

        // normal moves
        if (pieceMatrix[targetRow][getPosition().getColumn()] == null) {
            Position newMove = new Position(targetRow, getPosition().getColumn());
            moves.add(newMove);

            if (!getInitialMoveMade()) {// handle initial position

            }
        }

        // diagonal moves
        int columnDirection;
        int targetColumn;

        // en passant
    }
}
