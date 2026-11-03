package com.fangdjupet.character;

import com.fangdjupet.combat.AttackStrategy;
import com.fangdjupet.combat.MagicAttack;
import com.fangdjupet.common.Difficulty;

public class HardEnemy extends Enemy {
    private final AttackStrategy magicAttack;

    public HardEnemy() {
        super("Wraith Mage", 60, new MagicAttack(), Difficulty.HARD);
        this.magicAttack = new MagicAttack();
    }

    @Override
    public int attack() {
        System.out.println(
                getCharacterName() +
                        " casts " +
                        magicAttack.getName()
        );
        return magicAttack.attack();
    }

}
