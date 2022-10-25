package com.github.curriculeon.arcade.slots;

import com.github.curriculeon.arcade.AbstractGame;
import com.github.curriculeon.arcade.PlayerInterface;

import java.util.StringJoiner;

/**
 * Created by leon on 7/21/2020.
 */
public class SlotsGame extends AbstractGame {
    @Override
    public void run() {
        for (PlayerInterface player : getPlayers()) {
            SlotsReelImage image1 = null;
            SlotsReelImage image2 = null;
            SlotsReelImage image3 = null;
            String userInput;
            do {
                userInput = player.play(this);
                if ("pull-lever".equalsIgnoreCase(userInput)) {
                    image1 = SlotsReelImage.getRandom();
                    image2 = SlotsReelImage.getRandom();
                    image3 = SlotsReelImage.getRandom();
                } else if ("view-slots".equalsIgnoreCase(userInput)) {
                    special("|| %s || %s || %s ||", image1, image2, image3);
                } else if ("exit".equalsIgnoreCase(userInput)) {
                    break;
                }
            } while (!"exit".equalsIgnoreCase(userInput));
        }
    }

    @Override
    public String getInstructions() {
        return new StringJoiner("\n")
                .add("Enter [ pull-lever ] to pull the lever.")
                .add("Enter [ view-slots ] to view the slots.")
                .add("Enter [ exit ] to exit the game")
                .toString();
    }
}
