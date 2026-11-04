package com.fangdjupet.character;

/**
 * This interface defines the basic methods that all characters in the game should implement.
 * It provides a common set of operations that can be performed on any character, such as getting the character's name,
 * health, taking damage, and checking if the character is alive.
 */

public interface Character {
    String getCharacterName();
    int getHealth();
    void takeDamage(int damage);
    boolean isAlive();
}
