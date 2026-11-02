package com.fangdjupet.inventory;

import com.fangdjupet.item.Item;
import com.fangdjupet.item.weapon.Weapon;
import com.fangdjupet.item.weapon.WeaponType;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private final List<Item> backpack = new ArrayList<>();
    private final List<Item> currentlyEquipped = new ArrayList<>();
    private final List<Item> enemyItems = new ArrayList<>();

    public void initializeHeroBackpack() {
        Weapon club = Weapon.createWeapon(WeaponType.CLUB);
        backpack.add(club);
    }

    public void printItemsInBackpack() {
        if (backpack.isEmpty())
            IO.println("Backpack is empty");
        else
            for (Item item : backpack) {
                IO.println(item.getItemName());
            }
    }
}
