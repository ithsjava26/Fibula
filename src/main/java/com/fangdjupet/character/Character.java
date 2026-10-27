package com.fangdjupet.character;


public interface Character {
    String getName();
    int getHealth();
    void takeDamage(int damage);
    boolean isAlive();
}
