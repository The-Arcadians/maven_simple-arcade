package com.github.curriculeon.arcade;

/**
 * Created by leon on 7/21/2020.
 */
public interface GameInterface extends Runnable {
    /**
     * adds a player to the game
     *
     * @param player the player to be removed from the game
     */
    void add(PlayerInterface player);

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
    void remove(PlayerInterface player);


    /**
     * specifies how the game will run
     */
    void run();

    String printInstructions();
}
