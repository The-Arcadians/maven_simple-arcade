package com.github.curriculeon.arcade.numberguess;

import com.github.curriculeon.arcade.GameInterface;
import com.github.curriculeon.arcade.PlayerInterface;
import com.github.curriculeon.utils.AnsiColor;
import com.github.curriculeon.utils.IOConsole;

import java.util.Random;

/**
 * Created by leon on 7/21/2020.
 */
public class NumberGuessGame implements GameInterface {

    private Random random = new Random();

    private IOConsole console = new IOConsole(AnsiColor.GREEN);

    @Override
    public void add(PlayerInterface player) {

    }

    @Override
    public void remove(PlayerInterface player) {

    }

    @Override
    public void run() {
        System.out.println("Welcome to the Number Guess Game!");
        System.out.println("I have a number between 1-20. Guess correctly and you win! (Two chances)");

        //Make random number for the objective
        Integer randomNumber = 0;
        randomNumber = random.nextInt(20);
        System.out.println(randomNumber); // Remove on completion, shows the answer.

        //Ask player to guess random number.
        Integer playerGuessOne = console.getIntegerInput("Enter your guess.");
        //if it's the right number they win yay!
        if (playerGuessOne.equals(randomNumber)) {
            console.println(randomNumber + " You got it!");
            console.println("____    ____  ______    __    __     ____    __    ____  __  .__   __. \n" +
                    "\\   \\  /   / /  __  \\  |  |  |  |    \\   \\  /  \\  /   / |  | |  \\ |  | \n" +
                    " \\   \\/   / |  |  |  | |  |  |  |     \\   \\/    \\/   /  |  | |   \\|  | \n" +
                    "  \\_    _/  |  |  |  | |  |  |  |      \\            /   |  | |  . `  | \n" +
                    "    |  |    |  `--'  | |  `--'  |       \\    /\\    /    |  | |  |\\   | \n" +
                    "    |__|     \\______/   \\______/         \\__/  \\__/     |__| |__| \\__| \n");

        }
        if (!playerGuessOne.equals(randomNumber)) {
            Integer playerGuessTwo = console.getIntegerInput("Not quite! Try again!");
            if (playerGuessTwo.equals(randomNumber)) {
                console.println(randomNumber + " You got it!");
            } else {
                console.println("Sorry, you lose ");
                console.println("____    ____  ______    __    __      __        ______        _______. _______ \n" +
                        "\\   \\  /   / /  __  \\  |  |  |  |    |  |      /  __  \\      /       ||   ____|\n" +
                        " \\   \\/   / |  |  |  | |  |  |  |    |  |     |  |  |  |    |   (----`|  |__   \n" +
                        "  \\_    _/  |  |  |  | |  |  |  |    |  |     |  |  |  |     \\   \\    |   __|  \n" +
                        "    |  |    |  `--'  | |  `--'  |    |  `----.|  `--'  | .----)   |   |  |____ \n" +
                        "    |__|     \\______/   \\______/     |_______| \\______/  |_______/    |_______|\n");
            }
        }
    }

    @Override
    public String printInstructions() {
        return null;
    }
}