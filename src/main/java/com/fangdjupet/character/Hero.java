package com.fangdjupet.character;

import com.fangdjupet.common.Effect;
import com.fangdjupet.inventory.Inventory;
import com.fangdjupet.item.Item;
import com.fangdjupet.item.armor.Armor;
import com.fangdjupet.item.weapon.Weapon;
import com.fangdjupet.item.weapon.WeaponType;
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
    private Effect status;
    private final Inventory inventory;
    private final GameMenu game = new GameMenu();
    private final int baseMaxHealth;

    //Overloaded constructor. Alt: To set another hero name and health.
    public Hero(String name, int health) {
        this.name = name;
        this.health = health;
        this.baseMaxHealth = health;
        this.status = Effect.NEUTRAL;
        this.inventory = new Inventory();
    }

    //Default constructor
    public Hero() {
        this.name = "Arthur LightBringer";
        this.health = 100;
        this.baseMaxHealth = 100;
        this.status = Effect.NEUTRAL;
        this.inventory = new Inventory();
    }

    public int attack() {
        Weapon weapon = getEquippedWeapon();

        if (weapon == null) {
            game.printGreen("No weapon equipped, you punch the enemy with fists dealing 5 damage");
            return 5;
        }

        WeaponType weaponType = weapon.getWeaponType();
        switch (weaponType) {
            case SWORD, AXE -> game.printGreen("You swing your " + weapon.getItemName() + ", dealing " + weapon.getWeaponStrength() + " damage");
            case DAGGER -> game.printGreen("You throw your " + weapon.getItemName() + ", dealing " + weapon.getWeaponStrength() + " damage");
            case LONGBOW -> game.printGreen("You shoot your " + weapon.getItemName() + ", dealing " + weapon.getWeaponStrength() + " damage");
        }
        return weapon.getWeaponStrength();
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

    public void setHealth(int newHealth) {
        if(newHealth > getMaxHealth()) {
            newHealth = getMaxHealth();
            game.printGreen("You have regained your maximum health");
        }
        this.health = newHealth;
        game.printGreen("Your health is now: " + health + "/" + getMaxHealth() + " HP");
    }

    public int getMaxHealth() {
        int maxHealth = baseMaxHealth;

        for(Item item : inventory.getCurrentlyEquipped()) {

            if(item instanceof Armor armor) {

                maxHealth += armor.getArmorStrength();
            }
        }
        return maxHealth;
    }

    public void validateHealth() {
        if(health > getMaxHealth()) {
            health = getMaxHealth();
        }
        game.printGreen("Your maximum health is now " + getMaxHealth() + " HP");
    }

    public Weapon getEquippedWeapon() {
        for(Item item : inventory.getCurrentlyEquipped()) {
            if(item instanceof Weapon weapon) {
                return weapon;
            }
        }
        return null;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public String getDescription() {
        return """
                
                A new adventure is beginning!
                You play as Arthur LightBringer, a palladin knight who wields mighty weapons and magical runes.
                He is known for his unwavering bravery and commitment to vanquishing evil! Your quest is to
                go deep into the dungeon fibula, defeat everyone on your path and finally defeat the evil dragon
                Malakai the Dread to win the game!
                Good luck on your journey! May the light be with you!
                """;
    }

}
