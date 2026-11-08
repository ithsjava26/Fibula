package com.fangdjupet.inventory;

import com.fangdjupet.character.Hero;
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
import com.fangdjupet.menu.GameMenu;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class Inventory {
    private final GameMenu game = new GameMenu();
    private final List<Item> backpack = new ArrayList<>();
    private final List<Item> currentlyEquipped = new ArrayList<>();

    public void initializeInventory() {
        currentlyEquipped.add(Weapon.createWeapon(WeaponType.LONGBOW));
        backpack.add(HealingPotion.createHealingPotion(HealingPotionType.SMALL_CUT_INJURY_HEALING_POTION));
    }

    public List<Item> getCurrentlyEquipped() {
        return currentlyEquipped;
    }

    public void clearInventory() {
        backpack.clear();
        currentlyEquipped.clear();
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
            game.printYellow("No enemy items were dropped");
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
            game.printYellow("Only equipable items were dropped, but you already have them");
        } else {
            for (Item droppedItem : droppedItems)
                addToBackpack(droppedItem);
            game.printYellow("The enemy/enemies dropped:");
            game.printYellow(formatItemsForDropping(droppedItems));
            game.printYellow("These items have been added to your backpack");

            if (!alreadyEquippedItems.isEmpty()) {
                IO.println();
                game.printYellow("The enemy/enemies also dropped:");
                game.printYellow(formatItemsForDropping(alreadyEquippedItems));
                game.printYellow("These items are ignored because you already have that equipment");
            }
        }
    }

    public void printAllItemsInInventory() {
        IO.println();
        game.printYellow("             Inventory");
        game.printYellow("======================================");
        if (backpack.isEmpty() && currentlyEquipped.isEmpty()) {
            game.printYellow("Inventory is empty");
            return;
        }
        String weaponsInInventory = formatWeapons();
        if (!weaponsInInventory.isEmpty()) {
            game.printYellow("Weapons:");
            game.printYellow(weaponsInInventory);
            IO.println();
        }
        String armorsInInventory = formatArmors();
        if (!armorsInInventory.isEmpty()) {
            game.printYellow("Armors:");
            game.printYellow(armorsInInventory);
            IO.println();
        }
        String attackRunesInInventory = formatAttackRunes();
        if (!attackRunesInInventory.isEmpty()) {
            game.printYellow("Attack runes:");
            game.printYellow(attackRunesInInventory);
            IO.println();
        }
        String healingPotionsInInventory = formatHealingPotions();
        if (!healingPotionsInInventory.isEmpty()) {
            game.printYellow("Healing potions:");
            game.printYellow(healingPotionsInInventory);
        }
    }

    public void useItems(Hero hero) {
        IO.println();
        game.printYellow("""
                1. Drink healing potion
                2. Use attack rune
                """);

        String choice = IO.readln();

        switch (choice) {
            case "1" -> healingPotionMenu(hero);
            case "2" -> attackRuneMenu(hero);
            default -> game.printRed("Invalid choice");
        }
    }

    private void healingPotionMenu(Hero hero) {
        IO.println();
        game.printYellow("""
                1. Drink SMALL Cut injury healing potion
                2. Drink LARGE Cut injury healing potion
                3. Drink SMALL Burn healing potion
                4. Drink LARGE Burn healing potion
                5. Drink SMALL Poison healing potion
                6. Drink LARGE Poison healing potion
                """);

        String choice = IO.readln();

        HealingPotionType potionType = switch (choice) {
            case "1" -> HealingPotionType.SMALL_CUT_INJURY_HEALING_POTION;
            case "2" -> HealingPotionType.LARGE_CUT_INJURY_HEALING_POTION;
            case "3" -> HealingPotionType.SMALL_BURN_HEALING_POTION;
            case "4" -> HealingPotionType.LARGE_BURN_HEALING_POTION;
            case "5" -> HealingPotionType.SMALL_POISON_HEALING_POTION;
            case "6" -> HealingPotionType.LARGE_POISON_HEALING_POTION;
            default -> null;
        };

        if (potionType == null) {
            game.printRed("Invalid choice");
            return;
        }

        Optional<HealingPotion> healingPotion = getHealingPotionFromBackpack(potionType);
        if (healingPotion.isPresent()) {
            HealingPotion potion = healingPotion.get();
            potion.usePotion(hero);
            backpack.remove(potion);
        } else {
            game.printRed("You do not have that healing potion in your backpack.");
        }
    }

    private Optional<HealingPotion> getHealingPotionFromBackpack(HealingPotionType type) {
        return backpack.stream()
                .filter(HealingPotion.class::isInstance)
                .map(HealingPotion.class::cast)
                .filter(potion -> potion.getHealingPotionType() == type)
                .findFirst();
    }

    private String formatWeapons() {
        List<String> formattedWeapons = new ArrayList<>();

        // Add all equipped weapons to list
        for (Item item : currentlyEquipped) {
            if (item instanceof Weapon weapon) {
                formattedWeapons.add(weapon.getItemName() + ", strength: " + weapon.getWeaponStrength() +
                        " (Currently equipped)");
            }
        }
        // Add all weapons in backpack to list
        for (Item item : backpack) {
            if (item instanceof Weapon weapon) {
                formattedWeapons.add(weapon.getItemName() + ", strength: " + weapon.getWeaponStrength() +
                        " (In backpack)");
            }
        }
        return String.join(System.lineSeparator(), formattedWeapons);
    }

    private String formatArmors() {
        List<String> formattedArmors = new ArrayList<>();

        // Add all equipped armors to list
        for (Item item : currentlyEquipped) {
            if (item instanceof Armor armor) {
                formattedArmors.add(armor.getItemName() + ", strength: " + armor.getArmorValue() +
                        " (Currently equipped)");
            }
        }
        // Add all armors in backpack to list
        for (Item item : backpack) {
            if (item instanceof Armor armor) {
                formattedArmors.add(armor.getItemName() + ", strength: " + armor.getArmorValue() +
                        " (In backpack)");
            }
        }
        return String.join(System.lineSeparator(), formattedArmors);
    }

    private String formatAttackRunes() {
        return backpack.stream()
                .filter(AttackRune.class::isInstance)
                .map(AttackRune.class::cast)
                .collect(Collectors.groupingBy(AttackRune::getItemName))
                .entrySet().stream()
                .map(entry -> entry.getValue().size() + " x " + entry.getKey() +
                        ", strength: " + entry.getValue().getFirst().getAttackRuneStrength())
                .collect(Collectors.joining(System.lineSeparator()));
    }

    private String formatHealingPotions() {
        return backpack.stream()
                .filter(HealingPotion.class::isInstance)
                .map(HealingPotion.class::cast)
                .collect(Collectors.groupingBy(HealingPotion::getItemName))
                .entrySet().stream()
                .map(entry -> entry.getValue().size() + " x " + entry.getKey() +
                        ", healing: " + entry.getValue().getFirst().getHealingAmount())
                .collect(Collectors.joining(System.lineSeparator()));
    }

    private String formatItemsForDropping(List<Item> items) {
        return items.stream()
                .collect(groupingBy(Item::getItemName))
                .entrySet().stream()
                .map(entry -> entry.getValue().size() + " " + entry.getKey().toLowerCase())
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
            itemNumberToGet = (int) (Math.random() * 5) + 1; // 1, 2, 3, 4, or 5
            item = getRandomEasyItem(itemNumberToGet);
        } else if (level == Difficulty.MEDIUM) {
            itemNumberToGet = (int) (Math.random() * 7) + 1; // 1, 2, 3, 4, 5, 6, or 7
            item = getRandomMediumItem(itemNumberToGet);
        } else if (level == Difficulty.HARD) {
            itemNumberToGet = (int) (Math.random() * 4) + 1; // 1, 2, 3, or 4
            if (itemNumberToGet == 1)
                item = AttackRune.createAttackRune(AttackRuneType.POISON_BOMB);
            else if (itemNumberToGet == 2)
                item = Weapon.createWeapon(WeaponType.DAGGER);
            else if (itemNumberToGet == 3)
                item = HealingPotion.createHealingPotion(HealingPotionType.LARGE_POISON_HEALING_POTION);
            else if (itemNumberToGet == 4)
                item = HealingPotion.createHealingPotion(HealingPotionType.SMALL_BURN_HEALING_POTION);
        }
        return item;
    }

    private Item getRandomEasyItem(int itemNumberToGet) {
        Item item;
        switch (itemNumberToGet) {
            case 1 -> item = Armor.createArmor(ArmorType.HELMET);
            case 2 -> item = AttackRune.createAttackRune(AttackRuneType.FIRE_BALL);
            case 3 -> item = HealingPotion.createHealingPotion(HealingPotionType.SMALL_POISON_HEALING_POTION);
            case 4 -> item = HealingPotion.createHealingPotion(HealingPotionType.SMALL_CUT_INJURY_HEALING_POTION);
            default -> item = HealingPotion.createHealingPotion(HealingPotionType.SMALL_BURN_HEALING_POTION);
        }
        return item;
    }

    private Item getRandomMediumItem(int itemNumberToGet) {
        Item item;
        switch (itemNumberToGet) {
            case 1 -> item = Weapon.createWeapon(WeaponType.AXE);
            case 2 -> item = Armor.createArmor(ArmorType.CHESTPLATE);
            case 3 -> item = AttackRune.createAttackRune(AttackRuneType.STONE_SHOWER);
            case 4 -> item = Weapon.createWeapon(WeaponType.SWORD);
            case 5 -> item = HealingPotion.createHealingPotion(HealingPotionType.LARGE_POISON_HEALING_POTION);
            case 6 -> item = HealingPotion.createHealingPotion(HealingPotionType.LARGE_CUT_INJURY_HEALING_POTION);
            default -> item = HealingPotion.createHealingPotion(HealingPotionType.LARGE_BURN_HEALING_POTION);
        }
        return item;
    }
}
