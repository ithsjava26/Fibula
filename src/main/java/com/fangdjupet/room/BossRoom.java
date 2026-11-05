package com.fangdjupet.room;

import com.fangdjupet.character.Enemy;
import com.fangdjupet.character.FinalBossEnemy;


import java.util.ArrayList;
import java.util.List;

public class BossRoom implements Room {
    private List<Enemy> currentEnemies;

    @Override
    public void enter() {
        System.out.println("The air reeks of smoke and sulphur." +
                " A deep, thunderous growl rolls through the dungeon," +
                " and the heat ahead warns you that a dragon awaits.");
        currentEnemies = (spawnBossEnemy());
    }
    @Override
    public List<Enemy> getCurrentEnemies(){
        return this.currentEnemies;
    }

    private List<Enemy> spawnBossEnemy () {
        List<Enemy> enemies = new ArrayList<>();
        enemies.add(new FinalBossEnemy());
        return enemies;
    }
}
