package com.fangdjupet.combat;

public class MagicBossAttack implements AttackStrategy{

    @Override
    public int attack() {
        return 30;
    }

    @Override
    public String getName() {
        return "Dark explosion";
    }
}
