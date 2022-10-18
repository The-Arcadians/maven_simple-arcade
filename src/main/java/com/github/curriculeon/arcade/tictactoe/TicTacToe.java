package com.github.curriculeon.arcade.tictactoe;

import com.github.curriculeon.arcade.GameInterface;
import com.github.curriculeon.arcade.PlayerInterface;
import com.github.curriculeon.utils.AnsiColor;
import com.github.curriculeon.utils.IOConsole;

import java.util.Objects;
import java.util.Random;

public class TicTacToe implements GameInterface {
    private final IOConsole console = new IOConsole(AnsiColor.BLUE);

    @Override
    public void run() {


        while(true){
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
                if (isRoundComplete(userInterface)){
                    break;
                }
                displayBoard(userInterface);

                computerPlay(userInterface);
                if (isRoundComplete(userInterface)){
                    break;
                }
                displayBoard(userInterface);
            }
            Integer playAgainInput = console.getIntegerInput("(1) Play Again (2) Quit");
            if (playAgainInput == 2){
                break;
            }
        }

    }

    private boolean isValidPlay (String[][] userInterface, String position) {
        switch (position){
            case "1":
                return (Objects.equals(userInterface[0][0], " "));
            case "2":
                return (Objects.equals(userInterface[0][1], " "));
            case "3":
                return (Objects.equals(userInterface[0][2], " "));
            case "4":
                return (Objects.equals(userInterface[1][0], " "));
            case "5":
                return (Objects.equals(userInterface[1][1], " "));
            case "6":
                return (Objects.equals(userInterface[1][2], " "));
            case "7":
                return (Objects.equals(userInterface[2][0], " "));
            case "8":
                return (Objects.equals(userInterface[2][1], " "));
            case "9":
                return (Objects.equals(userInterface[2][2], " "));
            default:
                return false;
        }
    }

    private void playerMove(String[][] userInterface, String position, String symbol){
        switch(position){
            case "1":
                userInterface[0][0] = symbol;
                break;
            case "2":
                userInterface[0][1] = symbol;
                break;
            case "3":
                userInterface[0][2] = symbol;
                break;
            case "4":
                userInterface[1][0] = symbol;
                break;
            case "5":
                userInterface[1][1] = symbol;
                break;
            case "6":
                userInterface[1][2] = symbol;
                break;
            case "7":
                userInterface[2][0] = symbol;
                break;
            case "8":
                userInterface[2][1] = symbol;
                break;
            case "9":
                userInterface[2][2] = symbol;
                break;
            default:
                System.out.println("This is not a valid play.");
        }
    }

    private void computerPlay(String[][] board){
        Random rand = new Random();
        int computerMove;
        while (true){
            computerMove = rand.nextInt(9) + 1;
            if (isValidPlay(board, Integer.toString(computerMove))){
                break;
            }
        }
        System.out.println("Computer played " + computerMove);
        playerMove(board, Integer.toString(computerMove), "0");
    }

    private void userPlay (String[][] userInterface) {
        String userInput;
        while (true) {
            userInput = console.getStringInput("Where would you like to play? Choose 1-9");
            if (isValidPlay(userInterface, userInput)){
                break;
            } else {
                System.out.println(userInput + " is not a valid move.");
            }
        }
    }

    public boolean declareWinner(String[][] board, String symbol){
        if ((Objects.equals(board[0][0], symbol) && Objects.equals(board[0][1], symbol) && Objects.equals(board[0][2], symbol))
            || (Objects.equals(board[1][0], symbol) && Objects.equals(board[1][1], symbol) && Objects.equals(board[1][2], symbol))
            || (Objects.equals(board[2][0], symbol) && Objects.equals(board[2][1], symbol) && Objects.equals(board[2][2], symbol))

            || (Objects.equals(board[0][0], symbol) && Objects.equals(board[1][0], symbol) && Objects.equals(board[2][0], symbol))
            || (Objects.equals(board[0][1], symbol) && Objects.equals(board[1][1], symbol) && Objects.equals(board[2][1], symbol))
            || (Objects.equals(board[0][2], symbol) && Objects.equals(board[1][2], symbol) && Objects.equals(board[2][2], symbol))

            || (Objects.equals(board[0][0], symbol) && Objects.equals(board[1][1], symbol) && Objects.equals(board[2][2], symbol))
            || (Objects.equals(board[0][2], symbol) && Objects.equals(board[1][1], symbol) && Objects.equals(board[2][0], symbol)) ) {
                return true;

        }
        return false;
    }

    public boolean isRoundComplete(String[][] userInterface) {
        if (declareWinner(userInterface, "X")){

            displayBoard(userInterface);
            System.out.println("Congrats player!");
            return true;
        }

        if (declareWinner(userInterface, "O")){
            displayBoard(userInterface);
            System.out.println("Sorry, you've lost to the machine.");
            return true;
        }

        for (int i = 0; i < userInterface.length; i++){
            for (int j = 0; j < userInterface[i].length; j++){
                if (userInterface[i][j] == " "){
                    return false;
                }
            }
        }
        displayBoard(userInterface);
        System.out.println("No way, it's a tie!");
        return true;
    }


    private void displayBoard(String[][] userInterface){
        System.out.println(userInterface[0][0] + " | " +  userInterface[0][1] + " | " +  userInterface[0][2] );
        System.out.println("-  -  - - ");
        System.out.println(userInterface[1][0] + " | " +  userInterface[1][1] + " | " +  userInterface[1][2] );
        System.out.println("-  -  - - ");
        System.out.println(userInterface[2][0] + " | " +  userInterface[2][1] + " | " + userInterface[2][2] );
    }

    @Override
    public String printInstructions() {
        return ":::: Welcome to Arcadian Tic Tac Toe ::::";
    }

    @Override
    public void add(PlayerInterface player) {

    }

    @Override
    public void remove(PlayerInterface player) {

    }
}
