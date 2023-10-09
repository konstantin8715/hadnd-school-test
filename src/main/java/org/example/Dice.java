package org.example;

import java.util.Random;

public class Dice {
//    private int countOfDice;
//
//    public Dice(int countOfDice) {
//        this.countOfDice = countOfDice;
//    }

    public int[] rollTheDice(int attackModify) {
        Random random = new Random();
        int[] results = new int[attackModify];

        for (int i = 0; i < results.length; i++) {
            results[i] = random.nextInt(6) + 1;
        }

        return results;
    }
}
