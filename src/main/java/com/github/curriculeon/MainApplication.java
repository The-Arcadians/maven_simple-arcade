package com.github.curriculeon;

import com.github.curriculeon.arcade.ArcadeAccount;
import com.github.curriculeon.arcade.GameInterface;
import com.github.curriculeon.arcade.PlayerInterface;
import com.github.curriculeon.arcade.tictactoe.TicTacToe;
import com.github.curriculeon.arcade.tictactoe.TicTacToePlayer;

public class MainApplication {
    public static void main(String[] args) {
//        ArcadeAccount arcadeAccount = new ArcadeAccount(null, null);
//        PlayerInterface player = new TicTacToePlayer(arcadeAccount);
//        GameInterface game = new TicTacToe();
//        game.add(player);
//        game.run();
        new Arcade().run();

    }

}
