package com.fangdjupet.weapon;

import com.fangdjupet.common.Difficulty;

public interface Weapon {
    String getWeaponName();
    WeaponType getWeaponType();
    WeaponRange getWeaponRange();

    Difficulty getWeaponStrengthLevel();
    int getWeaponStrength();
    static Weapon createWeapon(WeaponType type) {
        return switch (type) {
            case AXE -> new Axe();
            case SWORD -> new Sword();
            case DAGGER -> new Dagger();
        };
    }
}
