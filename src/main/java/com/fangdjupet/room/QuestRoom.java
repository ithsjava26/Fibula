package com.fangdjupet.room;

import com.fangdjupet.common.Difficulty;

import java.util.ArrayList;
import java.util.List;

public class QuestRoom implements Room {
    private List<Enemy> currentEnemies;

    @Override
    public void enter() {
        System.out.println("You have reached the final room of your quest!\n" +
                "You encounter a ------!");
        currentEnemies = spawnQuestEnemy();
    }

    public List<Enemy> getCurrentEnemies(){
        return this.currentEnemies;
    }

    private List<Enemy> spawnQuestEnemy () {
        List<Enemy> enemies = new ArrayList<>();
            enemies.add(new QuestEnemy());
        return enemies;
    }
}
