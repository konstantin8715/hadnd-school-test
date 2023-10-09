package org.example;

public abstract class Creature {
    private String name;
    private int attack;
    private int defense;
    private int currentHealth;
    private double maxHealth;
    private int countHeal = 4;
    private Damage damage;
    private Dice dice;

    public Creature(String name, int attack, int defense, int N, int M) {

        this.name = name;

        if (attack > 30) this.attack = 30;
        if (attack < 1) this.attack = 1;

        if (defense > 30) this.attack = 30;
        if (defense < 1) this.attack = 1;

        if (N < 0) N = 0;
        this.maxHealth = N;
        this.currentHealth = N;

        this.damage = new Damage(M, N);

        this.dice = new Dice();
    }

    public String getName() {
        return name;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public void heal() {
        if (countHeal > 0) this.currentHealth = (int) (this.maxHealth * 0.3);
        this.countHeal--;
        System.out.println(this.name + " heal");
    }

    private void takeDamage(int damage) {
        if (damage < 0) damage = 0;
        this.currentHealth = this.currentHealth - damage;
        if (this.currentHealth < 0) this.currentHealth = 0;
        System.out.println(this.name + " take damage " + damage + " , current health: " + this.currentHealth);
        if (this.currentHealth == 0) System.out.println(name + " is die");
    }

    public void punch(Creature creature) {
        if (creature.getCurrentHealth() == 0) {
            System.out.println(creature.getName() + " is died");
            return;
        }

        int attackModify = this.attack - creature.defense + 1;

        boolean success = false;
        int[] diceRolls = dice.rollTheDice(attackModify);
        for (int diceRoll : diceRolls) {
            if (diceRoll == 5 || diceRoll == 6) {
                success = true;
                break;
            }
        }

        if (success) {
            int damage = this.damage.getRandomDamage();
            creature.takeDamage(damage);
            System.out.println(this.name + " is damage " + creature.getName() + " with " + damage);
        }
        else {
            System.out.println("Punch by " + this.getName() + " is not success");
        }
    }
}
