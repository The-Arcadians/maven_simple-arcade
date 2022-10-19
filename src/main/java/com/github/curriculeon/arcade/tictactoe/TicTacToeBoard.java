package com.github.curriculeon.arcade.tictactoe;

import com.github.curriculeon.utils.AnsiColor;
import com.github.curriculeon.utils.IOConsole;

import java.util.Objects;
import java.util.StringJoiner;

public class TicTacToeBoard {
    private IOConsole console;
    private String[][] userInterface;

    public TicTacToeBoard() {
        this(new String[][]{
                {" ", " ", " "},
                {" ", " ", " "},
                {" ", " ", " "}
        });
    }

    public TicTacToeBoard(String[][] userInterface) {
        this.userInterface = userInterface;
        this.console = new IOConsole(AnsiColor.BLUE);
    }

    public boolean isValidPlay(String userInput) {
        return isValidPlay(Integer.parseInt(userInput));
    }

    public boolean isValidPlay(int userInput) {
        IOConsole console = new IOConsole(AnsiColor.YELLOW);
        String cell = getCellByIndex(userInput);
        boolean isValid = Objects.equals(cell, " ");
        if (!isValid) {
            console.println("This is not a valid play.");
        }
        return isValid;
    }

    public void setCellByIndex(int cellIndex, String symbol) {
        int rowSelection = (cellIndex - 1) / 3;
        int columnSelection = (cellIndex-1) % 3;
        String cell = userInterface[rowSelection][columnSelection];
        if (" " == cell) {
            userInterface[rowSelection][columnSelection] = symbol;
        } else {
            IOConsole console = new IOConsole(AnsiColor.YELLOW);
            console.println("[ %s , %s ] has a value of [ %s ].", rowSelection, columnSelection, cell);
        }
    }


    public String getCellByIndex(int cellIndex) {
        IOConsole console = new IOConsole(AnsiColor.YELLOW);
        int rowSelection = (cellIndex - 1) / 3;
        int columnSelection = (cellIndex-1) % 3;
        console.println("[ %s ] is the selected cell-index.", cellIndex);
        console.println("[ %s , %s ] is the selected matrix-index.", rowSelection, columnSelection);
        return userInterface[rowSelection][columnSelection];
    }

    public String getCell(int rowNumber, int columnNumber) {
        try {
            return userInterface[rowNumber][columnNumber];
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String toString() {
        return "\n======================================\n" +
                new StringJoiner("\n-  -  - - \n")
                        .add(userInterface[0][0] + " | " + userInterface[0][1] + " | " + userInterface[0][2])
                        .add(userInterface[1][0] + " | " + userInterface[1][1] + " | " + userInterface[1][2])
                        .add(userInterface[2][0] + " | " + userInterface[2][1] + " | " + userInterface[2][2]) +
                "\n======================================\n";
    }

    public void displayBoard() {
        console.println(toString());
    }

    public void displayControls() {
        String[][] controls = {
                {"1", "2", "3"},
                {"4", "5", "6"},
                {"7", "8", "9"}
        };
        console.println(new TicTacToeBoard(controls).toString());
    }

    public String getWinner() {
        boolean isWinnerO = isInFavorOf("O");
        boolean isWinnerX = isInFavorOf("X");

        if (isWinnerO) {
            return "O";
        }
        if (isWinnerX) {
            return "X";
        }

        return " ";
    }

    public Boolean isInFavorOf(String sumbol) {
        String topLeft = this.userInterface[0][0];
        String topMiddle = this.userInterface[0][1];
        String topRight = this.userInterface[0][2];
        String middleLeft = this.userInterface[1][0];
        String middleMiddle = this.userInterface[1][1];
        String middleRight = this.userInterface[1][2];
        String bottomLeft = this.userInterface[2][0];
        String bottomMiddle = this.userInterface[2][1];
        String bottomRight = this.userInterface[2][2];

        String[] topRow = new String[]{topLeft, topMiddle, topRight};
        String[] middleRow = new String[]{middleLeft, middleMiddle, middleRight};
        String[] bottomRow = new String[]{bottomLeft, bottomMiddle, bottomRight};
        String[] leftColumn = new String[]{topLeft, middleLeft, bottomLeft};
        String[] middleColumn = new String[]{topMiddle, middleMiddle, bottomMiddle};
        String[] rightColumn = new String[]{topRight, middleRight, bottomRight};
        String[] leftDiagonal = new String[]{topLeft, middleMiddle, bottomRight};
        String[] rightDiagonal = new String[]{topRight, middleMiddle, bottomLeft};

        return hasSameElement(sumbol, topRow) ||
                hasSameElement(sumbol, middleRow) ||
                hasSameElement(sumbol, bottomRow) ||
                hasSameElement(sumbol, leftColumn) ||
                hasSameElement(sumbol, middleColumn) ||
                hasSameElement(sumbol, rightColumn) ||
                hasSameElement(sumbol, leftDiagonal) ||
                hasSameElement(sumbol, rightDiagonal);
    }


    public Boolean hasSameElement(String item, String[] row) {
        for (String symbol : row) {
            if (item != symbol)
                return false;
        }
        return true;
    }

    public String[][] getMatrix() {
        return this.userInterface;
    }
}
