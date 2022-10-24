package com.github.curriculeon.arcade.numberguess;

import com.github.curriculeon.arcade.ArcadeAccount;
import com.github.curriculeon.arcade.PlayerInterface;
import com.github.curriculeon.utils.AnsiColor;
import com.github.curriculeon.utils.IOConsole;

/**
 * Created by leon on 7/21/2020.
 */
public class NumberGuessPlayer implements PlayerInterface {
    private IOConsole console = new IOConsole(AnsiColor.AUTO);

    @Override
    public ArcadeAccount getArcadeAccount() {
        return null;
    }

    @Override
    public String play(Object game) {
        NumberGuessGame numberGuessGame = (NumberGuessGame) game;
        return console.getStringInput(
                numberGuessGame.getInstructions(),
                numberGuessGame.getQuitNumber(),
                numberGuessGame.getMinimumNumber(),
                numberGuessGame.getMaximumNumber());
    }
}