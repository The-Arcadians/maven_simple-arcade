package com.github.curriculeon.arcade.slots;

import com.github.curriculeon.arcade.GameInterface;
import com.github.curriculeon.arcade.PlayerInterface;
import com.github.curriculeon.utils.AnsiColor;
import com.github.curriculeon.utils.IOConsole;

import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by leon on 7/21/2020.
 */
public class SlotsGame implements GameInterface {
    private final IOConsole logger = new IOConsole(AnsiColor.YELLOW);


    public final Character[] matrix;

    public SlotsGame() {
        this.matrix = new Character[3];

    }


    public Boolean slotMachine(Character slotMachine) {
        Character slot1Position = this.matrix[0];
        Character slot2Position = this.matrix[1];
        Character slot3Position = this.matrix[2];
        return null;
    }


    @Override
    public void add(PlayerInterface player) {

    }

    @Override
    public void remove(PlayerInterface player) {

    }


    @Override
    public void run() {

        String[][] demo = {
                {"0", "1", "2"}

        };

        String[][] userInterface = {
                {" ", " ", " "}
        };


        System.out.println("Welcome to the Slot Machine!");
        //want to input the players username in the message after "Good Luck"
        System.out.println("\nGame Start! You will begin with $50.00 " + "Good Luck!");
        int Balance = 50;
        int bet = 0, remainingBalance = 0, winnings1, winnings2;
        int min = 0;
        int max = 10;


        // need to be able to place a bet
        Scanner scanner = new Scanner(System.in);
        System.out.println("Place your bet $");
        bet = scanner.nextInt();


// Winning Solutions = 3 of the same numbers || 2 of the same number win half
        if (bet > 0 && bet < Balance) {
            Random randInt;
            randInt = new Random();
            int slot1Position;
            int slot2Position;
            int slot3Position;
            slot1Position = randInt.nextInt(10);
            slot2Position = randInt.nextInt(10);
            slot3Position = randInt.nextInt(10);


            System.out.println("slot1Position, slot2Position, slot3Position");


            if (slot1Position == slot2Position && slot2Position == slot3Position && slot3Position == slot1Position) {
                System.out.println("Jackpot!: ");
                winnings1 = (slot1Position + 1) * bet;
                remainingBalance = Balance - bet + winnings1;
            } else if (slot1Position == slot2Position || slot2Position == slot3Position) {
                System.out.println("You win!: ");
                ;
                winnings2 = (slot2Position * bet) / 2;
                remainingBalance = Balance - bet + winnings2;

            } else System.out.println("Balance ");

        }
        if (bet == 0) {
            System.out.println("You earned" + remainingBalance);

        }


    }


    @Override
    public String printInstructions() {
        return null;
    }
}
