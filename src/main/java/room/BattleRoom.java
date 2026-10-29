package room;

import java.util.ArrayList;
import java.util.List;

public class BattleRoom implements Room {
    private final String message;
    private enum RoomDifficulty {
        EASY, MEDIUM, HARD
    }
    private List<Enemy> currentEnemies;

    public BattleRoom(RoomDifficulty roomDifficulty, String message) {
        this.message = message;
        switch (roomDifficulty) {
            case EASY:
                currentEnemies = spawnEnemiesEasy();
                break;
        }
    }

    @Override
    public void enter() {
        System.out.println(message);
    }

    public ArrayList<Enemy> spawnEnemiesEasy() {
        int numberOfEnemies = (int) (Math.random() * 2) + 1;
        ArrayList<Enemy> enemies = new ArrayList<>();

        for (int i = 0; i < numberOfEnemies; i++) {
            Enemy enemy = new EasyEnemy();
            enemies.add(enemy);
        }

        return enemies;
    }
}
