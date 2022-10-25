package com.github.curriculeon.arcade.numberguess;

import com.github.curriculeon.arcade.GameInterface;
import com.github.curriculeon.arcade.PlayerInterface;
import com.github.curriculeon.utils.AnsiColor;
import com.github.curriculeon.utils.IOConsole;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by leon on 7/21/2020.
 */
public class NumberGuessGame implements GameInterface {
    private List<PlayerInterface> players = new ArrayList<>();
    private IOConsole console = new IOConsole(AnsiColor.AUTO);
    private Integer maximumNumber;
    private Integer minimumNumber;

    public NumberGuessGame() {
        this(1, 40);
    }

    public NumberGuessGame(Integer minimumNumber, Integer maximumNumber) {
        this.maximumNumber = maximumNumber;
        this.minimumNumber = minimumNumber;
    }

    @Override
    public void run() {
        Integer numberToGuess = ThreadLocalRandom.current().nextInt(minimumNumber, maximumNumber);
        error(numberToGuess.toString());
        String playerResponse = null;
        Boolean playerWins = null;
        do {
            for (PlayerInterface player : getPlayers()) {
                //Get guess 3, giving a hint to make it easier.
                int incrementValue = 10;
                for(int minNumberToGuess=1; minNumberToGuess<getMaximumNumber(); minNumberToGuess+=incrementValue) {
                    int maxNumberToGuess = minNumberToGuess + incrementValue - 1;
                    if(numberToGuess >  minNumberToGuess && numberToGuess <= maxNumberToGuess) {
                        String message = "\nHint: The number is somewhere between %s-%s";
                        warn(message, minNumberToGuess, maxNumberToGuess);
                        playerResponse = player.play(this);
                    }
                }

            }
            playerWins = playerResponse.equals(numberToGuess.toString());
        } while (!playerWins);
        special(GameInterface.winnerMessage);
    }

    @Override
    public String getInstructions() {
        return new StringJoiner("\n")
                .add("Enter [ %s ] to quit")
                .add("or")
                .add("Enter [ a random number between %s and %s ]")
                .toString();
    }

    @Override
    public void add(PlayerInterface player) {
        getPlayers().add(player);
    }

    @Override
    public void remove(PlayerInterface player) {
        getPlayers().remove(player);
    }

    @Override
    public List<PlayerInterface> getPlayers() {
        return players;
    }

    public Integer getQuitNumber() {
        return getMinimumNumber() - 1;
    }

    public Integer getMaximumNumber() {
        return maximumNumber;
    }

    public Integer getMinimumNumber() {
        return minimumNumber;
    }
}