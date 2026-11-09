package com.fangdjupet.room;

import com.fangdjupet.common.Difficulty;
import java.util.List;

public class RoomManager {

    private int currentIndex = 0;

    public int getCurrentIndex() {
        return currentIndex;
    }

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
                    "You step into the dungeon." +
                            " Cold air brushes against your skin," +
                            " and darkness stretches before you."),
            new BattleRoom(Difficulty.BEGINNER,    //INDEX = 1
                    "The entrance fades behind you." +
                            " Somewhere ahead," +
                            " you hear movement in the dark."),
            new BattleRoom(Difficulty.EASY,        //INDEX = 2
                    "The walls grow damp, and the smell of rust hangs in the air." +
                            " Something has been here recently."),
            new BattleRoom(Difficulty.EASY,        //INDEX = 3
                    "Scratches cover the stone walls." +
                            " Whatever made them was desperate to get out."),

//_______________________NON-QUEST PATH_______________________
            new BattleRoom(Difficulty.MEDIUM,      //INDEX = 4
                    "The passage narrows. Faint echoes follow your every step," +
                            " though nothing seems to be behind you."),
            new BattleRoom(Difficulty.MEDIUM,      //INDEX = 5
                    "Broken weapons and old bones litter the floor." +
                            " This place has claimed many lives."),
            new BattleRoom(Difficulty.MEDIUM,      //INDEX = 6
                    "The air grows heavy." +
                            " Ahead, the stone bears deep cracks," +
                            " as if something enormous passed through."),

//____________________OPTIONAL QUEST PATH_____________________

            new BattleRoom(Difficulty.MEDIUM,      //INDEX = 7
                    "You enter an unfamiliar passage." +
                            " The silence feels unnatural," +
                            " and the shadows seem unusually deep."),
            new BattleRoom(Difficulty.MEDIUM,      //INDEX = 8
                    "Strange markings cover the walls." +
                            " Their meaning escapes you," +
                            " but they leave you uneasy."),
            new BattleRoom(Difficulty.HARD,        //INDEX = 9
                    "The passage descends into near darkness." +
                            " A distant sound echoes from below," +
                            " slow and deliberate."),
            new QuestRoom(),                      //INDEX = 10

//________________________JOINED PATH_________________________

            new BattleRoom(Difficulty.HARD,       //INDEX = 11
                    "The passages converge again." +
                            " Whatever lies ahead," +
                            " there is no turning back now."),
            new BattleRoom(Difficulty.HARD,       //INDEX = 12
                    "The stone beneath your feet trembles faintly." +
                            " The dungeon feels alive, and it knows you are here."),
            new BattleRoom(Difficulty.HARD,       //INDEX = 13
                    "The air is suffocating." +
                            " Beyond the next passage," +
                            " a deep rumble shakes dust from the ceiling."),
            new BossRoom()                        //INDEX = 14

    );
}
