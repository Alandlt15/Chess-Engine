# Java Chess Engine

### Project Overview:
This engine heavily utilizes object oriented design patterns and principles. It breaks down most of the main tasks needed for the chess game to work into significantly smaller ones. Currently, the game runs on a player vs. player game mode with a future CPU vs. player implementation in the future.

### Structure:
Board.java:
- holds the 2d array of pieces
- takes a move as input & calls Utility to check for errors
- makes a move on the board using Utility
- checks for checkmate using Utility

ChessGame.java:
- determines what game mode to execute
- runs the main game loop using Board
- outputs winner once checkmate is returned

DetectErrors.java:
- returns the type of error encountered

GameMode.java:
- hold game move information
- toggles turns 

HandleBoardActivity.java:
- determines the type of activity & updates the board

MoveHistory.java:
- holds list of made moves & list of captured pieces from both sides

Pieces.java:
- coupled classes of different piece types
- each piece class generates possible moves based on Chess logic

Player.java:
- holds player's color

Position.java:
- holds row and column information for an individual piece

Run.java:
- starts the application

Utility.java:
- handles move validation
- handles updating the board
- processes input from user

### Things to Implement:
- [ ] Settings like save game, load game, new game
- [ ] Output move history and list of captured pieces by each side
- [ ] CPU vs. Player
- [ ] GUI with JavaFX
- [ ] Other GUI settings

December 2024
