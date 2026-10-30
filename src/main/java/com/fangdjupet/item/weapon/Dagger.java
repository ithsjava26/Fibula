package com.fangdjupet.item.weapon;

import com.fangdjupet.common.Difficulty;

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
    public Difficulty getWeaponStrengthLevel() {
        return Difficulty.MEDIUM;
    }

    @Override
    public int getWeaponStrength() {
        return 3;
    }
}
