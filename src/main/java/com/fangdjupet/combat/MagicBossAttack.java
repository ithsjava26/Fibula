package com.fangdjupet.combat;

public class MagicBossAttack implements AttackStrategy{

    @Override
    public int attack() {
        return 35;
    }

    @Override
    public String getName() {
        return "a dark explosion that deals 35 damage.";
    }

    @Override
    public String getEffect() {
        return "The final boss is engulfed in darkness and enraged.";
    }
}
