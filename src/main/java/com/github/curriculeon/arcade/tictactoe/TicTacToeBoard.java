package com.github.curriculeon.arcade.tictactoe;

import com.github.curriculeon.utils.AnsiColor;
import com.github.curriculeon.utils.IOConsole;

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

    public void setCellByIndex(int cellIndex, String symbol) {
        int rowSelection = (cellIndex - 1) / 3;
        int columnSelection = (cellIndex - 1) % 3;
        String cell = userInterface[rowSelection][columnSelection];
        if (isValidPlay(cellIndex)) {
            userInterface[rowSelection][columnSelection] = symbol;
        } else {
            IOConsole console = new IOConsole(AnsiColor.YELLOW);
            console.println("This is not a valid play.");
            console.println("[ %s , %s ] has a value of [ %s ].", rowSelection, columnSelection, cell);
        }
    }

    public boolean isValidPlay(int selection) {
        return " ".equals(getCellByIndex(selection));
    }

    public String getCellByIndex(int cellIndex) {
        IOConsole console = new IOConsole(AnsiColor.YELLOW);
        int rowSelection = (cellIndex - 1) / 3;
        int columnSelection = (cellIndex - 1) % 3;
        console.println("[ %s ] is the selected cell-index.", cellIndex);
        console.println("[ %s , %s ] is the selected matrix-index.", rowSelection, columnSelection);
        return userInterface[rowSelection][columnSelection];
    }

    public Boolean isInFavorOf(String symbol) {
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

        return hasSameElement(symbol, topRow) ||
                hasSameElement(symbol, middleRow) ||
                hasSameElement(symbol, bottomRow) ||
                hasSameElement(symbol, leftColumn) ||
                hasSameElement(symbol, middleColumn) ||
                hasSameElement(symbol, rightColumn) ||
                hasSameElement(symbol, leftDiagonal) ||
                hasSameElement(symbol, rightDiagonal);
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

    public String toString() {
        return "\n======================================\n" +
                new StringJoiner("\n-  -  - - \n")
                        .add(userInterface[0][0] + " | " + userInterface[0][1] + " | " + userInterface[0][2])
                        .add(userInterface[1][0] + " | " + userInterface[1][1] + " | " + userInterface[1][2])
                        .add(userInterface[2][0] + " | " + userInterface[2][1] + " | " + userInterface[2][2]) +
                "\n======================================\n";
    }


}
