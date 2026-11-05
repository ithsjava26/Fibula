package com.fangdjupet.combat;

import com.fangdjupet.common.Effect;

/**
 * Represents the hero's magic attack strategy that deal dynamic damage depending on the equipped rune.
 * Has the additional effect of causing burning.
 */

public class HeroMagicAttack implements AttackStrategy {

    @Override
    public int attack() {
        return 10;
    }

    @Override
    public String getName() {
        return "You cast a fireball, dealing " + attack() + " damage, Additional-effect: Enemy is burning!";
    }

    @Override
    public Effect getEffect() {
        return Effect.BURNING;
    }

}
