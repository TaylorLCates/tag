package org.improving.tag;

import java.util.Random;

public class Dice {
    Random dice = new Random();

    public int getD4() {
        return d4;
    }

    public int d4 = dice.nextInt(4 + 1 - 1) + 1;

    public int d6 = dice.nextInt(6 + 1 - 1) + 1;

    public int d8 = dice.nextInt(8 + 1 - 1) + 1;

    public int d10 = dice.nextInt(10 + 1 - 1) + 1;

    public int d12 = dice.nextInt(12 + 1 - 1) + 1;

    public int d20 = dice.nextInt(20 + 1 - 1) + 1;




}

