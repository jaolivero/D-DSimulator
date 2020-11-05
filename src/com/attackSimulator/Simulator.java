package com.attackSimulator;
import java.util.Arrays;

public class Simulator {
    private boolean isCriticalHit;
    private boolean isCriticalMiss = false;
    private int totalDamage;
    private int totalAttack;
    private int damage;
    private Die twentyDie = new Die( 20, 1);

    public Simulator() {
        this.isCriticalHit = false;
        this.isCriticalMiss = false;
        this.totalDamage = 0;
        this.totalAttack = 0;
        this.damage = 0;
    }

    public int  attack(int armourClass, int attackMod, int defenseMod, String damageDice) {
        damage = rollDie();
        this.totalAttack = this.damage + attackMod;

        switch(damage) {
            case 1:
                this.isCriticalMiss = true;
                System.out.println("special negative");
                System.out.println("Critical Miss!");
                System.out.println("Miss 0 damage");
                break;
            case 20:
                this.isCriticalHit = true;
                System.out.println("Critical hit");
                printDamage();
                rollDie();
                break;
            default:
                printDamage();
        }

        totalDamage += damage;

        if(totalAttack > (armourClass + defenseMod)) {
            String[] attackDice = damageDice.split("d");
            int sidesOfDie = Integer.parseInt(attackDice[0]);
            int amountOfRolls = Integer.parseInt(attackDice[1]);
            for(int i = 0; i < amountOfRolls; i++) {
                Die myDie = new Die(sidesOfDie);
                totalDamage =+ myDie.roll();
            }
        }
        return totalDamage;
    }

    private void printDamage() {
        System.out.println("Hit " + damage + " damage dealt");
    }

    public int rollDie() {
        return this.twentyDie.roll();
    }

    public int getDamage() {
        return damage;
    }

}
// trying to understand problem. Reading Instructions
