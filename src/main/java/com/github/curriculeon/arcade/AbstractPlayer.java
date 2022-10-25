package com.github.curriculeon.arcade;

abstract public class AbstractPlayer implements PlayerInterface {
    private ArcadeAccount arcadeAccount;

    public AbstractPlayer(ArcadeAccount arcadeAccount) {
        this.arcadeAccount = arcadeAccount;
    }

    @Override
    public ArcadeAccount getArcadeAccount() {
        return this.arcadeAccount;
    }

    abstract public <SomeReturnType, SomeArgumentType> SomeReturnType play(SomeArgumentType argumentType);
}
