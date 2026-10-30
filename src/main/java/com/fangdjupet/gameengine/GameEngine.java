package com.fangdjupet.gameengine;

import com.fangdjupet.room.RoomManager;

public class GameEngine {
    private final RoomManager roomManager = new RoomManager();
    private final Character character = new Character();

    static void main() {
        GameEngine gameEngine = new GameEngine();
    }
}
