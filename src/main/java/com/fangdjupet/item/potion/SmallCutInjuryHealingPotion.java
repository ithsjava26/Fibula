package com.fangdjupet.item.potion;

import com.fangdjupet.character.Hero;
import com.fangdjupet.common.Difficulty;
import com.fangdjupet.item.ConsumableItemCategory;
import com.fangdjupet.item.ItemCategory;

public class SmallCutInjuryHealingPotion implements HealingPotion {
    private int healingAmount;
    private final ConsumableItemCategory consumableItemCategory;
    private final String itemName;
    private final ItemCategory itemCategory;
    private final Difficulty itemDifficultyLevel;

    public SmallCutInjuryHealingPotion() {
        this.healingAmount = 5;
        this.consumableItemCategory = ConsumableItemCategory.HEALING_POTION;
        this.itemName = "Small Cut Injury Healing Potion";
        this.itemCategory = ItemCategory.CONSUMABLE;
        this.itemDifficultyLevel = Difficulty.EASY;
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
