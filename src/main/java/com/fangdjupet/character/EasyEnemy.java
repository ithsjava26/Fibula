package com.fangdjupet.character;

import com.fangdjupet.combat.AttackStrategy;
import com.fangdjupet.combat.RangedAttack;
import com.fangdjupet.common.Difficulty;

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