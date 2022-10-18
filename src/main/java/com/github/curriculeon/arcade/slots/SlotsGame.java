package com.github.curriculeon.arcade.slots;

import com.github.curriculeon.arcade.ArcadeAccount;
import com.github.curriculeon.arcade.GameInterface;
import com.github.curriculeon.arcade.PlayerInterface;
import com.github.curriculeon.utils.AnsiColor;
import com.github.curriculeon.utils.IOConsole;

/**
 * Created by leon on 7/21/2020.
 */
public class SlotsGame implements GameInterface {
    private final IOConsole logger = new IOConsole(AnsiColor.YELLOW);

    @Override
    public void add(PlayerInterface player) {

    }

    @Override
    public void remove(PlayerInterface player) {

    }

    @Override
    public void run() {
        System.out.println("Welcome to the Slot Machine!");
        //want to input the players username in the message after "Good Luck"
        System.out.println("\nGame Start! You will begin with $50.00" + "Good Luck!");
        // spin
        //Generate a random sequence using the following "Apple","Apple","Apple", "Orange","Orange","Orange"
        // "Grapes","Grapes","Grapes", "Cherry","Cherry","Cherry", "banana","banana","banana",
        // "Kiwi","Kiwi","Kiwi"
        // Created multiples to up the odds

        // Winning Solutions = 3 consecutive fruit objects



    }

    @Override
    public String printInstructions() {
        return null;
    }
}
