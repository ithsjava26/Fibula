package com.fangdjupet.room;

import com.fangdjupet.character.BossEnemy;
import com.fangdjupet.character.Enemy;


import java.util.ArrayList;
import java.util.List;

public class BossRoom implements Room {
    private List<Enemy> currentEnemies;

    @Override
    public void enter() {
        System.out.println("");
        currentEnemies = (spawnBossEnemy());
    }
    @Override
    public List<Enemy> getCurrentEnemies(){
        return this.currentEnemies;
    }

    private List<Enemy> spawnBossEnemy () {
        List<Enemy> enemies = new ArrayList<>();
        enemies.add(new BossEnemy());
        return enemies;
    }
}
