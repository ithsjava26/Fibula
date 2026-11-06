package com.fangdjupet.item.potion;

import com.fangdjupet.character.Hero;
import com.fangdjupet.common.Difficulty;
import com.fangdjupet.common.Effect;
import com.fangdjupet.item.ConsumableItemCategory;
import com.fangdjupet.item.ItemCategory;

public class LargeCutInjuryHealingPotion implements HealingPotion {
    private final HealingPotionType healingPotionType;
    private final Effect potionEffect;
    private final Effect healCondition;
    private final ConsumableItemCategory consumableItemCategory;
    private final String itemName;
    private final ItemCategory itemCategory;
    private final Difficulty itemDifficultyLevel;

    public LargeCutInjuryHealingPotion() {
        this.healingPotionType = HealingPotionType.LARGE_CUT_INJURY_HEALING_POTION;
        this.potionEffect = Effect.BLEEDING;
        this.healCondition = Effect.NEUTRAL;
        this.consumableItemCategory = ConsumableItemCategory.HEALING_POTION;
        this.itemName = "Large Cut Injury Healing Potion";
        this.itemCategory = ItemCategory.CONSUMABLE;
        this.itemDifficultyLevel = Difficulty.MEDIUM;
    }

    @Override
    public HealingPotionType getHealingPotionType() {
        return healingPotionType;
    }

    public Effect getPotionEffect() {
        return potionEffect;
    }

    @Override
    public void usePotion(Hero hero) {
        hero.setStatus(healCondition);
        IO.println("You drink the large cut healing potion and heal your cut injury. You now feel better.");
    }

    @Override
    public ConsumableItemCategory getConsumableItemCategory() {
        return consumableItemCategory;
    }

    @Override
    public String getItemName() {
        return itemName;
    }

    @Override
    public ItemCategory getItemCategory() {
        return itemCategory;
    }

    @Override
    public Difficulty getItemDifficultyLevel() {
        return itemDifficultyLevel;
    }
}
