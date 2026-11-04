package com.fangdjupet.combat;

import com.fangdjupet.common.Effect;

/**
 * Represents a mêlée attack strategy that deals 20 damage and has the additional effect of causing bleeding.
 * It is used by the FinalBossEnemy class, the Ancient Magical Dragon.
 */

public class MeleeBossAttack implements AttackStrategy {

    @Override
    public int attack() {
        return 20;
    }

    @Override
    public String getName() {
        return "his massive claws that deals 20 damage, Additional-effect: Bleeding!";
    }

    @Override
    public Effect getEffect() {
        return Effect.BLEEDING;
    }

}
