package com.fangdjupet.item.weapon;

import com.fangdjupet.common.Difficulty;
import com.fangdjupet.item.EquipableItemCategory;
import com.fangdjupet.item.ItemCategory;

public class Dagger implements Weapon {
    private static final WeaponType type = WeaponType.DAGGER;
    private static final int STRENGTH = 3;
    private static final EquipableItemCategory equipableItemCategory = EquipableItemCategory.WEAPON;
    private static final String ITEM_NAME = "Dagger";
    private static final ItemCategory itemCategory = ItemCategory.EQUIPABLE;
    private static final Difficulty difficultyLevel = Difficulty.MEDIUM;

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
