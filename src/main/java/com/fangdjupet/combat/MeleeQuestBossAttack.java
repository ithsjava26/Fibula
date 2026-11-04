package com.fangdjupet.combat;

import com.fangdjupet.common.Effect;

/**
 * Represents a mêlée attack strategy that deals 20 damage and has the additional effect of causing poisoning.
 * It is used by the QuestBossEnemy class, the giant spider Ungoliath the black.
 */

public class MeleeQuestBossAttack implements AttackStrategy {

    @Override
    public int attack() {
        return 20;
    }

    @Override
    public String getName() {
        return "with it's massive venomous teeth that deals 20 damage, Additional-effect: Poisoning";
    }

    @Override
    public Effect getEffect() {
        return Effect.POISONED;
    }

}
