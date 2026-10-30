package com.fangdjupet.item.weapon;

import com.fangdjupet.common.Difficulty;

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
    public Difficulty getWeaponStrengthLevel() {
        return Difficulty.EASY;
    }

    @Override
    public int getWeaponStrength() {
        return 2;
    }
}
