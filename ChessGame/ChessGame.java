package ChessGame;
import Board.Board;
import GameMode.*;
import java.util.Scanner;

public class ChessGame {
    //populates board with pieces
    private Board board = new Board();

    public void start () {
        Scanner scnr = new Scanner(System.in);
        System.out.println("Select a Game Mode: (eg. 1)");
        System.out.println("1. Player v. Player");
        System.out.println("2. Player v. CPU");
        int mode = scnr.nextInt();
        System.out.print("\033[H\033[2J");

        if (mode == 1) {
            System.out.print("Enter player 1's name: ");
            String p1Name = scnr.next();
            System.out.print("Enter player 2's name: ");
            String p2Name = scnr.next();

            PlayervPlayer pvp = new PlayervPlayer(p1Name, p2Name);
            System.out.println("Player 1's name is " + pvp.getPlayer1Name() + " and their color is " + pvp.getPlayer1Color() + ".");
            System.out.println("Player 2's name is " + pvp.getPlayer2Name() + " and their color is " + pvp.getPlayer2Color() + ".");
            System.out.println();

            Boolean checkmate = false;
            while (!checkmate) {
                board.displayBoard();
                checkmate = board.makeMove(pvp.getCurrentTurn());
                pvp.toggleTurn();
            }
            pvp.toggleTurn();
            if (pvp.getCurrentTurn().equals(pvp.getPlayer1Color()))
                System.out.print("Congratulations " + pvp.getPlayer1Name() + "!");
            else
                System.out.print("Congratulations " + pvp.getPlayer2Name() + "!");
        }// end of PvP
        scnr.close();
    }
}
