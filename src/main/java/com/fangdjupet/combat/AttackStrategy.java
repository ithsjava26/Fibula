package com.fangdjupet.combat;

import com.fangdjupet.common.Effect;

/**
 * This interface defines methods for enemy attacks,
 * retrieving the name of the attack, and getting any additional effects of the attack.
 */

public interface AttackStrategy {
    int attack();
    String getName();
    Effect getEffect();
}
