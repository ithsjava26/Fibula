package com.fangdjupet.combat;

public class RangedQuestBossAttack implements AttackStrategy{

    @Override
    public int attack() {
        return 25;
    }

    @Override
    public String getName() {
        return "a venomous web in you're face that deals 25 damage.";
    }

    @Override
    public String getEffect() {
        return "Venomous effect";
    }
}
