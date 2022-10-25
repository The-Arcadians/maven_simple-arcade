package com.github.curriculeon.arcade.numberguess;

import com.github.curriculeon.arcade.AbstractPlayer;
import com.github.curriculeon.arcade.ArcadeAccount;

/**
 * Created by leon on 7/21/2020.
 */
public class NumberGuessPlayer extends AbstractPlayer {
    public NumberGuessPlayer(ArcadeAccount arcadeAccount) {
        super(arcadeAccount);
    }

    @Override
    public String play(Object game) {
        NumberGuessGame numberGuessGame = (NumberGuessGame) game;
        return selectString(
                numberGuessGame.getInstructions(),
                numberGuessGame.getQuitNumber(),
                numberGuessGame.getMinimumNumber(),
                numberGuessGame.getMaximumNumber());
    }
}