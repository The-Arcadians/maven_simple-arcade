package com.github.curriculeon.arcade.tictactoe;

import com.github.curriculeon.arcade.AbstractGame;

public class TicTacToe extends AbstractGame {
    private TicTacToeBoard board;

    public String getInstructions() {
        String[][] controls = {
                {"1", "2", "3"},
                {"4", "5", "6"},
                {"7", "8", "9"}
        };
        String result = new TicTacToeBoard(controls).toString();
        return result;
    }

    public void run() {
        info("Starting a new game of [ %s ]", getClass().getSimpleName());
        if(getPlayers().size() < 2) {
            getPlayers().add(new TicTacToeNpc(null));
        }
        while (true) {
            setBoard(new TicTacToeBoard());
            special(getInstructions());
            do {
                super.run();
                special(getBoard().toString());
            } while (!isRoundComplete());
            special("Game over!");
            special("The winner of the game was [ %s ]", getBoard().getWinner());
        }
    }

    public boolean isRoundComplete() {
        if (" ".equals(getBoard().getWinner())) {
            String[][] userInterface = getBoard().getMatrix();
            for (int i = 0; i < userInterface.length; i++) {
                for (int j = 0; j < userInterface[i].length; j++) {
                    boolean hasEmptyCells = userInterface[i][j] == " ";
                    if (hasEmptyCells) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public void setBoard(TicTacToeBoard ticTacToeBoard) {
        this.board = ticTacToeBoard;
    }

    public TicTacToeBoard getBoard() {
        return board;
    }
}
