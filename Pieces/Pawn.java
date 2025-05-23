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
    public void setInitialMoveMadeTrue() {
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
    public String getType() {
        return "Pawn";
    }
    @Override
    public void possibleMoves(Pieces[][] pieceMatrix, ArrayList<Position> moves) {
        int rowDirection = getColor().equals("White") ? -1 : 1;

        // when a pawn is at the end of column change this to handle pawn promotion using a dedicated class to handle this behavior
        if (getPosition().getRow() + rowDirection == 0 || getPosition().getRow() + rowDirection == 7) {
            Position newMove = new Position(getPosition().getRow() + rowDirection, getPosition().getColumn());
            moves.add(newMove);
            setPawnPromotion();
            return;
        }

        // normal moves
        if (pieceMatrix[getPosition().getRow() + rowDirection][getPosition().getColumn()] == null) {// if no piece (black or white) is blocking, 1 move forward is valid
            Position newMove = new Position(getPosition().getRow() + rowDirection, getPosition().getColumn());
            moves.add(newMove);

            if (!getInitialMoveMade()) {// if initial move is true 
                rowDirection = getColor().equals("White") ? -2 : 2;
                if (pieceMatrix[getPosition().getRow() + rowDirection][getPosition().getColumn()] == null) {// if no piece (black or white) is blocking, an additional move forward is valid
                    newMove = new Position(getPosition().getRow() + rowDirection, getPosition().getColumn());
                    moves.add(newMove);
                }
            }
        }

        // diagonal moves
        rowDirection = getColor().equals("White") ? -1 : 1;
        if (getPosition().getColumn() > 0 && getPosition().getColumn() < 7) { // for pieces in the middle of board than can move left or right diagonally
            if (pieceMatrix[getPosition().getRow() + rowDirection][getPosition().getColumn() - 1] != null) {
                Position newMove = new Position(getPosition().getRow() + rowDirection, getPosition().getColumn() - 1);
                moves.add(newMove);
            }
            else if (pieceMatrix[getPosition().getRow() + rowDirection][getPosition().getColumn() + 1] != null) {
                Position newMove = new Position(getPosition().getRow() + rowDirection, getPosition().getColumn() + 1);
                moves.add(newMove);
            }
        }
        else if (getPosition().getColumn() == 0) {// piece is at column A

        }
        else {// piece is at column H

        }
        // en passant
    }
}
