package com.fangdjupet.combat;

public class MeleeQuestBossAttack implements AttackStrategy {

    @Override
    public int attack() {
        return 15;
    }

    @Override
    public String getName() {
        return "with it's massive teeth that deals 15 damage.";
    }

    @Override
    public String getEffect() {
        return "No additional effects";
    }
}
