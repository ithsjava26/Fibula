package com.fangdjupet.save;

import com.fangdjupet.character.Hero;

public class GameState {

    private final Hero hero;
    private final int currentRoomIndex;

    public GameState(int currentRoomIndex, Hero hero) {
        this.currentRoomIndex = currentRoomIndex;
        this.hero = hero;
    }

    public int getCurrentRoomIndex() {
        return currentRoomIndex;
    }

    public Hero getHero() {
        return hero;
    }
}
