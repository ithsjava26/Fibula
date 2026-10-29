package com.fangdjupet.combat;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CombatTest {

    @Test
    void magicAttackShouldDeal15Damage() {
        //Arrange
        AttackStrategy strategy = new MagicAttack();
        //Act
        int result = strategy.attack();
        //Assert
        assertEquals(15, result);
    }

    @Test
    void meleeAttackShouldDeal10Damage() {
        //Arrange
        AttackStrategy strategy = new MeleeAttack();
        //Act
        int result = strategy.attack();
        //Assert
        assertEquals(10, result);
    }

    @Test
    void rangedAttackShouldDeal8Damage() {
        //Arrange
        AttackStrategy strategy = new RangedAttack();
        //Act
        int result = strategy.attack();
        //Assert
        assertEquals(8, result);
    }

}