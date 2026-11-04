package com.fangdjupet.character;

import com.fangdjupet.combat.AttackStrategy;
import com.fangdjupet.combat.RangedAttack;
import com.fangdjupet.common.Difficulty;

/**
 * Represents an easy enemy, which extends the Enemy class.
 * The easy enemy is a goblin, with a ranged attack strategy (shooting arrows). As such,
 * it overrides the attack method to implement the ranged attack.
 */

public class EasyEnemy extends Enemy {
    private final AttackStrategy rangedAttack;

    //Constructor
    public EasyEnemy() {
        super("Goblin", 20, new RangedAttack(), Difficulty.EASY);
        this.rangedAttack = new RangedAttack();
    }

    @Override
    public int attack() {
        System.out.println(
                getCharacterName() +
                        " shoots " +
                        rangedAttack.getName()
        );
        return rangedAttack.attack();
    }

}