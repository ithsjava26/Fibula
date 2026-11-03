package com.fangdjupet.combat;

public class RangedAttack implements AttackStrategy{
    @Override
    public int attack() {
        return 8;
    }

    @Override
    public String getName() {
        return "a weak arrow that deals 8 damage";
    }

    @Override
    public String getEffect() {
        return "No additional effects";
    }
}
