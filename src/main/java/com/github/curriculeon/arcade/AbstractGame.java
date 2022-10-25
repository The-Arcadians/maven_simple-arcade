package com.github.curriculeon.arcade;

import java.util.ArrayList;
import java.util.List;

abstract public class AbstractGame implements GameInterface {
    private List<PlayerInterface> playerList;

    public AbstractGame() {
        this(new ArrayList<>());
    }

    public AbstractGame(List<PlayerInterface> playerList) {
        this.playerList = playerList;
    }

    @Override
    public List<PlayerInterface> getPlayers() {
        return playerList;
    }

    @Override
    public void run() {
        for(PlayerInterface player : getPlayers()) {
            player.play(this);
        }
    }

    abstract public String getInstructions();
}
