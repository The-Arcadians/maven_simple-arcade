package com.github.curriculeon.arcade.tictactoe;

import com.github.curriculeon.arcade.ArcadeAccount;

import java.util.concurrent.ThreadLocalRandom;

public class TicTacToeNpc extends TicTacToePlayer {
    public TicTacToeNpc(ArcadeAccount arcadeAccount) {
        super(arcadeAccount);
    }

    @Override
    public Void play(Object game) {
        super.setCellSelection(
                (TicTacToe) game,
                "O",
                () -> ThreadLocalRandom.current().nextInt(1, 9));
        return null;
    }
}
