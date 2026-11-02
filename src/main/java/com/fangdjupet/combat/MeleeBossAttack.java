package com.fangdjupet.combat;

public class MeleeBossAttack implements AttackStrategy {

    @Override
    public int attack() {
        return 10;
    }

    @Override
    public String getName() {
        return "a ice sword to slash that deals 10 damage!";
    }

    @Override
    public String getEffect() {
        return "No extra effect.";
    }

}
