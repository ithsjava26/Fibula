package com.fangdjupet.combat;

public class RangedBossAttack implements AttackStrategy {

    @Override
    public int attack() {
        return 20;
    }

    @Override
    public String getName() {
        return "a powerful fireball that deals 20 damage.!";
    }

    @Override
    public String getEffect() {
        return "You are engulfed in flames.";
    }
}
