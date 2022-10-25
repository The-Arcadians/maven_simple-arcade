package com.github.curriculeon.arcade.tictactoe;

import com.github.curriculeon.arcade.ArcadeAccount;
import com.github.curriculeon.utils.RandomUtils;

public class TicTacToeNpc extends TicTacToePlayer {
    public TicTacToeNpc(ArcadeAccount arcadeAccount) {
        super(arcadeAccount);
    }

    @Override
    public Void play(Object game) {
        super.setCellSelection(
                (TicTacToe) game,
                "O",
                () -> RandomUtils.createInteger(1, 9));
        return null;
    }
}
