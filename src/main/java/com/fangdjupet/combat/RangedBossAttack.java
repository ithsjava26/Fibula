package com.fangdjupet.combat;

public class RangedBossAttack implements AttackStrategy {

    @Override
    public int attack() {
        return 25;
    }

    @Override
    public String getName() {
        return "a powerful fireball that deals 25 damage.!";
    }

    @Override
    public String getEffect() {
        return "You are engulfed in flames.";
    }
}
