package com.fangdjupet.item.weapon;

import com.fangdjupet.common.Difficulty;
import com.fangdjupet.item.EquipableItemCategory;
import com.fangdjupet.item.ItemCategory;

public class Sword implements Weapon {
    private static final WeaponType type = WeaponType.SWORD;
    private static final int STRENGTH = 4;
    private static final EquipableItemCategory equipableItemCategory = EquipableItemCategory.WEAPON;
    private static final String ITEM_NAME = "Sword";
    private static final ItemCategory itemCategory = ItemCategory.EQUIPABLE;
    private static final Difficulty difficultyLevel = Difficulty.HARD;

    @Override
    public WeaponType getWeaponType() {
        return type;
    }

    @Override
    public int getWeaponStrength() {
        return STRENGTH;
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
