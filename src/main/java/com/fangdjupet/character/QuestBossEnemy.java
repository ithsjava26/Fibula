package com.fangdjupet.character;

import com.fangdjupet.combat.*;
import com.fangdjupet.common.Difficulty;

public class QuestBossEnemy extends Enemy {
        private final AttackStrategy meleeAttack;
        private final AttackStrategy rangedAttack;

        public QuestBossEnemy() {
            super("Giant spider, Ungoliath the black", 100, new MeleeQuestBossAttack(), Difficulty.QUEST);
            this.meleeAttack = new MeleeQuestBossAttack();
            this.rangedAttack = new RangedQuestBossAttack();
        }

        @Override
        public int attack() {

            if(getHealth() < 50) {
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
