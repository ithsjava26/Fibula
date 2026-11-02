package com.fangdjupet.combat;

public class MeleeAttack implements AttackStrategy{
    @Override
    public int attack() {
        return 12;
    }

    @Override
    public String getName() {
        return "a sword and slashes that deals 12 damage  ";
    }

    @Override
    public String getEffect() {
        return "No additional effects";
    }
}
