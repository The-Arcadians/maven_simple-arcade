package com.github.curriculeon.arcade.tictactoe;

import com.github.curriculeon.arcade.PlayerInterface;
import com.github.curriculeon.utils.AnsiColor;
import com.github.curriculeon.utils.IOConsole;
import com.github.curriculeon.utils.Sleep;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public interface TicTacToeInterface {
    default String getInstructions() {
        String[][] controls = {
                {"1", "2", "3"},
                {"4", "5", "6"},
                {"7", "8", "9"}
        };
        String result = new TicTacToeBoard(controls).toString();
        return result;
    }

    default void run() {
        do {
            getConsole().println(getInstructions());
            while (isRoundComplete()) {
                userPlay();
                computerPlay();
                getConsole().println(getBoard().toString());
            }
        } while(getConsole().getIntegerInput("(1) Play Again (2) Quit") != 2);

    }

    default void computerPlay() {
        Integer randomSelection;
        Boolean isInvalidPlay;
        do {
            randomSelection = ThreadLocalRandom.current().nextInt(1, 9);
            isInvalidPlay = !getBoard().isValidPlay(randomSelection);
            if(isInvalidPlay) {
                new IOConsole(AnsiColor.RED).println("Invalid play!");
            }
        } while (isInvalidPlay);
        getBoard().setCellByIndex(randomSelection, "O");
    }

    default void userPlay() {
        Integer randomSelection;
        Boolean isInvalidPlay;
        do {
            randomSelection = getConsole().getIntegerInput("Where would you like to play? Choose 1-9");
            isInvalidPlay = !getBoard().isValidPlay(randomSelection);
            if(isInvalidPlay) {
               new IOConsole(AnsiColor.RED).println("Invalid play!");
            }
        } while (isInvalidPlay);
        getBoard().setCellByIndex(randomSelection, "X");
    }

    default boolean isRoundComplete() {
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

    default void printSleepyBannerLineByLine(String message, int milliseconds) {
        String[] stringArray = message.split("\n");
        int len = stringArray.length;
        for (int i = 0; i < len; i++) {
            Sleep.sleep(milliseconds);
            System.out.print(stringArray[i]);
            if (i < len - 1) System.out.print("\n");
        }
    }

    IOConsole getConsole();

    TicTacToeBoard getBoard();
}
