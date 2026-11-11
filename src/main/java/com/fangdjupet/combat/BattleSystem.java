package com.fangdjupet.combat;

import com.fangdjupet.character.Enemy;
import com.fangdjupet.character.Hero;
import com.fangdjupet.common.Effect;
import com.fangdjupet.menu.GameMenu;

import java.util.List;
import java.util.Scanner;

/**
 * This class represents the battle system where the hero fights the enemies.
 */

public class BattleSystem {
    private final Scanner scanner;
    private final GameMenu game = new GameMenu();

    public BattleSystem() {
        scanner = new Scanner(System.in);
    }

    public void startBattle(Hero hero, List<Enemy> enemies) {
        System.out.println();
        game.printYellow("A battle is about to commence!");
        game.printYellow("Number of enemies in this battle: " + enemies.size());

        for (Enemy enemy : enemies) {

            if(!hero.isAlive()) {
                break;
            }
            System.out.println();
            game.printRed("You are fighting: " + enemy.getCharacterName());

            while (hero.isAlive() && enemy.isAlive()) {
                game.printYellow("Arthur: " + hero.getCurrentHealth() + " HP");
                game.printRed(enemy.getCharacterName() + ": " + enemy.getCurrentHealth() + " HP");

                playerTurn(hero, enemy);
                applyStatusEffects(hero);       //Gives player a chance to change status effect before taking damage
                if(!enemy.isAlive()) {
                    System.out.println();
                    game.printGreen(enemy.getCharacterName() + " has been killed!");
                    break;
                }

                enemyTurn(hero, enemy);
                if(!hero.isAlive()) {
                    System.out.println();
                    game.printRed(enemy.getCharacterName() + " has killed you!");
                }
            }
        }
        endBattle(hero, enemies);
    }

    private void playerTurn(Hero hero, Enemy enemy) {
        System.out.println();
        game.printYellow("-- Player's turn --");
        game.printYellow("1. Melee Attack");
        game.printYellow("2. Magic Attack Runes");
        game.printYellow("3. Open Inventory");

        String choice = scanner.nextLine();
        switch (choice) {
            case "1" -> {
                System.out.println();
                int meleeDamage = hero.meleeAttack();
                enemy.takeDamage(meleeDamage);
            }
            case "2" -> {
                System.out.println();
                int magicDamage = hero.magicAttack();
                enemy.takeDamage(magicDamage);
            }
            case "3" -> {
                openInventory(hero, enemy);
                playerTurn(hero, enemy);
            }
            default -> game.printRed("Invalid choice. Please try again.");
        }
    }

    private void enemyTurn(Hero hero, Enemy enemy) {
        System.out.println();
        game.printRed("-- Enemy's turn --");
        int damage = enemy.attack();
        hero.takeDamage(damage);

        if(enemy.getEffect() != Effect.NEUTRAL) {
            hero.setStatus(enemy.getEffect());
        }
    }

    private void applyStatusEffects(Hero hero) {
        Effect effect = hero.getStatus();
        switch (effect) {
            case BLEEDING -> {
                System.out.println();
                game.printRed("You are bleeding, you take 5 passive damage!");
                System.out.println();
                hero.takeDamage(5);
            }
            case POISONED -> {
                System.out.println();
                game.printRed("You are poisoned, you take 10 passive damage!");
                System.out.println();
                hero.takeDamage(10);
            }
            case BURNING -> {
                System.out.println();
                game.printRed("You are burned, you take 15 passive damage!");
                System.out.println();
                hero.takeDamage(15);
            }
            case NEUTRAL -> {
                System.out.println();
                game.printYellow("No additional effects are acting on you.");
                System.out.println();
            }
        }
    }

    private void openInventory(Hero hero, Enemy enemy) {
        hero.getInventory().printAllItemsInInventory();

        hero.getInventory().useItems(hero, enemy);
    }

    private void endBattle(Hero hero, List<Enemy> enemies) {
        System.out.println();
        game.printYellow("===== BATTLE OVER =====");
        System.out.println();

        if (hero.isAlive()) {
            for (Enemy enemy : enemies) {
                game.printGreen(hero.getCharacterName() + " defeated: " + enemy.getCharacterName());
            }
            game.printYellow(hero.getCharacterName() + ": " + hero.getCurrentHealth() + " HP remaining");
        }
        else {
            game.printRed(hero.getCharacterName() + " has been defeated in battle");
        }
        System.out.println();
        hero.setStatus(Effect.NEUTRAL);     //Resets hero's status after every battle
    }

}
