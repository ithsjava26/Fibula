package com.fangdjupet.weapon;

public class Axe implements Weapon {
    @Override
    public String getWeaponName() {
        return "Axe";
    }

    @Override
    public WeaponType getWeaponType() {
        return WeaponType.AXE;
    }

    @Override
    public WeaponRange getWeaponRange() {
        return WeaponRange.MELEE;
    }

    @Override
    public StrengthLevel getWeaponStrengthLevel() {
        return StrengthLevel.EASY;
    }

    @Override
    public int getWeaponStrength() {
        return 2;
    }
}
