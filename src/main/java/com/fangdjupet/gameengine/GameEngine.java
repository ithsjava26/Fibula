package com.fangdjupet.gameengine;

import com.fangdjupet.character.Enemy;
import com.fangdjupet.character.Hero;
import com.fangdjupet.combat.BattleSystem;
import com.fangdjupet.item.Item;
import com.fangdjupet.menu.GameMenu;
import com.fangdjupet.room.Room;
import com.fangdjupet.room.RoomManager;

import java.util.ArrayList;
import java.util.List;

public class GameEngine {
    private final RoomManager roomManager = new RoomManager();
    private final Hero hero = new Hero();
    protected final GameMenu gameMenu = new GameMenu();
    private final BattleSystem battleSystem = new BattleSystem();
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
        hero.getDescription();
        gameMenu.printGreen(hero.getDescription());

        while (isRunning) {
            Room currentRoom = roomManager.getCurrentRoom();
            int currentIndex = roomManager.getCurrentIndex();
            List<Enemy> enemies;

            switch (currentIndex) {

                case 3:
                    currentRoom.enter();
                    enemies = currentRoom.getCurrentEnemies();
                    battleSystem.startBattle(hero, enemies);

                    if (hero.isAlive()) {
                        hero.getInventory().dropItems(generateLoot(enemies));
                        camp();
                        choosePath();
                    } else {
                        defeat();
                    }
                    break;

                case 6:
                    currentRoom.enter();
                    enemies = currentRoom.getCurrentEnemies();
                    battleSystem.startBattle(hero, enemies);

                    if (hero.isAlive()) {
                        hero.getInventory().dropItems(generateLoot(enemies));
                        camp();
                        roomManager.moveTo(11);
                    } else {
                        defeat();
                    }
                    break;

                case 14:
                    currentRoom.enter();
                    enemies = currentRoom.getCurrentEnemies();
                    battleSystem.startBattle(hero, enemies);

                    if (hero.isAlive()) {
                        victory();
                    } else {
                        defeat();
                    }
                    break;

                default:
                    if (currentIndex == 10) {
                    }
                    currentRoom.enter();
                    enemies = currentRoom.getCurrentEnemies();
                    battleSystem.startBattle(hero, enemies);

                    if (hero.isAlive()) {
                        hero.getInventory().dropItems(generateLoot(enemies));
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
            case "2" -> {
                hero.getInventory().useItems(hero);
                camp();
            }
            case "3" -> {
                hero.getInventory().equip(hero);
                camp();
            }
            case "4" -> {
                hero.getInventory().printAllItemsInInventory();
                camp();
            }
        }
    }

    private List<Item> generateLoot(List<Enemy> enemies) {
        List<Item> items = new ArrayList<>();
        for (Enemy enemy : enemies) {
            items.addAll(hero.getInventory().getItems(enemy.getDifficulty()));
        }
        return items;
    }
}
