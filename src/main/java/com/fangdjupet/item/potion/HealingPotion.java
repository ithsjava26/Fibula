package com.fangdjupet.item.potion;

import com.fangdjupet.character.Hero;
import com.fangdjupet.common.Effect;
import com.fangdjupet.item.ConsumableItem;
import com.fangdjupet.menu.GameMenu;

public interface HealingPotion extends ConsumableItem {
    GameMenu game = new GameMenu();

    HealingPotionType getHealingPotionType();

    Effect getPotionEffect();

    void setHealingAmount(int healingAmount);

    int getHealingAmount();

    void usePotion(Hero hero);

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