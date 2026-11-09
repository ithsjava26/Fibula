package com.fangdjupet.save;

import com.fangdjupet.inventory.Inventory;

public class GameState {

    private final int currentRoomIndex;
    private final int heroHealth;
    private final Inventory inventory = new Inventory();

    public GameState(int currentRoomIndex, int heroHealth) {
        this.currentRoomIndex = currentRoomIndex;
        this.heroHealth = heroHealth;
    }

    public int getCurrentRoomIndex() {
        return currentRoomIndex;
    }

    public int getHeroHealth() {
        return heroHealth;
    }

    public Inventory getInventory() {
        return inventory;
    }
}
