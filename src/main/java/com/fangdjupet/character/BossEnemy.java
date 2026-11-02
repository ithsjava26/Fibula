package com.fangdjupet.character;

import com.fangdjupet.combat.*;
import com.fangdjupet.common.Difficulty;


public class BossEnemy extends Enemy {
    private final AttackStrategy meleeAttack;
    private final AttackStrategy rangedAttack;
    private final AttackStrategy magicAttack;

    public BossEnemy() {
        super("Ancient Magical Dragon", 150, new MeleeBossAttack(), Difficulty.HARD);
        this.meleeAttack = new MeleeBossAttack();
        this.rangedAttack = new RangedBossAttack();
        this.magicAttack = new MagicBossAttack();
    }

    @Override
    public int attack() {

        if(getHealth() < 100) {
            System.out.println(
                    getCharacterName() +
                            " throws " +
                            rangedAttack.getName()
            );
            return rangedAttack.attack();
        }

        if(getHealth() < 50) {
            System.out.println(
                    getCharacterName() +
                            " conjures " +
                            magicAttack.getName()
            );
            return magicAttack.attack();
        }

        else {
            System.out.println(
                    getCharacterName() +
                            " swings " +
                            meleeAttack.getName()
            );
            return meleeAttack.attack();
        }
    }
}
