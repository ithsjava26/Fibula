package com.fangdjupet.weapon;

public interface Weapon {
    String getWeaponName();

    WeaponType getWeaponType();

    WeaponRange getWeaponRange();

    StrengthLevel getWeaponStrengthLevel();

    int getWeaponStrength();

    static Weapon createWeapon(WeaponType type) {
        return switch (type) {
            case AXE -> new Axe();
            case SWORD -> new Sword();
            case DAGGER -> new Dagger();
        };
    }
}
