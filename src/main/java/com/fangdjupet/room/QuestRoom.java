package com.fangdjupet.room;

import com.fangdjupet.character.Enemy;
import com.fangdjupet.character.QuestBossEnemy;
import com.fangdjupet.menu.GameMenu;

import java.util.ArrayList;
import java.util.List;

public class QuestRoom implements Room {
    private final GameMenu gameMenu = new GameMenu();
    private List<Enemy> currentEnemies;

    @Override
    public void enter() {
        gameMenu.printBlue("The chamber is draped in thick webs." +
                " Something enormous stirs in the darkness," +
                " eight eyes glinting as a giant spider emerges.");
        currentEnemies = spawnQuestEnemy();
    }
    @Override
    public List<Enemy> getCurrentEnemies(){
        return this.currentEnemies;
    }

    private List<Enemy> spawnQuestEnemy () {
        List<Enemy> enemies = new ArrayList<>();
            enemies.add(new QuestBossEnemy());
        return enemies;
    }
}
