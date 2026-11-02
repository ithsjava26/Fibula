package com.fangdjupet.menu;

public class GameMenu {
//_________________________COLOURS__________________________
    private static final String RESET = "\u001B[0m";
    private static final String RED = "\u001B[31m";
    private static final String GREEN = "\u001B[32m";
    private static final String YELLOW = "\u001B[33m";
    private static final String BLUE = "\u001B[34m";

//_________________________COLOUR-METHODS____________________________________________________
    public void printRed(String message) {
    System.out.println(RED + message + RESET);
    }
    public void printGreen(String message) {
        System.out.println(GREEN + message + RESET);
    }
    public void printYellow(String message) {
        System.out.println(YELLOW + message + RESET);
    }
    public void printBlue(String message) {
        System.out.println(BLUE + message + RESET);
    }
//___________________________________________________________________________________________

    public String printMainMenu() {
    while (true) {
        System.out.println("1. New game\n" +
                "2. Load savefile\n" +
                "3. Exit\n");

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
        printGreen("You have won!! Exiting game..");
    }

    public String printPathChoice() {

        System.out.println("The path ahead forks into two steep passages.\n" +
                "Once you descend, there will be no turning back.\n" +
                "There is a torn wooden sign that reads:\n");
        printRed("<-- DANGER\n");
        System.out.println("Make your choice:\n");

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
}