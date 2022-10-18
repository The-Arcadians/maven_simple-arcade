package com.github.curriculeon.arcade.numberguess;

import com.github.curriculeon.utils.AnsiColor;
import com.github.curriculeon.utils.IOConsole;

import java.util.Random;

/**
 * Created by leon on 7/21/2020.
 */
public class NumberGuessGame implements Runnable {

    private Random random = new Random();

    private IOConsole console = new IOConsole(AnsiColor.GREEN);

@Override
    public void run() {
        System.out.println("running game!");

        //Make random number for the objective
        Integer randomNumber = 0;
        randomNumber = random.nextInt(20);
        System.out.println(randomNumber);

        //Ask player to guess random number.
        Integer playerGuessOne = console.getIntegerInput("Guess the number between 1-20 (Two chances!)");
        //if it's the right number they win yay!
        if (playerGuessOne.equals(randomNumber)){
            console.println(randomNumber + " You got it!");
        } if (!playerGuessOne.equals(randomNumber)){
            Integer playerGuessTwo = console.getIntegerInput("Not quite! Try again!");
            if(playerGuessTwo.equals(randomNumber)){
                console.println(randomNumber + " You got it!");
            } else{console.println("Sorry, you lose");
        }
    }
}
    }