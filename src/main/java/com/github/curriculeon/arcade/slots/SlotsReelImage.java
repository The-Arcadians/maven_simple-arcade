package com.github.curriculeon.arcade.slots;

import com.github.curriculeon.utils.RandomUtils;

public enum SlotsReelImage {
    CHERRY(500),
    ORANGE(500),
    WATERMELON(500),
    LEMON(500),
    BAR(500),
    DOUBLEBAR(1000),
    TRIPLEBAR(2000),
    LUCKYSEVEN(5000);

    private final int value;

    SlotsReelImage(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        return name();
    }

    static SlotsReelImage getRandom() {
        return RandomUtils.selectElement(values());
    }
}