package com.fangdjupet.character;

import com.fangdjupet.combat.*;
import com.fangdjupet.common.Difficulty;
import com.fangdjupet.menu.GameMenu;

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
    private final GameMenu game = new GameMenu();

    public FinalBossEnemy() {
        super("Ancient Dragon, Malakai the Dread", 200, new MeleeBossAttack(), Difficulty.HARD);
        this.meleeAttack = new MeleeBossAttack();
        this.rangedAttack = new RangedBossAttack();
        this.magicAttack = new MagicBossAttack();
    }

    @Override
    public int attack() {

        if(getCurrentHealth() < 70) {
            super.attackStrategy = magicAttack;
            game.printRed(
                    getCharacterName() +
                            " conjures " +
                            magicAttack.getName()
            );
            return magicAttack.attack();
        }

        if(getCurrentHealth() < 100) {
            super.attackStrategy = rangedAttack;
            game.printRed(
                    getCharacterName() +
                            " creates " +
                            rangedAttack.getName()
            );
            return rangedAttack.attack();
        }

        else {
            game.printRed(
                    getCharacterName() +
                            " swings " +
                            meleeAttack.getName()
            );
            return meleeAttack.attack();
        }
    }

}
