package com.fangdjupet.combat;

import com.fangdjupet.common.Effect;

/**
 * Represents a mêlée attack strategy that deals 15 damage and has the additional effect of causing bleeding.
 * It is used by the MediumEnemy class, Orc Berserker.
 */

public class MeleeAttack implements AttackStrategy{
    @Override
    public int attack() {
        return 15;
    }

    @Override
    public String getName() {
        return "a sword and slashes that deals 15 damage, Additional-effect: Bleeding" ;
    }

    @Override
    public Effect getEffect() {
        return Effect.BLEEDING;
    }
    
}
