package com.fangdjupet.item.rune;

import com.fangdjupet.common.Difficulty;
import com.fangdjupet.item.ConsumableItemCategory;
import com.fangdjupet.item.ItemCategory;

public class PoisonBomb implements AttackRune {
    private static final AttackRuneType type = AttackRuneType.POISON_BOMB;
    private static final int ATTACK_RUNE_STRENGTH = 15;
    private static final ConsumableItemCategory consumableItemCategory = ConsumableItemCategory.ATTACK_RUNE;
    private static final String ITEM_NAME = "Poison bomb rune";
    private static final ItemCategory itemCategory = ItemCategory.CONSUMABLE;
    private static final Difficulty difficultyLevel = Difficulty.HARD;

    @Override
    public AttackRuneType getAttackRuneType() {
        return type;
    }

    @Override
    public int getAttackRuneStrength() {
        return ATTACK_RUNE_STRENGTH;
    }

    @Override
    public ConsumableItemCategory getConsumableItemCategory() {
        return consumableItemCategory;
    }

    @Override
    public String getItemName() {
        return ITEM_NAME;
    }

    @Override
    public ItemCategory getItemCategory() {
        return itemCategory;
    }

    @Override
    public Difficulty getItemDifficultyLevel() {
        return difficultyLevel;
    }
}
