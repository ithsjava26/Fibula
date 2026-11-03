package com.fangdjupet.character;

import com.fangdjupet.combat.AttackStrategy;

public class Hero implements Character {

    private final String name;
    private int health;
    private final AttackStrategy attackStrategy;

    //Constructor
    public Hero(String name, int health, AttackStrategy attackStrategy) {
        this.name = name;
        this.health = health;
        this.attackStrategy = attackStrategy;
    }

    public int attack() {
        return attackStrategy.attack();
    }

    @Override
    public String getCharacterName() {
        return name;
    }

    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public void takeDamage(int damage) {
        health -= damage;
        if (health < 0) {
            health = 0;
        }
    }

    @Override
    public boolean isAlive() {
        return health > 0;
    }

}
