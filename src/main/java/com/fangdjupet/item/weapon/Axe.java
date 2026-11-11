package com.fangdjupet.item.weapon;

import com.fangdjupet.common.Difficulty;
import com.fangdjupet.item.EquipableItemCategory;
import com.fangdjupet.item.ItemCategory;

public class Axe implements Weapon {
    private final WeaponType weaponType;
    private int weaponStrength;
    private final EquipableItemCategory equipableItemCategory;
    private final String itemName;
    private final ItemCategory itemCategory;
    private final Difficulty difficultyLevel;

    public Axe() {
        this.weaponType = WeaponType.AXE;
        this.weaponStrength = 15;
        this.equipableItemCategory = EquipableItemCategory.WEAPON;
        this.itemName = "Axe";
        this.itemCategory = ItemCategory.EQUIPABLE;
        this.difficultyLevel = Difficulty.MEDIUM;
    }

    @Override
    public WeaponType getWeaponType() {
        return weaponType;
    }

    @Override
    public int getWeaponStrength() {
        return weaponStrength;
    }

    @Override
    public void setWeaponStrength(int strength) {
        this.weaponStrength = strength;
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
