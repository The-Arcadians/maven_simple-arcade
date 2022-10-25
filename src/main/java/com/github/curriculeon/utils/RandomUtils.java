package com.github.curriculeon.utils;

import java.util.Random;


/**
 * Created by Leon on 2/4/2017.
 */

public final class RandomUtils {
    private static final Random random = new Random();

    /**
     * @return true with the likelihood of specified percentage
     */
    public static boolean chance(float percentage) {
        return percentage > createFloat(0, 100);
    }

    /**
     * @return a random float between the specified min and max numeric range
     */
    public static Float createFloat(float min, float max) {
        return random.nextFloat() * (max - min) + min;
    }

    /**
     * @return a random integer between the specified min and max numeric range
     */
    public static Integer createInteger(Integer min, Integer max) {
        return createFloat(min, max).intValue();
    }

    /**
     * @return a random element from the sepcified array
     */
    public static <E> E selectElement(E[] array) {
        return array[createInteger(0, array.length - 1)];
    }
}