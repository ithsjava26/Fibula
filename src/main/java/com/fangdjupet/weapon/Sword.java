package com.fangdjupet.weapon;

public class Sword implements Weapon {
    @Override
    public String getWeaponName() {
        return "Sword";
    }

    @Override
    public WeaponType getWeaponType() {
        return WeaponType.SWORD;
    }

    @Override
    public WeaponRange getWeaponRange() {
        return WeaponRange.MELEE;
    }

    @Override
    public StrengthLevel getWeaponStrengthLevel() {
        return StrengthLevel.HARD;
    }

    @Override
    public int getWeaponStrength() {
        return 4;
    }
}
