package com.fangdjupet.character;

import com.fangdjupet.combat.AttackStrategy;
import com.fangdjupet.combat.MeleeAttack;
import com.fangdjupet.common.Difficulty;
import com.fangdjupet.menu.GameMenu;

/**
 * Represents a medium enemy, which extends the Enemy class.
 * The medium enemy is an orc berserker, with a melee attack strategy (swings a sword). As such,
 * it overrides the attack method to implement the melee attack. This enemy has more health and higher damage
 * than an easy enemy. Additionally, this enemy's attack has an effect, Bleed, which deals passive damage over time
 * to the player.
 */

public class MediumEnemy extends Enemy {
    private final AttackStrategy meleeAttack;
    private final GameMenu game = new GameMenu();

    //Constructor
    public MediumEnemy() {
        super("Orc Berserker", 40, new MeleeAttack(), Difficulty.MEDIUM);
        this.meleeAttack = new MeleeAttack();
    }

    @Override
    public int attack() {
        game.printRed(
                getCharacterName() +
                        " swings " +
                        meleeAttack.getName()
        );
        return meleeAttack.attack();
    }

}
