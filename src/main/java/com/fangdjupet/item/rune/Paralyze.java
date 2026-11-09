package com.fangdjupet.item.rune;

import com.fangdjupet.character.Enemy;
import com.fangdjupet.common.Difficulty;
import com.fangdjupet.item.ConsumableItemCategory;
import com.fangdjupet.item.ItemCategory;
import com.fangdjupet.menu.GameMenu;

public class Paralyze implements AttackRune {
    GameMenu game = new GameMenu();

    private final AttackRuneType attackRuneType;
    private int attackRuneStrength;
    private final ConsumableItemCategory consumableItemCategory;
    private final String itemName;
    private final ItemCategory itemCategory;
    private final Difficulty difficultyLevel;

    public Paralyze() {
        this.attackRuneType = AttackRuneType.PARALYZE;
        this.attackRuneStrength = 5;
        this.consumableItemCategory = ConsumableItemCategory.ATTACK_RUNE;
        this.itemName = "Paralyze rune";
        this.itemCategory = ItemCategory.CONSUMABLE;
        this.difficultyLevel = Difficulty.QUEST;
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
        game.printRed("You use the " + itemName + ". Suddenly the enemy becomes completely paralyzed, " +
                "unable to attack on the next move, and also dealing " + attackRuneStrength + " damage!");
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
