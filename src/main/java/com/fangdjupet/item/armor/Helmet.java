package com.fangdjupet.item.armor;

import com.fangdjupet.common.Difficulty;
import com.fangdjupet.item.EquipableItemCategory;
import com.fangdjupet.item.ItemCategory;

public class Helmet implements Armor {
    private static final ArmorType type = ArmorType.HELMET;
    private static final int ARMOR_VALUE = 1;
    private static final EquipableItemCategory equipableItemCategory = EquipableItemCategory.ARMOR;
    private static final String ITEM_NAME = "Helmet";
    private static final ItemCategory itemCategory = ItemCategory.EQUIPABLE;
    private static final Difficulty difficultyLevel = Difficulty.EASY;

    @Override
    public ArmorType getArmorType() {
        return type;
    }

    @Override
    public int getArmorValue() {
        return ARMOR_VALUE;
    }

    @Override
    public EquipableItemCategory getEquipableItemCategory() {
        return equipableItemCategory;
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
