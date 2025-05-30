package Board;
import Utility.Utility;
import Position.Position;
import Pieces.*;
import java.util.Scanner;

/*
 * This executes to get user input (move)
 * and displays the state of the board.
 */
public class Board {
    //use methods from Utility class
    private Utility utils = new Utility();

    //holds all pieces 
    private Pieces[][] pieceMatrix = new Pieces[8][8];

    //input
    private Scanner scanner;

    public Board () {
        this.scanner = new Scanner(System.in);
        // Place Rooks
        pieceMatrix[0][0] = new Rook("Black", new Position(0, 0));
        pieceMatrix[0][7] = new Rook("Black", new Position(0, 7));
        pieceMatrix[7][0] = new Rook("White", new Position(7, 0));
        pieceMatrix[7][7] = new Rook("White", new Position(7, 7));

        // Place Knights
        pieceMatrix[0][1] = new Knight("Black", new Position(0, 1));
        pieceMatrix[0][6] = new Knight("Black", new Position(0, 6));
        pieceMatrix[7][1] = new Knight("White", new Position(7, 1));
        pieceMatrix[7][6] = new Knight("White", new Position(7, 6));

        // Place Bishops
        pieceMatrix[0][2] = new Bishop("Black", new Position(0, 2));
        pieceMatrix[0][5] = new Bishop("Black", new Position(0, 5));
        pieceMatrix[7][2] = new Bishop("White", new Position(7, 2));
        pieceMatrix[7][5] = new Bishop("White", new Position(7, 5));

        // Place Queens
        pieceMatrix[0][3] = new Queen("Black", new Position(0, 3));
        pieceMatrix[7][3] = new Queen("White", new Position(7, 3));

        // Place Kings
        pieceMatrix[0][4] = new King("Black", new Position(0, 4));
        pieceMatrix[7][4] = new King("White", new Position(7, 4));

        // Place Pawns
        for (int i = 0; i < 8; i++) {
            pieceMatrix[1][i] = new Pawn("Black", new Position(1, i));
            pieceMatrix[6][i] = new Pawn("White", new Position(6, i));
        }
    }

    public boolean makeMove(String currentTurn) {
        Boolean validMove = false;
        String move = "";

        System.out.println(currentTurn + " enter a move: (eg. E2 E4)");
        do {
            move = scanner.nextLine();
            // sets a variable "error" to whatever error if one found
            validMove = utils.checkMove(pieceMatrix, currentTurn, move);
            if (!validMove) {
                String errorType = utils.getErrorType();
                switch (errorType) {
                    case "BI":// bad input
                        System.out.println("ERROR: Incorrect input!");
                    case "NPAP":// no such piece found
                        System.out.println("ERROR: No piece at initial position!");
                        break;
                    case "OOB":// out of bounds
                        System.out.println("ERROR: Destination out of bounds!");
                        break;
                    case "WPT":// wrong player turn
                        System.out.println("ERROR: Can only move " + currentTurn + " pieces!");
                        break;
                    case "PMV":// piece movement violation
                        System.out.println("ERROR: Illegal move for piece!");
                        break;
                    case "FPB":// friendly piece block
                        System.out.println("ERROR: " + currentTurn + " piece in destination!");
                        break;
                    case "SIC":// still in check
                        System.out.println("ERROR: " + currentTurn + " is still in check!");
                        break;
                    default:
                        break;
                }
            }
        } while (!validMove);
        
        // executes move on the board, updates captured pieces, and sets a variable "checkmate" to true or false after moving a piece
        utils.updateBoard(pieceMatrix, move);

        if (utils.getCheckmateStatus()) {
            scanner.close();
            return true;
        }
        else   
            return false;
    }
    public void displayBoard() {
        System.out.println("  A  B  C  D  E  F  G  H");
        for (int row = 0; row < 8; row++) {
            System.out.print(8 - row + " ");
            for (int col = 0; col < 8; col++) {
                Pieces piece = pieceMatrix[row][col];
                if (piece != null) {
                    piece.displayPiece();
                } else {
                    if ((row + col) % 2 == 0) {
                        System.out.print("   ");
                    } else {
                        System.out.print("## ");
                    }
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}
