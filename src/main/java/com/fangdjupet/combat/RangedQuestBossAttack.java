package com.fangdjupet.combat;

import com.fangdjupet.common.Effect;

/**
 * Represents a ranged attack strategy that deals 30 damage and has the additional effect of causing poisoning.
 * It is used by the QuestBossEnemy class, the giant spider Ungoliath the black.
 */

public class RangedQuestBossAttack implements AttackStrategy{

    @Override
    public int attack() {
        return 30;
    }

    @Override
    public String getName() {
        return "a venomous web in you're face that deals 30 damage, Additional-effect: Poisoning!";
    }

    @Override
    public Effect getEffect() {
        return Effect.POISONED;
    }

}
