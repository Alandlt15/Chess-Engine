package Pieces;
import Position.Position;
import java.util.ArrayList;

public abstract class Pieces {
    private String color;
    private Position position;

    public Pieces (String color, Position position) {
        this.color = color;
        this.position = position;
    }
    public String getColor() {
        return color;
    }
    public Position getPosition() {
        return position;
    }
    public void setPosition(Position newPosition) {
        this.position = newPosition;
    }
    public abstract String getType();
    public abstract void displayPiece();
    public abstract void possibleMoves(Pieces[][] pieceMatrix, ArrayList<Position> moves);
}
