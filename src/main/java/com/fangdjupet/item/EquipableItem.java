package com.fangdjupet.item;

public interface EquipableItem extends Item {
    EquipableItemCategory getEquipableItemType();

    void equip();
}
