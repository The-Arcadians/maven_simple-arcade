package com.github.curriculeon.arcade.slots;

import com.github.curriculeon.arcade.GameInterface;
import com.github.curriculeon.arcade.PlayerInterface;
import com.github.curriculeon.utils.AnsiColor;
import com.github.curriculeon.utils.IOConsole;

import java.util.*;

/**
 * Created by leon on 7/21/2020.
 */
public class SlotsGame implements GameInterface {
    private final IOConsole logger = new IOConsole(AnsiColor.YELLOW);


    @Override
    public List<PlayerInterface> getPlayers() {
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
        class SlotMachine {
            private int numberOfReels;
            private int selectionPerReel;
            private int costPerReel;


            //Constructor
            public SlotMachine(int numberOfReels, int selectionPerReel, int costPerReel) {
                this.numberOfReels = numberOfReels;
                this.selectionPerReel = selectionPerReel;
                this.costPerReel = costPerReel;
                System.out.println(toString());

            }

            private int[] getSpinResults() {
                int[] spinResults = new int[this.numberOfReels];
                for (int i = 0; i < spinResults.length; i++) {
                    // random number
                    //give a number less than 1 and * by factor of 10 to get int
                    int spinResult = (int) (Math.floor(Math.random() * 10) % this.selectionPerReel);

                }
                return spinResults;
            }


            public String toString() {
                StringBuffer result = new StringBuffer();
                result.append("Welcome to SlotArcade!\n");
                result.append("Number of Reels: " + this.numberOfReels + "\n");
                result.append("Selections Per Reel: " + this.selectionPerReel + "\n");
                result.append("Cost Per Pay Line: " + this.costPerReel * this.numberOfReels + "\n");


                return result.toString();
            }

            public void main(String[] args) {
                //number of reels 3
                //selections per reel
                //cost (x * reel) * (# of pay lines)
                //variable view box 3
                SlotMachine s1 = new SlotMachine(3, 10, 1);
                //Arrays.toString to see what's inside an array
                System.out.println(Arrays.toString(s1.getSpinResults()));
            }



        }


    }


    @Override
    public String getInstructions() {
        return null;
    }
}
