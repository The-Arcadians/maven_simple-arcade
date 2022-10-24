package com.github.curriculeon.arcade.numberguess;

import com.github.curriculeon.arcade.GameInterface;
import com.github.curriculeon.arcade.PlayerInterface;
import com.github.curriculeon.utils.AnsiColor;
import com.github.curriculeon.utils.IOConsole;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
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

    public NumberGuessGame(Integer maximumNumber, Integer minimumNumber) {
        this.maximumNumber = maximumNumber;
        this.minimumNumber = minimumNumber;
    }

    @Override
    public void run() {
        Integer numberToGuess = ThreadLocalRandom.current().nextInt(minimumNumber, maximumNumber);
        String playerResponse = null;
        do {
            for (PlayerInterface player : getPlayers()) {
                playerResponse = player.play(this);
                if (playerResponse.equals(numberToGuess.toString())) {
                    console.println(GameInterface.winnerMessage);
                }
            }
        } while (!playerResponse.equals(getQuitNumber().toString()));
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