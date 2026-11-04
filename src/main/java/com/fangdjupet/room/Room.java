package com.fangdjupet.room;

import com.fangdjupet.character.Enemy;

import java.util.List;

public interface Room {

    void enter();

    List<Enemy> getCurrentEnemies();
}
