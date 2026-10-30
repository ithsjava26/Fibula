package com.fangdjupet.character;

import com.fangdjupet.combat.AttackStrategy;
import com.fangdjupet.common.Difficulty;

//Not complete
public class BossEnemy extends Enemy {
    private final String name;
    private int health;
    private final AttackStrategy attackStrategy;
    private final Difficulty difficulty;

    public BossEnemy(String name, int health, AttackStrategy attackStrategy, Difficulty difficulty) {
        super(name, health, attackStrategy, difficulty);
        this.name = name;
        this.health = health;
        this.attackStrategy = attackStrategy;
        this.difficulty = difficulty;
    }
}
