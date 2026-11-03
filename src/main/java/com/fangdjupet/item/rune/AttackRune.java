package com.fangdjupet.item.rune;

import com.fangdjupet.item.ConsumableItem;

public interface AttackRune extends ConsumableItem {
    AttackRuneType getAttackRuneType();

    int getAttackRuneStrength();

    static AttackRune createAttackRune(AttackRuneType type) {
        return switch (type) {
            case POISON_BOMB -> new PoisonBomb();
            case FIRE_BALL -> new FireBall();
            case STONE_SHOWER -> new StoneShower();
            case PARALYSE -> new Paralyse();
        };
    }
}
