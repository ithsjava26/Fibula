package com.fangdjupet.character;

import com.fangdjupet.combat.*;
import com.fangdjupet.common.Difficulty;

/**
 * Represents the quest boss enemy, at the end of the sidequest portion of the game (extends the Enemy class).
 * The quest boss is more powerful than a normal enemy. It's a giant spider, named Ungoliath the Black.
 * She possesses 2 attack strategies, melee (Biting) and a ranged attack (Spitting venomous web).
 * The attacks are chosen based on the QuestBossEnemy's current health, increasing in damage the lower the health,
 * giving the battle 2 phases that scale in difficulty.
 */

public class QuestBossEnemy extends Enemy {
        private final AttackStrategy meleeAttack;
        private final AttackStrategy rangedAttack;

        public QuestBossEnemy() {
            super("Giant spider, Ungoliath the Black", 100, new MeleeQuestBossAttack(), Difficulty.QUEST);
            this.meleeAttack = new MeleeQuestBossAttack();
            this.rangedAttack = new RangedQuestBossAttack();
        }

        @Override
        public int attack() {

            if(getCurrentHealth() < 50) {
                super.attackStrategy = rangedAttack;
                System.out.println(
                        getCharacterName() +
                                " spits " +
                                rangedAttack.getName()
                );
                return rangedAttack.attack();
            }

            else {
                System.out.println(
                        getCharacterName() +
                                " bites " +
                                meleeAttack.getName()
                );
                return meleeAttack.attack();
            }
        }

}
