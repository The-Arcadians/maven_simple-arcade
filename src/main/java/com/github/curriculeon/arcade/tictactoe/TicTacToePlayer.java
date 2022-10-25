package com.github.curriculeon.arcade.tictactoe;

import com.github.curriculeon.arcade.AbstractPlayer;
import com.github.curriculeon.arcade.ArcadeAccount;

import java.util.function.Supplier;

public class TicTacToePlayer extends AbstractPlayer {
    public TicTacToePlayer(ArcadeAccount arcadeAccount) {
        super(arcadeAccount);
    }

    @Override
    public ArcadeAccount getArcadeAccount() {
        return null;
    }

    @Override
    public Void play(Object game) {
        setCellSelection(
                (TicTacToe) game,
                "X",
                () -> selectInteger("Where would you like to play? Choose 1-9"));
        return null;
    }

    public void setCellSelection(TicTacToe ticTacToeGame, String symbol, Supplier<Integer> cellSelector) {
        if (!ticTacToeGame.isRoundComplete()) {
            TicTacToeBoard ticTacToeBoard = ticTacToeGame.getBoard();
            Integer selectedCellIndex;
            Boolean isInvalidPlay;
            do {
                selectedCellIndex = cellSelector.get();
                isInvalidPlay = !ticTacToeBoard.isValidPlay(selectedCellIndex);
                if (isInvalidPlay) {
                    error("Invalid play!");
                }
            } while (isInvalidPlay);
            ticTacToeBoard.setCellByIndex(selectedCellIndex, symbol);
        }
    }
}
