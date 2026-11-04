package com.fangdjupet.combat;

import com.fangdjupet.common.Effect;

/**
 * Represents a magic attack strategy that deals 20 damage and has the additional effect of causing burning.
 * It is used by the HardEnemy class, Wraith Mage.
 */

public class MagicAttack implements AttackStrategy{

    @Override
    public int attack() {
        return 20;
    }

    @Override
    public String getName() {
        return "a fireball that deals 20 damage, Additional-effect: Burning!";
    }

    @Override
    public Effect getEffect() {
        return Effect.BURNING;
    }

}
