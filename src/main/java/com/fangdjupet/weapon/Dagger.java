package com.fangdjupet.weapon;

public class Dagger implements Weapon {
    @Override
    public String getWeaponName() {
        return "Dagger";
    }

    @Override
    public WeaponType getWeaponType() {
        return WeaponType.DAGGER;
    }

    @Override
    public WeaponRange getWeaponRange() {
        return WeaponRange.DISTANCE;
    }

    @Override
    public StrengthLevel getWeaponStrengthLevel() {
        return StrengthLevel.MEDIUM;
    }

    @Override
    public int getWeaponStrength() {
        return 3;
    }
}
