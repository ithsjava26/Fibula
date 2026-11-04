package com.fangdjupet.character;

import com.fangdjupet.combat.AttackStrategy;
import com.fangdjupet.common.Difficulty;

/**
 * Represents an enemy character in the game that implements the character interface. Is used as a Super class
 * for other types of enemy characters, depending on difficulty, designed to provide a foundation for creating various enemy types.
 * Polymorphism allows different enemy types to be created and used interchangeably in the same list,
 * enabling flexibility and extensibility in the game's combat system.
 */

public class Enemy implements Character {
    private final String name;
    private int health;
    private final AttackStrategy attackStrategy;
    private final Difficulty difficulty;

    //Constructor
    public Enemy(String name, int health, AttackStrategy attackStrategy, Difficulty difficulty) {
        this.name = name;
        this.health = health;
        this.attackStrategy = attackStrategy;
        this.difficulty = difficulty;
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

    public Difficulty getDifficulty() {
        return difficulty;
    }

}
