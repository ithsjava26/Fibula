package com.fangdjupet.item.potion;

import com.fangdjupet.character.Hero;
import com.fangdjupet.common.Difficulty;
import com.fangdjupet.common.Effect;
import com.fangdjupet.item.ConsumableItemCategory;
import com.fangdjupet.item.ItemCategory;

public class SmallBurnHealingPotion implements HealingPotion {
    private final HealingPotionType healingPotionType;
    private final Effect potionEffect;
    private int healingAmount;
    private final ConsumableItemCategory consumableItemCategory;
    private final String itemName;
    private final ItemCategory itemCategory;
    private final Difficulty itemDifficultyLevel;

    public SmallBurnHealingPotion() {
        this.healingPotionType = HealingPotionType.SMALL_BURN_HEALING_POTION;
        this.potionEffect = Effect.BURNING;
        this.healingAmount = 7;
        this.consumableItemCategory = ConsumableItemCategory.HEALING_POTION;
        this.itemName = "Small Burn Healing Potion";
        this.itemCategory = ItemCategory.CONSUMABLE;
        this.itemDifficultyLevel = Difficulty.EASY;
    }

    @Override
    public HealingPotionType getHealingPotionType() {
        return healingPotionType;
    }

    @Override
    public Effect getPotionEffect() {
        return potionEffect;
    }

    @Override
    public void setHealingAmount(int healingAmount) {
        this.healingAmount = healingAmount;
    }

    @Override
    public int getHealingAmount() {
        return healingAmount;
    }

    @Override
    public void usePotion(Hero hero) {
        hero.setHealth(hero.getCurrentHealth() + healingAmount);
        IO.println("You drink the small burn healing potion and heal " + healingAmount + " HP.");
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
