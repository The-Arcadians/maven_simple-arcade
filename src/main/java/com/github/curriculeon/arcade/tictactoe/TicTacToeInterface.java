package com.github.curriculeon.arcade.tictactoe;

import com.github.curriculeon.arcade.PlayerInterface;
import com.github.curriculeon.utils.IOConsole;
import com.github.curriculeon.utils.Sleep;

import java.util.Random;

public interface TicTacToeInterface {

    default void run() {
        while (true) {
            getBoard().displayControls();

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

    default void computerPlay() {
        Random rand = new Random();
        Integer computerMove = null;
        while (true) {
            computerMove = rand.nextInt(9) + 1;
            if (getBoard().isValidPlay(Integer.toString(computerMove))) {
                break;
            }
        }
        System.out.println("Computer played " + computerMove);
        getBoard().setCellByIndex(computerMove, "O");
    }

    default void userPlay() {
        String userInput;
        while (true) {
            userInput = getConsole().getStringInput("Where would you like to play? Choose 1-9");
            if (getBoard().isValidPlay(userInput)) {
                getBoard().setCellByIndex(Integer.parseInt(userInput), "X");
                break;
            } else {
                System.out.println(userInput + " is not a valid move.");
            }
        }
        getBoard().displayBoard();
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
