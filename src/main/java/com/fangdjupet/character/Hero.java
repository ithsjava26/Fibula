package com.fangdjupet.character;

import com.fangdjupet.combat.AttackStrategy;
import com.fangdjupet.combat.HeroMagicAttack;
import com.fangdjupet.combat.HeroMeleeAttack;
import com.fangdjupet.common.Effect;
import com.fangdjupet.inventory.Inventory;
import com.fangdjupet.menu.GameMenu;

/**
 * Represents a hero in the game that implements the character interface. It does not have a superclass, like
 * how enemies do, since the hero is unique and does not inherit from a common superclass. The hero's parameters are
 * determined by the default constructor (empty inparameters). But it can also be created with the overloaded constructor
 * that allows for customization of the hero's name, health, and attack strategy. Otherwise, the hero's name is
 * Arthur LightBringer, a brave palladin knight on a quest to save the realm from darkness and defeat the evil dragon Malakai.
 * He wields a mighty sword, capable of powerful mêlée attacks and has throwable daggers and armor for defense.
 * Being a palladin, he is also capable of using holy spells and runes, and can heal himself with potions.
 */

public class Hero implements Character {
    private final String name;
    private int health;
    private final AttackStrategy meleeAttack;
    private final AttackStrategy magicAttack;
    private Effect status;
    private final Inventory inventory;
    private final GameMenu game = new GameMenu();

    //Overloaded constructor. Alt: To set another hero name and health.
    public Hero(String name, int health) {
        this.name = name;
        this.health = health;
        this.meleeAttack = new HeroMeleeAttack();
        this.magicAttack = new HeroMagicAttack();
        this.status = Effect.NEUTRAL;
        this.inventory = new Inventory();
    }

    //Default constructor
    public Hero() {
        this.name = "Arthur LightBringer";
        this.health = 100;
        this.meleeAttack = new HeroMeleeAttack();
        this.magicAttack = new HeroMagicAttack();
        this.status = Effect.NEUTRAL;
        this.inventory = new Inventory();
    }

    public int meleeAttack() {
        game.printGreen(meleeAttack.getName());
        return meleeAttack.attack();
    }

    public int magicAttack() {
        game.printGreen(magicAttack.getName());
        return magicAttack.attack();
    }

    @Override
    public String getCharacterName() {
        return name;
    }

    @Override
    public int getCurrentHealth() {
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

    public void setStatus(Effect effect) {
        this.status = effect;
    }

    public Effect getStatus() {
        return status;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public String getDescription() {
        return "Arthur LightBringer, a palladin knight who wields mighty weapons and magical runes." +
                "He is known for his unwavering bravery and commitment to vanquishing evil!";
    }

}
