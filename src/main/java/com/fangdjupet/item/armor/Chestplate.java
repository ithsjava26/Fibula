package com.fangdjupet.item.armor;

import com.fangdjupet.common.Difficulty;
import com.fangdjupet.item.EquipableItemCategory;
import com.fangdjupet.item.ItemCategory;

public class Chestplate implements Armor {
    private final ArmorType armorType;
    private int armorStrength;
    private final EquipableItemCategory equipableItemCategory;
    private final String itemName;
    private final ItemCategory itemCategory;
    private final Difficulty difficultyLevel;

    public Chestplate() {
        this.armorType = ArmorType.CHESTPLATE;
        this.armorStrength = 50;
        this.equipableItemCategory = EquipableItemCategory.ARMOR;
        this.itemName = "Chestplate";
        this.itemCategory = ItemCategory.EQUIPABLE;
        this.difficultyLevel = Difficulty.MEDIUM;
    }

    @Override
    public ArmorType getArmorType() {
        return armorType;
    }

    @Override
    public int getArmorStrength() {
        return armorStrength;
    }

    @Override
    public void setArmorStrength(int armorStrength) {
        this.armorStrength = armorStrength;
    }

    @Override
    public EquipableItemCategory getEquipableItemCategory() {
        return equipableItemCategory;
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
        return difficultyLevel;
    }
}
