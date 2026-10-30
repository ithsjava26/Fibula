package com.fangdjupet.room;

import com.fangdjupet.common.Difficulty;
import java.util.List;

public class RoomManager {

    private int currentIndex = 0;

    public Room getCurrentRoom() {
        return dungeon.get(currentIndex);
    }

    public void moveTo(int index) {
        if (index >= 0 && index < dungeon.size()) {
            currentIndex = index;
        }
    }


    public List<Room> getDungeon() {
        return dungeon;
    }

    private final List<Room> dungeon = List.of(

            new BattleRoom(Difficulty.BEGINNER,    //INDEX = 0
                    "Rum 0"),
            new BattleRoom(Difficulty.BEGINNER,    //INDEX = 1
                    "Rum 1"),
            new BattleRoom(Difficulty.EASY,        //INDEX = 2
                    "Rum 2"),
            new BattleRoom(Difficulty.EASY,        //INDEX = 3
                    "Rum 3"),

//_______________________NON-QUEST PATH_______________________
            new BattleRoom(Difficulty.MEDIUM,      //INDEX = 4
                    "Rum 4"),
            new BattleRoom(Difficulty.MEDIUM,      //INDEX = 5
                    "Rum 5"),
            new BattleRoom(Difficulty.MEDIUM,      //INDEX = 6
                    "Rum 6"),

//____________________OPTIONAL QUEST PATH_____________________

            new BattleRoom(Difficulty.MEDIUM,      //INDEX = 7
                    "Rum 7"),
            new BattleRoom(Difficulty.MEDIUM,      //INDEX = 8
                    "Rum 8"),
            new BattleRoom(Difficulty.HARD,        //INDEX = 9
                    "Rum 9"),
            new QuestRoom(),                      //INDEX = 10

//________________________JOINED PATH_________________________

            new BattleRoom(Difficulty.HARD,       //INDEX = 11
                    "Rum 11"),
            new BattleRoom(Difficulty.HARD,       //INDEX = 12
                    "Rum 12"),
            new BattleRoom(Difficulty.HARD,       //INDEX = 13
                    "Rum 13"),
            new BossRoom()                        //INDEX = 14

    );
}
