package com.github.curriculeon.arcade.numberguess;

import com.github.curriculeon.utils.IOConsole;

import java.util.InputMismatchException;
import java.util.Random;

public class NumberGuessEngine {
    IOConsole console = new IOConsole();
    private Random random = new Random();
    private Integer number;

    public void setRandom(Random random){
        this.random = random;
    }

    public Integer randomNumber() {
        this.number = random.nextInt(39) + 1;
        return this.number;
    }

    public void prompt(){
        console.println("Welcome to the Number Guess Game!");
        console.println("I have a number between 1-40. Guess correctly and you win! (Three chances)");

    }

    public void promptForGuess(){
        console.println("I have a number between 1-40. Guess correctly and you win! (Three chances)");
    }

    public void promptContinue(int input){
        console.getIntegerInput("Play again? enter (1)Yes or (2)No");
    }

    /**
     * This method generates a random wrong message. Credit to Brent
     */
    public void wrongMessageGen(){
        String[] wrongMessage = {
                "Strike one! Try again.",
                "Not quite. Maybe this will help: ",
                "Wrong answer. here's a hint for your next try: ",
                "No, but we have more chances.",
                "Incorrect. Try again."
        };

        Random rand = new Random();
        int randomMsg = rand.nextInt(wrongMessage.length);
        System.out.println(wrongMessage[randomMsg]);
    }

    public void finalWrongMessageGen(){
        String[] wrongMessage = {
                "Strike two! One more and you're O U T!",
                "Still off. I got one more hint for your last guess.",
                "Eeh...lets narrow it down some more for our final chance.",
                "No no no. And we're on the last guess...",
                "Incorrect. Last try."
        };

        Random rand = new Random();
        int randomMsg = rand.nextInt(wrongMessage.length);
        System.out.println(wrongMessage[randomMsg]);
    }

    int getInput() {
        while(true){

            try {
                int input = console.getIntegerInput("\nEnter your guess below:");
                if(input >= 0)
                {
                    return input;
                }
                throw new IllegalArgumentException("Number can't be negative");
            } catch (IllegalArgumentException e){
                console.println("\"" + console.getIntegerInput("\" isn't a positive number!"));
            } catch (InputMismatchException e){
                console.println("\"" + console.getIntegerInput("\" isn't a number!"));
            }
        }
    }


}
