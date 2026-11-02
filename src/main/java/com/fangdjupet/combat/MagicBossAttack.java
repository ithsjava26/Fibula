package com.fangdjupet.combat;

public class MagicBossAttack implements AttackStrategy{

    @Override
    public int attack() {
        return 30;
    }

    @Override
    public String getName() {
        return "a dark explosion that deals 30 damage.";
    }

    @Override
    public String getEffect() {
        return "The enemy is engulfed in darkness.";
    }
}
