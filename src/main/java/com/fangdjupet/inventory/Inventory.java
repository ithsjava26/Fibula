package com.fangdjupet.inventory;

import com.fangdjupet.common.Difficulty;
import com.fangdjupet.item.Item;
import com.fangdjupet.item.ItemCategory;
import com.fangdjupet.item.armor.Armor;
import com.fangdjupet.item.armor.ArmorType;
import com.fangdjupet.item.potion.HealingPotion;
import com.fangdjupet.item.potion.HealingPotionType;
import com.fangdjupet.item.rune.AttackRune;
import com.fangdjupet.item.rune.AttackRuneType;
import com.fangdjupet.item.weapon.Weapon;
import com.fangdjupet.item.weapon.WeaponType;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class Inventory {
    private final List<Item> backpack = new ArrayList<>();
    private final List<Item> currentlyEquipped = new ArrayList<>();

    public void initializeInventory() {
        currentlyEquipped.add(Weapon.createWeapon(WeaponType.LONGBOW));
        backpack.add(HealingPotion.createHealingPotion(HealingPotionType.SMALL_CUT_INJURY_HEALING_POTION));
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

    public void dropItems(List<Item> items) {
        List<Item> droppedItems = new ArrayList<>();
        List<Item> alreadyEquippedItems = new ArrayList<>();

        if (items.isEmpty()) {
            IO.println("No enemy items were dropped");
            return;
        } else {
            for (Item item : items) {
                if (isEquipableItemAndExistsInBackpack(item) || isCurrentlyEquippedWithItem(item))
                    alreadyEquippedItems.add(item);
                else
                    droppedItems.add(item);
            }
        }
        if (droppedItems.isEmpty()) {
            IO.println("Only equipable items were dropped, but you already have them");
        } else {
            for (Item droppedItem : droppedItems)
                addToBackpack(droppedItem);
            IO.print("The enemy/enemies dropped ");
            IO.print(formattedItems(droppedItems));
            IO.print(", and have been added to your backpack\n");

            if (!alreadyEquippedItems.isEmpty())
                IO.print("The enemy/enemies also dropped " + formattedItems(alreadyEquippedItems) +
                        ", but you already have that equipment\n");
        }
    }

    // TODO: Fix this method so it prints all items in backpack in nice format
    public void printAllItemsInBackpack() {
        if (backpack.isEmpty())
            IO.println("Backpack is empty");
        else
            for (Item item : backpack) {
                IO.println(item.getItemName());
            }
    }

    public void clearInventory() {
        backpack.clear();
        currentlyEquipped.clear();
    }

    private String formattedItems(List<Item> items) {
        return items.stream()
                .collect(groupingBy(Item::getItemName))
                .entrySet().stream()
                .map(entry -> entry.getValue().size() + " " + entry.getKey())
                .collect(Collectors.joining(", "));
    }

    private boolean isEquipableItemAndExistsInBackpack(Item inputItem) {
        if (inputItem.getItemCategory().equals(ItemCategory.EQUIPABLE)) {
            for (Item item : backpack)
                if (item.getItemName().equals(inputItem.getItemName()))
                    return true;
        }
        return false;
    }

    private boolean isCurrentlyEquippedWithItem(Item inputItem) {
        for (Item item : currentlyEquipped) {
            if (item.getItemName().equals(inputItem.getItemName()))
                return true;
        }
        return false;
    }

    private void addToBackpack(Item item) {
        backpack.add(item);
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

    private void removeFromBackpack(Item item) {
        backpack.remove(item);
    }

    private void addToCurrentlyEquippedList(Item item) {
        currentlyEquipped.add(item);
    }
}
