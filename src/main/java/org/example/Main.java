package org.example;

public class Main {
    public static void main(String[] args) {
        Creature creature1 = new Monster("Monster1", 15, 10, 30, 14);
        Creature creature2 = new Player("Player1", 25, 20, 30, 14);

        creature2.punch(creature1);
        creature2.punch(creature1);
        creature2.punch(creature1);
        creature1.heal();
        creature1.punch(creature2);
        creature1.punch(creature2);
        creature2.heal();
        creature2.punch(creature1);
    }
}