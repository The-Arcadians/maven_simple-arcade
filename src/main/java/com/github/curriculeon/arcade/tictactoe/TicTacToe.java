package com.github.curriculeon.arcade.tictactoe;

import com.github.curriculeon.arcade.GameInterface;
import com.github.curriculeon.arcade.PlayerInterface;
import com.github.curriculeon.utils.AnsiColor;
import com.github.curriculeon.utils.IOConsole;
import com.github.curriculeon.utils.Sleep;

import java.util.List;
import java.util.Objects;
import java.util.Random;

public class TicTacToe implements GameInterface, TicTacToeInterface {
    private TicTacToeBoard board;

    @Override
    public IOConsole getConsole() {
        return new IOConsole(AnsiColor.BLUE);
    }

    @Override
    public TicTacToeBoard getBoard() {
        return board;
    }

    @Override
    public List<PlayerInterface> getPlayers() {
        return null;
    }

    @Override
    public String printInstructions() {
        getBoard().displayControls();
        return null;
    }

    @Override
    public void run() {
        while (true) {
            this.board = new TicTacToeBoard();
            while (true) {
                userPlay();
                if (isRoundComplete()) {
                    break;
                }
                getBoard().displayBoard();

                computerPlay();
                if (isRoundComplete()) {
                    break;
                }
                getBoard().displayBoard();
            }
            Integer playAgainInput = getConsole().getIntegerInput("(1) Play Again (2) Quit");
            if (playAgainInput == 2) {
                break;
            }
        }

    }
}
