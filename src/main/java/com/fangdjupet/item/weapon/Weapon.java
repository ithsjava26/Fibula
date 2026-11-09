package com.fangdjupet.item.weapon;

import com.fangdjupet.item.EquipableItem;

public interface Weapon extends EquipableItem {
    WeaponType getWeaponType();

    int getWeaponStrength();

    void setWeaponStrength(int strength);

    static Weapon createWeapon(WeaponType type) {
        return switch (type) {
            case AXE -> new Axe();
            case SWORD -> new Sword();
            case DAGGER -> new Dagger();
            case LONGBOW -> new Longbow();
        };
    }
}
