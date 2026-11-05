package com.fangdjupet.item.potion;

public interface HealingPotion {
    int usePotion();

    static HealingPotion createHealingPotion(HealingPotionType type) {
        return switch (type) {
            case SMALL_CUT_INJURY_HEALING_POTION -> new SmallCutInjuryHealingPotion();
            case LARGE_CUT_INJURY_HEALING_POTION -> new LargeCutInjuryHealingPotion();
            case SMALL_BURN_HEALING_POTION -> new SmallBurnHealingPotion();
            case LARGE_BURN_HEALING_POTION -> new LargeBurnHealingPotion();
            case SMALL_POISON_HEALING_POTION -> new SmallPoisonHealingPotion();
            case LARGE_POISON_HEALING_POTION -> new LargePoisonHealingPotion();
        };
    }
}
