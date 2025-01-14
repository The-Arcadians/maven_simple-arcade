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

    public String[] firstWrongMessage = new String[]{"Strike one! Try again.",
            "Wrong answer. here's a hint for your next try.",
            "Not quite. Maybe this will help.",
            "No, but we have more chances.",
            "Incorrect. Try again."};
    public String[] secondWrongMessage = new String[]{"Strike two! One more and you're O U T!",
            "Still off. I got one more hint for your last guess.",
            "Eeh...lets narrow it down some more for our final chance.",
            "No no no. And we're on the last guess...",
            "Incorrect. Last try."};

    private Random random = new Random();
    private IOConsole console = new IOConsole(AnsiColor.AUTO);
    private IOConsole wrongAnswerConsole = new IOConsole(AnsiColor.RED);

    @Override
    public void add(PlayerInterface player) {}

    @Override
    public void remove(PlayerInterface player) {}

    @Override
    public void run() {
        Integer randomNumber = random.nextInt(39) + 1;
        Integer playerGuessOne = 0;
        Integer playerGuessTwo = 0;
        Integer playerGuessThree = 0;
        Integer randomResponseNumber = random.nextInt(5);

        System.out.println(randomNumber); // Remove on completion, shows the answer.

        console.println("Welcome to the Number Guess Game!");
        console.println("I have a number between 1-40. Guess correctly and you win! (Three chances)");

        //Ask player to guess random number.
        playerGuessOne = console.getIntegerInput("\nEnter your guess below:");
        //if it's the right number they win yay!
        if (playerGuessOne.equals(randomNumber)) {
            console.println(randomNumber + "!" + " You got it!");
            console.println(GameInterface.winnerMessage);

        }
        if (!playerGuessOne.equals(randomNumber)) {
            //Give player hint 1

            wrongAnswerConsole.println("\n" + firstWrongMessage[randomResponseNumber]);


            if (randomNumber <= 20) {
                playerGuessTwo = console.getIntegerInput("\nHint: The number is somewhere between 1-20");
            }
            if (randomNumber > 20) {
                playerGuessTwo = console.getIntegerInput("\nHint: The number is somewhere between 21-40");
            }


            if (playerGuessTwo.equals(randomNumber)) {
                console.println("\n" + randomNumber + "!" + " You got it!");
                console.println(GameInterface.winnerMessage);
            }


            if (!playerGuessTwo.equals(randomNumber)) {


                wrongAnswerConsole.println("\n" + secondWrongMessage[randomResponseNumber]);


                //Get guess 3, giving a hint to make it easier.
                if (randomNumber <= 10) {
                    playerGuessThree = console.getIntegerInput("\nHint: The number is somewhere between 1-10");
                }
                if (randomNumber > 10 && randomNumber <= 20) {
                    playerGuessThree = console.getIntegerInput("\nHint: The number is somewhere between 11-20");
                }
                if (randomNumber > 20 && randomNumber <= 30) {
                    playerGuessThree = console.getIntegerInput("\nHint: The number is somewhere between 21-30");
                }
                if (randomNumber > 30 && randomNumber <= 40) {
                    playerGuessThree = console.getIntegerInput("\nHint: The number is somewhere between 31-40");
                }


                if (playerGuessThree.equals(randomNumber)) {
                    console.println("\n" + randomNumber + "!" + " You got it!");
                    console.println(GameInterface.winnerMessage);
                }
                if (!playerGuessThree.equals(randomNumber)) {
                    wrongAnswerConsole.println("\nSorry, you lose ");
                    wrongAnswerConsole.println(GameInterface.loserMessage);
                }

            }

        }
    }

    @Override
    public String printInstructions() {
        return null;
    }
}