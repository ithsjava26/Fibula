package com.fangdjupet.combat;

import com.fangdjupet.common.Effect;

/**
 * Represents a magic attack strategy that deals 35 damage and has no additional effect.
 * It is used by the FinalBossEnemy class, the Ancient Magical Dragon.
 */

public class MagicBossAttack implements AttackStrategy{

    @Override
    public int attack() {
        return 35;
    }

    @Override
    public String getName() {
        return "a dark explosion that deals 35 damage, with no additional effects.";
    }

    @Override
    public Effect getEffect() {
        return Effect.NEUTRAL;
    }

}
