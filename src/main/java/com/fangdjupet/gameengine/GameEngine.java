package com.fangdjupet.gameengine;

import com.fangdjupet.character.Character;
import com.fangdjupet.character.Enemy;
import com.fangdjupet.character.Hero;
import com.fangdjupet.menu.GameMenu;
import com.fangdjupet.room.Room;
import com.fangdjupet.room.RoomManager;

import java.util.List;

public class GameEngine {
    private final RoomManager roomManager = new RoomManager();
    private final Character hero = new Hero();
    private final GameMenu gameMenu = new GameMenu();
    private boolean isRunning = true;

    static void main() {
        GameEngine session = new GameEngine();

        String choice = session.gameMenu.printMainMenu();

        switch (choice) {
            case "1":
                session.start();
                break;
            case "2":
                // Load savefile
                break;
            case "3":
                session.gameMenu.printRed("Exiting current game session..");
                break;
        }
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

                    if (hero.isAlive()) {
                        camp();
                        choosePath();
                    } else {
                        defeat();
                    }
                    break;

                case 6:
                    currentRoom.enter();
                    enemies = currentRoom.getCurrentEnemies();
                    battle(enemies);

                    if (hero.isAlive()) {
                        camp();
                        roomManager.moveTo(11);
                    } else {
                        defeat();
                    }
                    break;

                case 14:
                    currentRoom.enter();
                    enemies = currentRoom.getCurrentEnemies();
                    battle(enemies);

                    if (hero.isAlive()) {
                        victory();
                    } else {
                        defeat();
                    }
                    break;

                default:
                    currentRoom.enter();
                    enemies = currentRoom.getCurrentEnemies();
                    battle(enemies);

                    if (hero.isAlive()) {
                        camp();
                        roomManager.moveTo(++currentIndex);
                    } else {
                        defeat();
                    }
                    break;
            }
        }
    }
    private void defeat() {
        gameMenu.printDefeat();
        isRunning = false;
    }
    private void victory() {
        gameMenu.printVictory();
        isRunning = false;
    }
    private void choosePath() {
        String choice = gameMenu.printPathChoice();

        switch (choice) {
            case "1" -> roomManager.moveTo(4);
            case "2" -> roomManager.moveTo(7);
        }
    }
    private void camp() {
        String choice = gameMenu.printCamp();

        switch (choice) {
            // TODO:
            //  - Implement handler for case 2. Use items
            //    Handler should include a do-while loop
            //    that stops once the user is finished
            //      - Implement method in GameMenu that asks
            //        the player if they want to use another item
            //  - Insert method call for case 2. Swap equipment
            case "2" -> ;
            case "3" -> ;
        }
    }
}
