package com.fangdjupet.character;

import com.fangdjupet.combat.AttackStrategy;
import com.fangdjupet.combat.MeleeAttack;
import com.fangdjupet.common.Difficulty;

public class MediumEnemy extends Enemy {
    private final AttackStrategy meleeAttack;

    //Constructor
    public MediumEnemy() {
        super("Orc Berserker", 40, new MeleeAttack(), Difficulty.MEDIUM);
        this.meleeAttack = new MeleeAttack();
    }

    @Override
    public int attack() {
        System.out.println(
                getCharacterName() +
                        " swings " +
                        meleeAttack.getName()
        );
        return meleeAttack.attack();
    }

}
