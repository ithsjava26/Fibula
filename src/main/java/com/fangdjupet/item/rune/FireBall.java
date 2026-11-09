package com.fangdjupet.item.rune;

import com.fangdjupet.character.Enemy;
import com.fangdjupet.common.Difficulty;
import com.fangdjupet.item.ConsumableItemCategory;
import com.fangdjupet.item.ItemCategory;
import com.fangdjupet.menu.GameMenu;

public class FireBall implements AttackRune {
    GameMenu game = new GameMenu();

    private final AttackRuneType attackRuneType;
    private int attackRuneStrength;
    private final ConsumableItemCategory consumableItemCategory;
    private final String itemName;
    private final ItemCategory itemCategory;
    private final Difficulty difficultyLevel;

    public FireBall() {
        this.attackRuneType = AttackRuneType.FIRE_BALL;
        this.attackRuneStrength = 10;
        this.consumableItemCategory = ConsumableItemCategory.ATTACK_RUNE;
        this.itemName = "Fire ball rune";
        this.itemCategory = ItemCategory.CONSUMABLE;
        this.difficultyLevel = Difficulty.EASY;
    }

    @Override
    public AttackRuneType getAttackRuneType() {
        return attackRuneType;
    }

    @Override
    public int getAttackRuneStrength() {
        return attackRuneStrength;
    }

    @Override
    public void setAttackRuneStrength(int attackRuneStrength) {
        this.attackRuneStrength = attackRuneStrength;
    }

    @Override
    public void useAttackRune(Enemy enemy) {
        enemy.takeDamage(attackRuneStrength);
        game.printRed("You use the " + itemName + ", dealing " + attackRuneStrength + " damage!");
    }

    @Override
    public ConsumableItemCategory getConsumableItemCategory() {
        return consumableItemCategory;
    }

    @Override
    public String getItemName() {
        return itemName;
    }

    @Override
    public ItemCategory getItemCategory() {
        return itemCategory;
    }

    @Override
    public Difficulty getItemDifficultyLevel() {
        return difficultyLevel;
    }
}
