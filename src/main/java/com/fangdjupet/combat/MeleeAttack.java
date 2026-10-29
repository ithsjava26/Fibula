package com.fangdjupet.combat;

public class MeleeAttack  implements AttackStrategy{
    @Override
    public int attack() {
        return 10;  //Melee attack damage, example damageAmount
    }
}
