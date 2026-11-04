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

    public void initializeInventory() {
        currentlyEquipped.add(Weapon.createWeapon(WeaponType.CLUB));
        // TODO: Add small healing potion to backpack
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

    public List<Item> dropEnemyItem(Difficulty level) {
        if (enemyItems.isEmpty())
            IO.println("There are no enemy items to drop");
        else {
            int randomNumber = getRandomNumber(2);
            Item droppedItem = getEnemyItemFromIndexInList(randomNumber);
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

    private Item getEnemyItemFromIndexInList(int randomNumber) {
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
