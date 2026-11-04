package com.fangdjupet.combat;

import com.fangdjupet.common.Effect;

/**
 * Represents a ranged attack strategy that deals 30 damage and has the additional effect of causing burning.
 * It is used by the FinalBossEnemy class, the Ancient Magical Dragon.
 */

public class RangedBossAttack implements AttackStrategy {

    @Override
    public int attack() {
        return 30;
    }

    @Override
    public String getName() {
        return "a swirling fire tornado that deals 30 damage, Additional-effect: Burning!";
    }

    @Override
    public Effect getEffect() {
        return Effect.BURNING;
    }

}
