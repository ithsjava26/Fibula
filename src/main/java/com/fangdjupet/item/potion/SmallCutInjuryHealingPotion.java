package com.fangdjupet.item.potion;

import com.fangdjupet.character.Hero;
import com.fangdjupet.common.Difficulty;
import com.fangdjupet.common.Effect;
import com.fangdjupet.item.ConsumableItemCategory;
import com.fangdjupet.item.ItemCategory;
import com.fangdjupet.menu.GameMenu;

public class SmallCutInjuryHealingPotion implements HealingPotion {
    private final HealingPotionType healingPotionType;
    private final Effect potionEffect;
    private final Effect healCondition;
    private int healingAmount;
    private final ConsumableItemCategory consumableItemCategory;
    private final String itemName;
    private final ItemCategory itemCategory;
    private final Difficulty itemDifficultyLevel;
    private final GameMenu game = new GameMenu();

    public SmallCutInjuryHealingPotion() {
        this.healingPotionType = HealingPotionType.SMALL_CUT_INJURY_HEALING_POTION;
        this.potionEffect = Effect.BLEEDING;
        this.healCondition = Effect.NEUTRAL;
        this.healingAmount = 25;
        this.consumableItemCategory = ConsumableItemCategory.HEALING_POTION;
        this.itemName = "Small Cut Injury Healing Potion";
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

    public void setHealingAmount(int healingAmount) {
        this.healingAmount = healingAmount;
    }

    @Override
    public int getHealingAmount() {
        return healingAmount;
    }

    @Override
    public void usePotion(Hero hero) {
        boolean matchingStatus = hero.getStatus() == getPotionEffect();
        if (matchingStatus) {
            hero.setStatus(healCondition);
        }
        game.printGreen("You drink the small cut injury healing potion and heal " + healingAmount + " HP.");
        hero.setHealth(hero.getCurrentHealth() + healingAmount);
        if (matchingStatus) {
            game.printGreen("You heal your cut injury. You now feel better.");
        } else {
            game.printYellow("You have no cut injury to heal.");
        }
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
