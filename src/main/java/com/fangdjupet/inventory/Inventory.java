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

    public void initializeInventory() {
        currentlyEquipped.add(Weapon.createWeapon(WeaponType.CLUB));
        // TODO: Add small healing potion to backpack
    }

    public List<Item> getItems(Difficulty level) {
        List<Item> items = new ArrayList<>();
        if (level == Difficulty.QUEST)
            items.add(AttackRune.createAttackRune(AttackRuneType.PARALYSE));
        else {
            int NumberOfItemsDiceRoll = (int) (Math.random() * 2) + 1; // 1 or 2 items
            for (int i = 1; i <= NumberOfItemsDiceRoll; i++) {
                Item item = getRandomItem(level);
                if (item != null)
                    items.add(item);
            }
        }
        return items;
    }

    private Item getRandomItem(Difficulty level) {
        Item item = null;
        int itemNumberToGet;
        if (level == Difficulty.EASY) {
            itemNumberToGet = (int) (Math.random() * 2) + 1; // 1 or 2
            if (itemNumberToGet == 1)
                item = Armor.createArmor(ArmorType.HELMET);
            else if (itemNumberToGet == 2)
                item = AttackRune.createAttackRune(AttackRuneType.FIRE_BALL);
            // TODO: Add EASY level healing potions
        } else if (level == Difficulty.MEDIUM) {
            itemNumberToGet = (int) (Math.random() * 4) + 1; // 1, 2, 3, or 4
            if (itemNumberToGet == 1)
                item = Weapon.createWeapon(WeaponType.AXE);
            else if (itemNumberToGet == 2)
                item = Armor.createArmor(ArmorType.CHESTPLATE);
            else if (itemNumberToGet == 3)
                item = AttackRune.createAttackRune(AttackRuneType.STONE_SHOWER);
            else if (itemNumberToGet == 4)
                item = Weapon.createWeapon(WeaponType.DAGGER);
            // TODO: Add MEDIUM level healing potions
        } else if (level == Difficulty.HARD) {
            itemNumberToGet = (int) (Math.random() * 1) + 1; // 1
            if (itemNumberToGet == 1)
                item = AttackRune.createAttackRune(AttackRuneType.POISON_BOMB);
            // TODO: Add HARD level healing potions
        }
        return item;
    }

    public List<Item> dropItems(Difficulty level) {
        List<Item> enemyItems = new ArrayList<>();

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

    public void printAllItemsInBackpack() {
        if (backpack.isEmpty())
            IO.println("Backpack is empty");
        else
            for (Item item : backpack) {
                IO.println(item.getItemName());
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
