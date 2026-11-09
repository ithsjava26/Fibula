package com.fangdjupet.save;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileHandler {

    private final Path savePath = Path.of("savegame.txt");

    public void save(GameState state) {
        String saveData = state.getCurrentRoomIndex()
                + "," + state.getHeroHealth();

        try {
            Files.writeString(savePath, saveData);
            System.out.println("Game saved!");
        } catch (IOException e) {
            System.out.println("Could not save game: " + e.getMessage());
        }
    }
}