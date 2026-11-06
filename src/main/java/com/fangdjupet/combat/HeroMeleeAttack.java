package com.fangdjupet.combat;

import com.fangdjupet.common.Effect;

/**
 * Represents the hero's mêlée attack strategy that deal dynamic damage depending on the equipped weapon.
 * Has the additional effect of causing bleeding.
 */

public class HeroMeleeAttack implements AttackStrategy {

    @Override
    public int attack() {
        return 10;
    }

    @Override
    public String getName() {
        return "You swing your sword, dealing " + attack() + " damage, Additional-effect: Enemy is bleeding!";
    }

    @Override
    public Effect getEffect() {
        return Effect.BLEEDING;
    }
}
