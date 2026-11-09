package com.fangdjupet.save;

import com.fangdjupet.character.Hero;
import com.fangdjupet.inventory.Inventory;
import com.fangdjupet.item.Item;
import com.fangdjupet.item.weapon.*;
import com.fangdjupet.item.armor.*;
import com.fangdjupet.item.rune.*;
import com.fangdjupet.item.potion.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {

    private final Path savePath = Path.of("savegame.txt");

    public void save(GameState state) {
        Hero hero = state.getHero();
        Inventory inventory = hero.getInventory();

        List<String> lines = new ArrayList<>();

        lines.add("ROOM," + state.getCurrentRoomIndex());
        lines.add("HEALTH," + hero.getCurrentHealth());

        lines.add("BACKPACK");
        for (Item item : inventory.getBackpack()) {
            lines.add(serializeItem(item));
        }

        lines.add("EQUIPPED");
        for (Item item : inventory.getCurrentlyEquipped()) {
            lines.add(serializeItem(item));
        }

        try {
            Files.write(savePath, lines);
            System.out.println("Game saved!");
        } catch (IOException e) {
            System.out.println("Could not save game: " + e.getMessage());
        }
    }

    private String serializeItem(Item item) {

        if (item instanceof Weapon weapon) {
            return "WEAPON," + weapon.getWeaponType();
        }

        if (item instanceof Armor armor) {
            return "ARMOR," + armor.getArmorType();
        }

        if (item instanceof AttackRune rune) {
            return "ATTACK_RUNE," + rune.getAttackRuneType();
        }

        if (item instanceof HealingPotion potion) {
            return "HEALING_POTION," + potion.getHealingPotionType();
        }

        throw new IllegalArgumentException(
                "Unknown item type: " + item.getClass().getSimpleName()
        );
    }

    private Item deserializeItem(String line) {
        String[] parts = line.split(",", 2);

        return switch (parts[0]) {
            case "WEAPON" ->
                    Weapon.createWeapon(WeaponType.valueOf(parts[1]));

            case "ARMOR" ->
                    Armor.createArmor(ArmorType.valueOf(parts[1]));

            case "ATTACK_RUNE" ->
                    AttackRune.createAttackRune(
                            AttackRuneType.valueOf(parts[1])
                    );

            case "HEALING_POTION" ->
                    HealingPotion.createHealingPotion(
                            HealingPotionType.valueOf(parts[1])
                    );

            default -> throw new IllegalArgumentException(
                    "Unknown item type: " + parts[0]
            );
        };
    }
}