package com.fangdjupet.menu;

public class GameMenu {
//_________________________COLOURS__________________________
    private static final String RESET = "\u001B[0m";
    private static final String RED = "\u001B[31m";
    private static final String GREEN = "\u001B[32m";
    private static final String YELLOW = "\u001B[33m";
    private static final String BLUE = "\u001B[34m";

//_________________________COLOUR-METHODS____________________________________________________
    // Warning/damage messages — taking damage, status condition inflicted, defeat, danger
    public void printRed(String message) {
    System.out.println(RED + message + RESET);
    }

    // Success/heal messages — healing, victory, rewards
    public void printGreen(String message) {
        System.out.println(GREEN + message + RESET);
    }

    //Item and interaction messages
    public void printYellow(String message) {
        System.out.println(YELLOW + message + RESET);
    }

    // System messages — room changes, game status, progression
    public void printBlue(String message) {
        System.out.println(BLUE + message + RESET);
    }
//___________________________________________________________________________________________

    public String printMainMenu() {
    while (true) {
        printBlue("""
                Welcome to Fibula!
                
                1. New game
                2. Load savefile
                3. Exit
                """);

        String choice = IO.readln();

        switch (choice) {
            case "1", "2", "3" -> {
                return choice;
            }
            default -> printRed("Invalid choice");
        }
    }
}

    public void printDefeat() {
        printRed("You have been defeated. Exiting game..");
    }

    public void printVictory() {
        printGreen("You are victorious!! Exiting game..");
    }

    public String printPathChoice() {

        printBlue("""
                The path ahead forks into two steep passages.
                Once you descend, there will be no turning back.
                There is a torn wooden sign that reads:
                """);
        printRed("<-- DANGER\n");
        printBlue("""
                Make your choice:
                
                """);

        while (true) {
            System.out.println("1. Head right. Follow the (potentially) safer path.\n" +
                    "2. Head left. Face whatever danger lurks below head-on.");

            String choice = IO.readln();

            switch (choice) {
                case "1", "2" -> {
                    return choice;
                }
                default -> printRed("Invalid choice");
            }
        }
    }

    public void printCampMessage() {
        printBlue("""
                You find a quiet spot to rest.
                The fire crackles softly as you catch your breath.
                
                """);
    }

    public String campChoice() {
        while (true) {
            printBlue("""
                    1. Proceed
                    2. Use items
                    3. Swap equipment""");

            String choice = IO.readln();

            switch (choice) {
                case "1", "2", "3" -> {
                    return choice;
                }
                default -> printRed("Invalid choice");
            }
        }
    }
}