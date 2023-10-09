package org.example;

import java.util.Random;

public class Damage {
    private int minDamage;
    private int maxDamage;

    public Damage(int M, int N) {
        if (M < 0) M = 1;
        if (M > N) N = M + 1;
        this.minDamage = M;
        this.maxDamage = N;
    }

    public int getRandomDamage() {
        return new Random().nextInt(this.maxDamage - this.minDamage + 1) + this.minDamage;
    }
}
