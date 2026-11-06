package com.fangdjupet.character;

import com.fangdjupet.combat.AttackStrategy;
import com.fangdjupet.combat.HeroMagicAttack;
import com.fangdjupet.combat.HeroMeleeAttack;
import com.fangdjupet.common.Effect;
import com.fangdjupet.item.Item;
import java.util.List;

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
    private AttackStrategy meleeAttack;
    private AttackStrategy magicAttack;
    private Effect status;
    private List<Item> inventory;

    //Overloaded constructor
    public Hero(String name, int health) {
        this.name = name;
        this.health = health;
        this.meleeAttack = new HeroMeleeAttack();
        this.magicAttack = new HeroMagicAttack();
        this.status = Effect.NEUTRAL;
    }

    //Constructor with inventory
    public Hero(List<Item> inventory) {
        this.name = "Arthur LightBringer, Palladin Knight";
        this.health = 100;
        this.meleeAttack = new HeroMeleeAttack();
        this.magicAttack = new HeroMagicAttack();
        this.inventory = inventory;
        this.status = Effect.NEUTRAL;
    }

    //Default constructor
    public Hero() {
        this.name = "Arthur LightBringer, Palladin Knight";
        this.health = 100;
        this.meleeAttack = new HeroMeleeAttack();
        this.magicAttack = new HeroMagicAttack();
        this.status = Effect.NEUTRAL;
    }

    public int meleeAttack() {
        System.out.println(meleeAttack.getName());
        return meleeAttack.attack();
    }

    public int magicAttack() {
        System.out.println(magicAttack.getName());
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

}
