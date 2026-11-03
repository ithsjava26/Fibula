package com.fangdjupet.combat;

public class MagicAttack implements AttackStrategy{
    @Override
    public int attack() {
        return 20;
    }

    @Override
    public String getName() {
        return "a spell that drains your life force with 20 damage";
    }

    @Override
    public String getEffect() {
        return "You are attacked by magic.";
    }
}
