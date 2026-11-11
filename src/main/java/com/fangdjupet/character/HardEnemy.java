package com.fangdjupet.character;

import com.fangdjupet.combat.AttackStrategy;
import com.fangdjupet.combat.MagicAttack;
import com.fangdjupet.common.Difficulty;
import com.fangdjupet.menu.GameMenu;

/**
 * Represents a hard enemy, which extends the Enemy class.
 * The hard enemy is a Wraith Mage, with a magic attack strategy (casts a fireball). As such,
 * it overrides the attack method to implement the magic attack. This enemy has the most damage and health
 * of all the non-boss enemies. Additionally, this enemy's attack has an effect, Burning, which deals passive damage over time
 * to the player.
 */

public class HardEnemy extends Enemy {
    private final AttackStrategy magicAttack;
    private final GameMenu game = new GameMenu();

    public HardEnemy() {
        super("Wraith Mage", 60, new MagicAttack(), Difficulty.HARD);
        this.magicAttack = new MagicAttack();
    }

    @Override
    public int attack() {
        game.printRed(
                getCharacterName() +
                        " casts " +
                        magicAttack.getName()
        );
        return magicAttack.attack();
    }

}
