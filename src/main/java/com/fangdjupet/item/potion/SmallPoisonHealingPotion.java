package com.fangdjupet.item.potion;

import com.fangdjupet.character.Hero;
import com.fangdjupet.common.Difficulty;
import com.fangdjupet.item.ConsumableItemCategory;
import com.fangdjupet.item.ItemCategory;

public class SmallPoisonHealingPotion implements HealingPotion {
    private final HealingPotionType healingPotionType;
    private int healingAmount;
    private final ConsumableItemCategory consumableItemCategory;
    private final String itemName;
    private final ItemCategory itemCategory;
    private final Difficulty itemDifficultyLevel;

    public SmallPoisonHealingPotion() {
        this.healingPotionType = HealingPotionType.SMALL_POISON_HEALING_POTION;
        this.healingAmount = 5;
        this.consumableItemCategory = ConsumableItemCategory.HEALING_POTION;
        this.itemName = "Small Poison Healing Potion";
        this.itemCategory = ItemCategory.CONSUMABLE;
        this.itemDifficultyLevel = Difficulty.EASY;
    }

    @Override
    public HealingPotionType getHealingPotionType() {
        return healingPotionType;
    }

    @Override
    public void setHealingAmount(int healingAmount) {
        this.healingAmount = healingAmount;
    }

    @Override
    public void usePotion(Hero hero) {
        hero.setHealth(hero.getHealth() + healingAmount);
        IO.println("You have healed " + healingAmount + " HP.");
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
