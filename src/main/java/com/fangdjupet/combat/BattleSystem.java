package com.fangdjupet.combat;

import com.fangdjupet.character.Enemy;
import com.fangdjupet.character.Hero;
import com.fangdjupet.common.Effect;

import java.util.List;
import java.util.Scanner;

/**
 * This class represents the battle system where the hero fights the enemies.
 */

public class BattleSystem {
    private final Scanner scanner;

    public BattleSystem() {
        scanner = new Scanner(System.in);
    }

    public void startBattle(Hero hero, List<Enemy> enemies) {
        System.out.println();
        System.out.println("A battle is about to commence!");
        System.out.println("Number of enemies in this battle: " + enemies.size());

        for (Enemy enemy : enemies) {

            if(!hero.isAlive()) {
                break;
            }
            System.out.println();
            System.out.println("You are fighting: " + enemy.getCharacterName());

            while (hero.isAlive() && enemy.isAlive()) {
                System.out.println("Arthur: " + hero.getCurrentHealth() + " HP");
                System.out.println(enemy.getCharacterName() + ": " + enemy.getCurrentHealth() + " HP");

                playerTurn(hero, enemy);
                if(!enemy.isAlive()) {
                    System.out.println();
                    System.out.println(enemy.getCharacterName() + " has been killed!");
                    break;
                }

                enemyTurn(hero, enemy);
                applyStatusEffects(hero);
                if(!hero.isAlive()) {
                    System.out.println();
                    System.out.println(enemy.getCharacterName() + " has killed you!");
                }
            }
        }
        endBattle(hero, enemies);
    }

    private void playerTurn(Hero hero, Enemy enemy) {
        System.out.println();
        System.out.println("-- Player's turn --");
        System.out.println("1. Melee Attack");
        System.out.println("2. Magic Attack");
        System.out.println("3. Open Inventory");

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
                openInventory(hero);
                playerTurn(hero, enemy);
            }
            default -> {
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void enemyTurn(Hero hero, Enemy enemy) {
        System.out.println();
        System.out.println("-- Enemy's turn --");
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
                System.out.println("You are bleeding, you take 5 passive damage!");
                System.out.println();
                hero.takeDamage(5);
            }
            case POISONED -> {
                System.out.println();
                System.out.println("You are poisoned, you take 10 passive damage!");
                System.out.println();
                hero.takeDamage(10);
            }
            case BURNING -> {
                System.out.println();
                System.out.println("You are burned, you take 15 passive damage!");
                System.out.println();
                hero.takeDamage(15);
            }
            case NEUTRAL -> {
                System.out.println();
                System.out.println("No additional effects are acting on you.");
                System.out.println();
            }
        }
    }

    private void openInventory(Hero hero) {
        System.out.println();
        System.out.println("-- Inventory --");
        //hero.getInventory().displayItems();
        System.out.println("Select item:");
        String choice = scanner.nextLine();
        //hero.getInventory().useItem(choice, hero);
    }

    private void endBattle(Hero hero, List<Enemy> enemies) {
        System.out.println();
        System.out.println("===== BATTLE OVER =====");

        if (hero.isAlive()) {
            for (Enemy enemy : enemies) {
                System.out.println(hero.getCharacterName() + " defeated: " + enemy.getCharacterName());
            }
            System.out.println("Arthur's remaining HP: " + hero.getCurrentHealth());
        }
        else {
            System.out.println("Arthur has been defeated in battle. Though the good news is that he is now in Valhalla, chillin'");
        }
        System.out.println();
        hero.setStatus(Effect.NEUTRAL);     //Resets hero's status after every battle
    }

}
