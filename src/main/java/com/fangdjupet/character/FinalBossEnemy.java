package com.fangdjupet.character;

import com.fangdjupet.combat.*;
import com.fangdjupet.common.Difficulty;

/**
 * Represents the final boss enemy in the game, which extends the Enemy class.
 * The final boss is a powerful and formidable opponent, capable of dealing significant damage to the player.
 * The final boss possesses a variety of attack strategies, including melee, ranged, and magical attacks.
 * The attacks are chosen based on the BossEnemy's current health, increasing in damage the lower the health,
 * giving the final battle different phases that scale in difficulty.
 */

public class FinalBossEnemy extends Enemy {
    private final AttackStrategy meleeAttack;
    private final AttackStrategy rangedAttack;
    private final AttackStrategy magicAttack;

    public FinalBossEnemy() {
        super("Ancient Magical Dragon", 150, new MeleeBossAttack(), Difficulty.HARD);
        this.meleeAttack = new MeleeBossAttack();
        this.rangedAttack = new RangedBossAttack();
        this.magicAttack = new MagicBossAttack();
    }

    @Override
    public int attack() {

        if(getHealth() < 50) {
            super.attackStrategy = magicAttack;
            System.out.println(
                    getCharacterName() +
                            " conjures " +
                            magicAttack.getName()
            );
            return magicAttack.attack();
        }

        if(getHealth() < 100) {
            super.attackStrategy = rangedAttack;
            System.out.println(
                    getCharacterName() +
                            " creates " +
                            rangedAttack.getName()
            );
            return rangedAttack.attack();
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
