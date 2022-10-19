package com.github.curriculeon.arcade.tictactoe;

import com.github.curriculeon.arcade.GameInterface;
import com.github.curriculeon.arcade.PlayerInterface;
import com.github.curriculeon.utils.AnsiColor;
import com.github.curriculeon.utils.IOConsole;
import com.github.curriculeon.utils.Sleep;

import java.util.Objects;
import java.util.Random;

public class TicTacToe implements GameInterface {
    private final IOConsole console = new IOConsole(AnsiColor.BLUE);

    @Override
    public void run() {


        while (true) {
            printInstructions();

            String[][] demo = {
                    {"1", "2", "3"},
                    {"4", "5", "6"},
                    {"7", "8", "9"}
            };

            String[][] userInterface = {
                    {" ", " ", " "},
                    {" ", " ", " "},
                    {" ", " ", " "}
            };

            displayBoard(demo);

            while (true) {
                userPlay(userInterface);
                if (isRoundComplete(userInterface)) {
                    break;
                }
                displayBoard(userInterface);

                computerPlay(userInterface);
                if (isRoundComplete(userInterface)) {
                    break;
                }
                displayBoard(userInterface);
            }
            Integer playAgainInput = console.getIntegerInput("(1) Play Again (2) Quit");
            if (playAgainInput == 2) {
                break;
            }
        }

    }

    private boolean isValidPlay(String[][] userInterface, String position) {
        int userInput = Integer.parseInt(position);
        int rowSelection = (userInput - 1) / 3;
        int columnSelection = (userInput - 1) % 3;
        String[] row = userInterface[rowSelection];
        String cell = row[columnSelection];
        boolean isValid = Objects.equals(cell, " ");
        console.println("[ %s ] = selected Row", rowSelection);
        console.println("[ %s ] = selected Column", columnSelection);
        if (!isValid) {
            console.println("This is not a valid play.");
        }
        return isValid;
    }

    private void playerMove(String[][] userInterface, String position, String symbol) {
        int userInput = Integer.parseInt(position);
        int rowSelection = (userInput - 1) / 3;
        int columnSelection = userInput % 3;
        userInterface[rowSelection][columnSelection] = symbol;
    }

    private void computerPlay(String[][] board) {
        Random rand = new Random();
        Integer computerMove = null;
        while (true) {
            computerMove = rand.nextInt(9) + 1;
            if (isValidPlay(board, Integer.toString(computerMove))) {
                break;
            }
        }
        System.out.println("Computer played " + computerMove);
        playerMove(board, Integer.toString(computerMove), "0");
    }

    private void userPlay(String[][] userInterface) {
        String userInput;
        while (true) {
            userInput = console.getStringInput("Where would you like to play? Choose 1-9");
            if (isValidPlay(userInterface, userInput)) {
                break;
            } else {
                System.out.println(userInput + " is not a valid move.");
            }
        }
        playerMove(userInterface, userInput, "X");
    }

    public boolean declareWinner(String[][] board, String symbol) {
        if ((Objects.equals(board[0][0], symbol) && Objects.equals(board[0][1], symbol) && Objects.equals(board[0][2], symbol))
                || (Objects.equals(board[1][0], symbol) && Objects.equals(board[1][1], symbol) && Objects.equals(board[1][2], symbol))
                || (Objects.equals(board[2][0], symbol) && Objects.equals(board[2][1], symbol) && Objects.equals(board[2][2], symbol))

                || (Objects.equals(board[0][0], symbol) && Objects.equals(board[1][0], symbol) && Objects.equals(board[2][0], symbol))
                || (Objects.equals(board[0][1], symbol) && Objects.equals(board[1][1], symbol) && Objects.equals(board[2][1], symbol))
                || (Objects.equals(board[0][2], symbol) && Objects.equals(board[1][2], symbol) && Objects.equals(board[2][2], symbol))

                || (Objects.equals(board[0][0], symbol) && Objects.equals(board[1][1], symbol) && Objects.equals(board[2][2], symbol))
                || (Objects.equals(board[0][2], symbol) && Objects.equals(board[1][1], symbol) && Objects.equals(board[2][0], symbol))) {
            return true;

        }
        return false;
    }

    public boolean isRoundComplete(String[][] userInterface) {
        if (declareWinner(userInterface, "X")) {

            displayBoard(userInterface);
            System.out.println("Congrats player!");
            return true;
        }

        if (declareWinner(userInterface, "O")) {
            displayBoard(userInterface);
            System.out.println("Sorry, you've lost to the machine.");
            return true;
        }

        for (int i = 0; i < userInterface.length; i++) {
            for (int j = 0; j < userInterface[i].length; j++) {
                if (userInterface[i][j] == " ") {
                    return false;
                }
            }
        }
        displayBoard(userInterface);
        System.out.println("No way, it's a tie!");
        return true;
    }


    private void displayBoard(String[][] userInterface) {
        System.out.println(userInterface[0][0] + " | " + userInterface[0][1] + " | " + userInterface[0][2]);
        System.out.println("-  -  - - ");
        System.out.println(userInterface[1][0] + " | " + userInterface[1][1] + " | " + userInterface[1][2]);
        System.out.println("-  -  - - ");
        System.out.println(userInterface[2][0] + " | " + userInterface[2][1] + " | " + userInterface[2][2]);
    }

    public void printSleepyBannerLineByLine(String message, int milliseconds) {
        String[] stringArray = message.split("\n");
        int len = stringArray.length;
        for (int i = 0; i < len; i++) {
            Sleep.sleep(milliseconds);
            System.out.print(stringArray[i]);
            if (i < len - 1) System.out.print("\n");
        }
    }


    @Override
    public String printInstructions() {
        printSleepyBannerLineByLine("", 200);
        return null;
    }

    @Override
    public void add(PlayerInterface player) {

    }

    @Override
    public void remove(PlayerInterface player) {

    }
}
