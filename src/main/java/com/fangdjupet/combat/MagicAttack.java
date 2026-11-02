package com.fangdjupet.combat;

public class MagicAttack implements AttackStrategy{
    @Override
    public int attack() {
        return 15;
    }

    @Override
    public String getName() {
        return "a Magic Attack that deals 15 damage";
    }

    @Override
    public String getEffect() {
        return "You are attacked by magic.";
    }
}
