package com.fangdjupet.item.armor;

import com.fangdjupet.item.EquipableItem;

public interface Armor extends EquipableItem {
    ArmorType getArmorType();

    int getArmorStrength();

    void setArmorStrength(int armorStrength);

    static Armor createArmor(ArmorType type) {
        return switch (type) {
            case HELMET -> new Helmet();
            case CHESTPLATE -> new Chestplate();
        };
    }
}
