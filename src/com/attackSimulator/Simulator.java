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
        System.out.println(damage);
        this.totalAttack = this.damage + attackMod;

        switch(damage) {
            case 1:
                this.isCriticalMiss = true;
                System.out.println("special negative");
                break;
            case 20:
                this.isCriticalHit = true;
                System.out.println("Critical hit");
                rollDie();
                break;
            default:
                if(totalAttack > (armourClass + defenseMod)) {
                    String[] attackDice = damageDice.split("d");
                    System.out.println(Arrays.toString(attackDice));
                    int sidesOfDie = Integer.parseInt(attackDice[0]);
                    int amountOfRolls = Integer.parseInt(attackDice[1]);
                    System.out.println(sidesOfDie);
                    for(int i = 0; i < amountOfRolls; i++) {
                        Die myDie = new Die(sidesOfDie);
                        totalDamage =+ myDie.roll();
                    }
               //Die twentyDie = new Die(sidesOfDie);
            }
        }
        return totalDamage;
    }

    public int rollDie() {
        return this.twentyDie.roll();
    }

    public int getDamage() {
        return damage;
    }

}
// trying to understand problem. Reading Instructions
