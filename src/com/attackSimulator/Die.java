package com.attackSimulator;

import java.util.Random;

public class Die {

    private static int value;
    private int sides;
    private Random random = new Random();

    public Die()
    {
        sides = 6;
        value =  1;
    }

    public Die(int sides, int value) {
        this.sides = sides;
        this.value = value;
    }

    public Die(int sidesOfDie) {
        this.sides = sidesOfDie;
    }

    public int roll()
    {
        this.value = this.random.nextInt(sides) + 1;
        return value;
    }

    public int getNumSides() {
        return sides;
    }

    public static int getValue() {
        return value;
    }
}

