package com.fangdjupet.item;

public interface EquipableItem extends Item {
    EquipableItemCategory getEquipableItemCategory();

    void equip();

    void unequip();
}
