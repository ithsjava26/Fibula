package com.fangdjupet.item;

public interface EquipableItem {
    EquipableItemCategory getEquipableItemType();

    void equip();
}
