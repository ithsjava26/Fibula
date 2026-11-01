package com.fangdjupet.gameengine;

import com.fangdjupet.room.Room;
import com.fangdjupet.room.RoomManager;

public class GameEngine {
    private final RoomManager roomManager = new RoomManager();
    private final Character character = new GameCharacter();
    private boolean isRunning = true;

    static void main() {
        GameEngine session = new GameEngine();
        session.start();
    }

    public void start() {
        while (isRunning) {
            Room currentRoom = roomManager.getCurrentRoom();
            int currentIndex = roomManager.getCurrentIndex();
            List<Enemy> enemies;

            switch (currentIndex) {
                case 3:
                    currentRoom.enter();
                    enemies = currentRoom.getCurrentEnemies();
                    battle(enemies);
                    if (hasWonBattle) {
                        choosePath();
                    } else {
                        defeat();
                        isRunning = false;
                    }
                    break;
                case 6:
                    currentRoom.enter();
                    enemies = currentRoom.getCurrentEnemies();
                    battle(enemies);
                    if (hasWonBattle) {
                        roomManager.moveTo(11);
                    } else {
                        defeat();
                        isRunning = false;
                    }
                    break;
                case 14:
                    currentRoom.enter();
                    enemies = currentRoom.getCurrentEnemies();
                    battle(enemies);
                    if (hasWonBattle) {
                        victory();
                        isRunning = false;
                    } else {
                        defeat();
                        isRunning = false;
                    }
                    break;
                default:
                        currentRoom.enter();
                        enemies = currentRoom.getCurrentEnemies();
                        battle(enemies);
                    if (hasWonBattle) {
                        roomManager.moveTo(++currentIndex);
                    } else {
                        defeat();
                        isRunning = false;
                    }
                    break;
            }

        }
    }
}
