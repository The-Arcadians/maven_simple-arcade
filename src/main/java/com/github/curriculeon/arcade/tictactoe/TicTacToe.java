package com.github.curriculeon.arcade.tictactoe;

import com.github.curriculeon.arcade.GameInterface;
import com.github.curriculeon.arcade.PlayerInterface;
import com.github.curriculeon.utils.AnsiColor;
import com.github.curriculeon.utils.IOConsole;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class TicTacToe implements GameInterface {
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
        while (true) {
            setBoard(new TicTacToeBoard());
            getConsole().println(getInstructions());

            while (!isRoundComplete()) {
                userPlay();
                computerPlay();
                getConsole().println(getBoard().toString());
            }
            Integer playAgainInput = getConsole().getIntegerInput("(1) Play Again (2) Quit");
            if (playAgainInput == 2) {
                break;
            }
        }
    }

    public void computerPlay() {
        Integer randomSelection;
        Boolean isInvalidPlay;
        do {
            randomSelection = ThreadLocalRandom.current().nextInt(1, 9);
            isInvalidPlay = !getBoard().isValidPlay(randomSelection);
            if (isInvalidPlay) {
                new IOConsole(AnsiColor.RED).println("Invalid play!");
            }
        } while (isInvalidPlay);
        getBoard().setCellByIndex(randomSelection, "O");
    }

    public void userPlay() {
        Integer randomSelection;
        Boolean isInvalidPlay;
        do {
            randomSelection = getConsole().getIntegerInput("Where would you like to play? Choose 1-9");
            isInvalidPlay = !getBoard().isValidPlay(randomSelection);
            if (isInvalidPlay) {
                new IOConsole(AnsiColor.RED).println("Invalid play!");
            }
        } while (isInvalidPlay);
        getBoard().setCellByIndex(randomSelection, "X");
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

    public IOConsole getConsole() {
        return new IOConsole(AnsiColor.BLUE);
    }

    public void setBoard(TicTacToeBoard ticTacToeBoard) {
        this.board = ticTacToeBoard;
    }

    public TicTacToeBoard getBoard() {
        return board;
    }

    @Override
    public List<PlayerInterface> getPlayers() {
        return null;
    }
}
