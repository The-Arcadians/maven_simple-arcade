package com.github.curriculeon.arcade.slots;

import com.github.curriculeon.arcade.AbstractPlayer;
import com.github.curriculeon.arcade.ArcadeAccount;
import com.github.curriculeon.arcade.PlayerInterface;

/**
 * Created by leon on 7/21/2020.
 */
public class SlotsPlayer extends AbstractPlayer {
    public SlotsPlayer(ArcadeAccount arcadeAccount) {
        super(arcadeAccount);
    }

    @Override
    public <SomeReturnType, SomeArgumentType> SomeReturnType play(SomeArgumentType argumentType) {
        return null;
    }
}