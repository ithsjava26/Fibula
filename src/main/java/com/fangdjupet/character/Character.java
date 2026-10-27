package com.fangdjupet.character;

// Interface for a character in the game
public interface Character {
    String getName();
    int getHealth();
    void takeDamage(int damage);
    boolean isAlive();
}
