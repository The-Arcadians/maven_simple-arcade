package com.github.curriculeon.arcade;

import com.github.curriculeon.utils.Loggable;

import java.util.List;

/**
 * Created by leon on 7/21/2020.
 */
public interface GameInterface extends Loggable, Runnable {
    List<PlayerInterface> getPlayers();
    /**
     * adds a player to the game
     *
     * @param player the player to be removed from the game
     */
    default void add(PlayerInterface player) {
        getPlayers().add(player);
    }

    String loserMessage = "____    ____  ______    __    __      __        ______        _______. _______ \n" +
            "\\   \\  /   / /  __  \\  |  |  |  |    |  |      /  __  \\      /       ||   ____|\n" +
            " \\   \\/   / |  |  |  | |  |  |  |    |  |     |  |  |  |    |   (----`|  |__   \n" +
            "  \\_    _/  |  |  |  | |  |  |  |    |  |     |  |  |  |     \\   \\    |   __|  \n" +
            "    |  |    |  `--'  | |  `--'  |    |  `----.|  `--'  | .----)   |   |  |____ \n" +
            "    |__|     \\______/   \\______/     |_______| \\______/  |_______/    |_______|\n";

    String winnerMessage = "____    ____  ______    __    __     ____    __    ____  __  .__   __. \n" +
            "\\   \\  /   / /  __  \\  |  |  |  |    \\   \\  /  \\  /   / |  | |  \\ |  | \n" +
            " \\   \\/   / |  |  |  | |  |  |  |     \\   \\/    \\/   /  |  | |   \\|  | \n" +
            "  \\_    _/  |  |  |  | |  |  |  |      \\            /   |  | |  . `  | \n" +
            "    |  |    |  `--'  | |  `--'  |       \\    /\\    /    |  | |  |\\   | \n" +
            "    |__|     \\______/   \\______/         \\__/  \\__/     |__| |__| \\__| \n";


    /**
     * removes a player from the game
     *
     * @param player the player to be removed from the game
     */
    default void remove(PlayerInterface player) {
        getPlayers().remove(player);
    }


    /**
     * specifies how the game will run
     */
    void run();

    String getInstructions();
}
