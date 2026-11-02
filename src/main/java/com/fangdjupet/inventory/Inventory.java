package com.fangdjupet.inventory;

import com.fangdjupet.common.Difficulty;
import com.fangdjupet.item.Item;
import com.fangdjupet.item.armor.Armor;
import com.fangdjupet.item.armor.ArmorType;
import com.fangdjupet.item.rune.AttackRune;
import com.fangdjupet.item.rune.AttackRuneType;
import com.fangdjupet.item.weapon.Weapon;
import com.fangdjupet.item.weapon.WeaponType;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private final List<Item> backpack = new ArrayList<>();
    private final List<Item> currentlyEquipped = new ArrayList<>();
    private final List<Item> enemyItems = new ArrayList<>();

    public void initializeHeroBackpack() {
        backpack.add(Weapon.createWeapon(WeaponType.CLUB));
    }

    public List<Item> getEnemyItems(Difficulty level) {
        if (level == Difficulty.EASY) {
            enemyItems.add(Weapon.createWeapon(WeaponType.CLUB));
            enemyItems.add(getRandomEasyItem());

        }
        return enemyItems;
    }

    private Item getRandomEasyItem() {
        Item item = null;
        int randomNumber = getRandomNumber(2);
        if (randomNumber == 1)
            item = Armor.createArmor(ArmorType.HELMET);
        else if (randomNumber == 2)
            item = AttackRune.createAttackRune(AttackRuneType.FIRE_BALL);
        return item;
    }

    private int getRandomNumber(int numbers) {
        return (int) (Math.random() * numbers) + 1;
    }

    public void printAllItemsInBackpack() {
        if (backpack.isEmpty())
            IO.println("Backpack is empty");
        else
            for (Item item : backpack) {
                IO.println(item.getItemName());
            }
    }
}
