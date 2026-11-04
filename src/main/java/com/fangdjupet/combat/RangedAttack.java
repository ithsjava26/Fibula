package com.fangdjupet.combat;

import com.fangdjupet.common.Effect;

/**
 * Represents a ranged attack strategy that deals 8 damage and has no additional effects.
 * It is used by the EasyEnemy class, Goblin.
 */

public class RangedAttack implements AttackStrategy{
    @Override
    public int attack() {
        return 8;
    }

    @Override
    public String getName() {
        return "a weak arrow that deals 8 damage, with no additional effects.";
    }

    @Override
    public Effect getEffect() {
        return Effect.NEUTRAL;
    }

}
