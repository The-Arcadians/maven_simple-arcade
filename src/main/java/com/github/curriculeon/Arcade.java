package com.github.curriculeon;

import com.github.curriculeon.arcade.ArcadeAccount;
import com.github.curriculeon.arcade.ArcadeAccountManager;
import com.github.curriculeon.arcade.GameInterface;
import com.github.curriculeon.arcade.PlayerInterface;
import com.github.curriculeon.arcade.numberguess.NumberGuessGame;
import com.github.curriculeon.arcade.numberguess.NumberGuessPlayer;
import com.github.curriculeon.arcade.slots.SlotsGame;
import com.github.curriculeon.arcade.slots.SlotsPlayer;
import com.github.curriculeon.arcade.tictactoe.TicTacToe;
import com.github.curriculeon.arcade.tictactoe.TicTacToePlayer;
import com.github.curriculeon.utils.AnsiColor;
import com.github.curriculeon.utils.IOConsole;

import java.io.IOException;
import java.util.HashSet;

/**
 * Created by leon on 7/21/2020.
 */
public class Arcade implements Runnable {
    private final IOConsole console = new IOConsole(AnsiColor.BLUE);

    @Override
    public void run() {
        String arcadeDashBoardInput;
        ArcadeAccountManager arcadeAccountManager = null;
        HashSet<ArcadeAccount> loggedInAccounts = new HashSet<>();
        try {
            arcadeAccountManager = new ArcadeAccountManager();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        do {
            arcadeDashBoardInput = getArcadeDashboardInput();
            if ("select-game".equals(arcadeDashBoardInput)) {
                String accountName = console.getStringInput("Enter your account name:");
                String accountPassword = console.getStringInput("Enter your account password:");
                ArcadeAccount arcadeAccount = arcadeAccountManager.getAccount(accountName, accountPassword);
                boolean isValidLogin = arcadeAccount != null;
                if (isValidLogin) {
                    String gameSelectionInput = getGameSelectionInput().toUpperCase();
                    if (gameSelectionInput.equals("SLOTS")) {
                        play(new SlotsGame(), new SlotsPlayer());
                    } else if (gameSelectionInput.equals("NUMBER GUESS")) {
                        play(new NumberGuessGame(), new NumberGuessPlayer());
                    } else if (gameSelectionInput.equals("TIC TAC TOE")) {
                        play(new TicTacToe(), new TicTacToePlayer());
                    } else {
                        // TODO - implement better exception handling
                        String errorMessage = "[ %s ] is an invalid game selection";
                        throw new RuntimeException(String.format(errorMessage, gameSelectionInput));
                    }
                } else {
                    // TODO - implement better exception handling
                    String errorMessage = "No account found with name of [ %s ] and password of [ %s ]";
                    throw new RuntimeException(String.format(errorMessage, accountPassword, accountName));
                }
            } else if ("create-account".equals(arcadeDashBoardInput)) {
                console.println("Welcome to the account-creation screen.");
                String accountName = console.getStringInput("Enter your account name:");
                String accountPassword = console.getStringInput("Enter your account password:");
                if (arcadeAccountManager.getAccountUsernames().contains(accountName)){
                    System.out.println("This username already exists" + "\n");
                } else {
                    arcadeAccountManager.createAccount(accountName, accountPassword);
                    try {
                        arcadeAccountManager.updateAccounts();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        } while (!"logout".equals(arcadeDashBoardInput));
    }

    private String getArcadeDashboardInput() {
        return console.getStringInput(new StringBuilder()
                .append("Welcome to the Arcade Dashboard!")
                .append("\nFrom here, you can select any of the following options:")
                .append("\n\t[ create-account ], [ select-game ]")
                .toString());
    }

    private String getGameSelectionInput() {
        return console.getStringInput(new StringBuilder()
                .append("Welcome to the Game Selection Dashboard!")
                .append("\nFrom here, you can select any of the following options:")
                .append("\n\t[ SLOTS ], [ NUMBER GUESS ], [ TIC TAC TOE ]")
                .toString());
    }

    private void play(Object gameObject, Object playerObject) {
        GameInterface game = (GameInterface)gameObject;
        PlayerInterface player = (PlayerInterface)playerObject;
        game.add(player);
        game.run();
    }
}
