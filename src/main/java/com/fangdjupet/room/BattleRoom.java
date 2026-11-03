package com.fangdjupet.room;

import com.fangdjupet.character.Enemy;
import com.fangdjupet.character.EasyEnemy;
import com.fangdjupet.character.MediumEnemy;
import com.fangdjupet.character.HardEnemy;
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
    @Override
    public List<Enemy> getCurrentEnemies() {
        return currentEnemies;
    }


    private List<Enemy> spawnBeginnerRoom() {
        return spawnEasyEnemy();
    }

    private List<Enemy> spawnEasyRoom() {
        ArrayList<Enemy> enemies = new ArrayList<>();
        int numberOfEnemies = (int) (Math.random() * 2) + 1;
        for (int i = 0; i < numberOfEnemies; i++) {
            enemies.addAll(spawnEasyEnemy());
        }
        return enemies;
    }

    private List<Enemy> spawnMediumRoom() {
        ArrayList<Enemy> enemies = new ArrayList<>();
        int numberOfEnemies = (int) (Math.random() * 2) + 1;

        for (int i = 0; i < numberOfEnemies; i++) {
            int enemyDifficultyRoll = (int) (Math.random() * 10) + 1;
            switch (enemyDifficultyRoll) {
                case 1, 2, 3:
                    enemies.addAll(spawnEasyEnemy());
                    break;
                case 4, 5, 6, 7, 8, 9, 10:
                    enemies.addAll(spawnMediumEnemy());
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
                    enemies.addAll(spawnMediumEnemy());
                    break;
                case 4, 5, 6, 7, 8, 9, 10:
                    enemies.addAll(spawnHardEnemy());
                    break;
            }


        }
        return enemies;
    }


    private List<Enemy> spawnEasyEnemy () {
        List<Enemy> enemies = new ArrayList<>();

        enemies.add(new EasyEnemy());

        return enemies;
    }

    private List<Enemy> spawnMediumEnemy () {
        List<Enemy> enemies = new ArrayList<>();

        enemies.add(new MediumEnemy());

        return enemies;
    }

    private List<Enemy> spawnHardEnemy () {
        List<Enemy> enemies = new ArrayList<>();

        enemies.add(new HardEnemy());

        return enemies;
    }
}
