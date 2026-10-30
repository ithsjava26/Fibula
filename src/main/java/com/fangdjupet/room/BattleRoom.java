package com.fangdjupet.room;

import com.fangdjupet.common.Difficulty;
import java.util.ArrayList;
import java.util.List;

public class BattleRoom implements Room {
    private final String message;
    private final Difficulty difficulty;
    private List<Enemy> currentEnemies;

    public BattleRoom(Difficulty difficulty, String message) {
        this.message = message;
        this.difficulty = difficulty;
    }

    @Override
    public void enter() {
        System.out.println(message);

        switch (difficulty) {
            case BEGINNER:
                currentEnemies = spawnBeginnerRoom();
                break;
            case EASY:
                currentEnemies = spawnEasyRoom();
                break;
            case MEDIUM:
                currentEnemies = spawnMediumRoom();
                break;
            case HARD:
                currentEnemies = spawnHardRoom();
                break;
        }

    }

    private List<Enemy> getCurrentEnemies() {
        return currentEnemies;
    }


    private List<Enemy> spawnBeginnerRoom() {
        return spawnEasyEnemy(1);
    }

    private List<Enemy> spawnEasyRoom() {
        int numberOfEnemies = (int) (Math.random() * 2) + 1;
        return spawnEasyEnemy(numberOfEnemies);
    }

    private List<Enemy> spawnMediumRoom() {
        ArrayList<Enemy> enemies = new ArrayList<>();
        int numberOfEnemies = (int) (Math.random() * 2) + 1;

        for (int i = 0; i < numberOfEnemies; i++) {
            int enemyDifficultyRoll = (int) (Math.random() * 10) + 1;
            switch (enemyDifficultyRoll) {
                case 1, 2, 3:
                    enemies.addAll(spawnEasyEnemy(1));
                    break;
                case 4, 5, 6, 7, 8, 9, 10:
                    enemies.addAll(spawnMediumEnemy(1));
                    break;
            }
        }
        return enemies;
    }

    private List<Enemy> spawnHardRoom() {
        int numberOfEnemies = (int) (Math.random() * 2) + 1;
        ArrayList<Enemy> enemies = new ArrayList<>();

        for (int i = 0; i < numberOfEnemies; i++) {
            int enemyDifficultyRoll = (int) (Math.random() * 10) + 1;
            switch (enemyDifficultyRoll) {
                case 1, 2, 3:
                    enemies.addAll(spawnMediumEnemy(1));
                    break;
                case 4, 5, 6, 7, 8, 9, 10:
                    enemies.addAll(spawnHardEnemy(1));
                    break;
            }


        }
        return enemies;
    }


    private List<Enemy> spawnEasyEnemy (int numberOfEnemies) {
        List<Enemy> enemies = new ArrayList<>();
        for (int i = 0; i < numberOfEnemies; i++) {
            enemies.add(new EasyEnemy());
        }
        return enemies;
    }

    private List<Enemy> spawnMediumEnemy (int numberOfEnemies) {
        List<Enemy> enemies = new ArrayList<>();
        for (int i = 0; i < numberOfEnemies; i++) {
            enemies.add(new MediumEnemy());
        }
        return enemies;
    }

    private List<Enemy> spawnHardEnemy (int numberOfEnemies) {
        List<Enemy> enemies = new ArrayList<>();
        for (int i = 0; i < numberOfEnemies; i++) {
            enemies.add(new HardEnemy());
        }
        return enemies;
    }
}
