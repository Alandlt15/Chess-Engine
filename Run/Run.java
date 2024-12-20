/*
 * Chess Engine
 * 
 * This program runs a chess engine. Equipped with player vs. player. 
 * Currently runs on the terminal, soon to implement GUI with JavaFX.
 * 
 * Author: Alan De La Torre
 * December 2024
 */
package Run;
import ChessGame.ChessGame;

public class Run {
    public static void main (String[] args) {
        ChessGame game = new ChessGame();
        game.start();
    }
}