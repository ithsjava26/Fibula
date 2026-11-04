package com.fangdjupet.character;

import com.fangdjupet.combat.AttackStrategy;
import com.fangdjupet.common.Difficulty;
import com.fangdjupet.common.Effect;

/**
 * Represents an enemy character in the game that implements the character interface. Is used as a Super class
 * for different types of enemies, depending on difficulty, designed to provide a foundation for creating various enemy types.
 * Polymorphism allows different enemy types (Easy, Medium, Hard) to be created and used interchangeably in the same list,
 * enabling flexibility and extensibility in the game's combat system. All the enemies that extend this class are designed
 * to have a name, health, attack strategy, and difficulty level. The corresponding values are set in each type's constructor
 * without the need for inparameters. This makes it easier to create and manage different enemy types throughout the game.
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

    public Effect getEffect() {
        return attackStrategy.getEffect();
    }

}
