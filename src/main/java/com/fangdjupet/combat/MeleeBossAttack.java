package com.fangdjupet.combat;

public class MeleeBossAttack implements AttackStrategy {

    @Override
    public int attack() {
        return 15;
    }

    @Override
    public String getName() {
        return "his massive claws that deals 15 damage!";
    }

    @Override
    public String getEffect() {
        return "No extra effect.";
    }

}
