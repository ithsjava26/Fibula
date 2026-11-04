package com.fangdjupet.inventory;

import com.fangdjupet.common.Difficulty;
import com.fangdjupet.item.Item;
import com.fangdjupet.item.ItemCategory;
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
        int randomNumber;
        if (level == Difficulty.EASY) {
            enemyItems.add(Weapon.createWeapon(WeaponType.CLUB));
            randomNumber = getRandomNumber(2);
            enemyItems.add(getRandomEasyItem(randomNumber));
        } else if (level == Difficulty.MEDIUM) {
            randomNumber = getRandomNumber(2);
            enemyItems.add(getRandomMediumWeapon(randomNumber));
            randomNumber = getRandomNumber(2);
            enemyItems.add(getRandomMediumItem(randomNumber));
        } else if (level == Difficulty.HARD) {
            enemyItems.add(Weapon.createWeapon(WeaponType.SWORD));
            randomNumber = getRandomNumber(1);
            enemyItems.add(getRandomHardItem(randomNumber));
        } else if (level == Difficulty.QUEST) {
            enemyItems.add(Weapon.createWeapon(WeaponType.SWORD));
            enemyItems.add(AttackRune.createAttackRune(AttackRuneType.PARALYSE));
        } else // BOSS
            enemyItems.add(Weapon.createWeapon(WeaponType.SWORD));

        return enemyItems;
    }

    private Item getRandomMediumWeapon(int randomNumber) {
        Item item = null;
        if (randomNumber == 1)
            item = Weapon.createWeapon(WeaponType.AXE);
        else if (randomNumber == 2)
            item = Weapon.createWeapon(WeaponType.DAGGER);
        return item;
    }

    private Item getRandomEasyItem(int randomNumber) {
        Item item = null;
        if (randomNumber == 1)
            item = Armor.createArmor(ArmorType.HELMET);
        else if (randomNumber == 2)
            item = AttackRune.createAttackRune(AttackRuneType.FIRE_BALL);
        return item;
    }

    private Item getRandomMediumItem(int randomNumber) {
        Item item = null;
        if (randomNumber == 1)
            item = Armor.createArmor(ArmorType.CHESTPLATE);
        else if (randomNumber == 2)
            item = AttackRune.createAttackRune(AttackRuneType.STONE_SHOWER);
        return item;
    }

    private Item getRandomHardItem(int randomNumber) {
        Item item = null;
        if (randomNumber == 1)
            item = AttackRune.createAttackRune(AttackRuneType.POISON_BOMB);
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

    public void dropEnemyItem() {
        if (enemyItems.isEmpty())
            IO.println("There are no enemy items to drop");
        else {
            int randomNumber = getRandomNumber(2);
            Item droppedItem = getEnemyItem(randomNumber);
            clearList(enemyItems);
            if (isEquipableItemAndExistsInBackpack(droppedItem))
                IO.println("The enemy dropped 1 " + droppedItem.getItemName() + ", but you already have one");
            else {
                addToBackpack(droppedItem);
                IO.println("The enemy dropped 1 " + droppedItem.getItemName() + ". It has been added to your backpack");
            }
        }
    }

    public void dropQuestItem() {
        if (enemyItems.isEmpty())
            IO.println("There are no enemy items to drop");
        else {
            Item droppedItem = enemyItems.get(1);
            clearList(enemyItems);
            addToBackpack(droppedItem);
            IO.println("The enemy dropped 1 " + droppedItem.getItemName() + ". It has been added to your backpack");
        }
    }

    private Item getEnemyItem(int randomNumber) {
        return enemyItems.get(randomNumber);
    }

    public void clearList(List<Item> list) {
        list.clear();
    }

    private boolean isEquipableItemAndExistsInBackpack(Item inputItem) {
        if (inputItem.getItemCategory().equals(ItemCategory.EQUIPABLE)) {
            for (Item item : backpack)
                if (item.getItemName().equals(inputItem.getItemName()))
                    return true;
        }
        return false;
    }

    private void addToBackpack(Item item) {
        backpack.add(item);
    }

    private void removeFromBackpack(Item item) {
        backpack.remove(item);
    }

    public void equip(String itemName) {
        for (Item item : backpack) {
            if (item.getItemName().equals(itemName)) {
                if (isEquipableItemAndExistsInBackpack(item)) {
                    addToCurrentlyEquippedList(item);
                    removeFromBackpack(item);
                    IO.println("You equipped " + item.getItemName());
                } else {
                    IO.println("The item is not equipable");
                }
                return;
            }
        }
        for (Item item : currentlyEquipped) {
            if (item.getItemName().equals(itemName)) {
                IO.println("You are already equipped with " + item.getItemName());
                return;
            }
        }
        IO.println("You do not have this item in your backpack");
    }

    private void addToCurrentlyEquippedList(Item item) {
        currentlyEquipped.add(item);
    }
}
