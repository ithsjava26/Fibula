package com.fangdjupet.item.weapon;

import com.fangdjupet.common.Difficulty;

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
    public Difficulty getWeaponStrengthLevel() {
        return Difficulty.HARD;
    }

    @Override
    public int getWeaponStrength() {
        return 4;
    }
}
