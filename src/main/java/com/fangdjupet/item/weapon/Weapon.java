package com.fangdjupet.item.weapon;

import com.fangdjupet.item.EquipableItem;

public interface Weapon extends EquipableItem {
    WeaponType getWeaponType();

    int getWeaponStrength();

    static Weapon createWeapon(WeaponType type) {
        return switch (type) {
            case AXE -> new Axe();
            case SWORD -> new Sword();
            case DAGGER -> new Dagger();
            case CLUB -> new Club();
        };
    }
}
