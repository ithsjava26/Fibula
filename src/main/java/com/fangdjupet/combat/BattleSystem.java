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
    private Scanner scanner;

    public BattleSystem() {
        scanner = new Scanner(System.in);
    }

    public void startBattle(Hero hero, List<Enemy> enemies) {
        System.out.println("Number of enemies: " + enemies.size());

        for (Enemy enemy : enemies) {
            System.out.println("You are fighting: " + enemy.getCharacterName());

            while (hero.isAlive() && enemy.isAlive()) {
                System.out.println("Arthur: " + hero.getCurrentHealth() + " HP");
                System.out.println(enemy.getCharacterName() + ": " + enemy.getCurrentHealth() + " HP");

                playerTurn(hero, enemy);
                if(!enemy.isAlive()) {
                    break;
                }

                enemyTurn(hero, enemy);
                applyStatusEffects(hero);
            }
        }

        //The effects wares of after every battle
        //Or add endBattleMethod
        hero.setStatus(Effect.NEUTRAL);
    }

    private void playerTurn(Hero hero, Enemy enemy) {
        System.out.println();
        System.out.println("1. Melee Attack");
        System.out.println("2. Magic Attack");
        System.out.println("3. Open Inventory");

        String choice = scanner.nextLine();
        switch (choice) {
            case "1" -> {
                int meleeDamage = hero.meleeAttack();
                enemy.takeDamage(meleeDamage);
            }
            case "2" -> {
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
                System.out.println("You are bleeding, you take 5 passive damage");
                hero.takeDamage(5);
            }
            case POISONED -> {
                System.out.println("You are poisoned, you take 10 passive damage");
                hero.takeDamage(10);
            }
            case BURNING -> {
                System.out.println("You are burned, you take 15 passive damage");
                hero.takeDamage(15);
            }
            //case NEUTRAL -> {
            //    System.out.println("No additional effects are acting on you");
            //}
        }
    }

    private void openInventory(Hero hero) {
        //hero.getInventory().displayItems();
        System.out.println("Select item:");
        String choice = scanner.nextLine();
        //hero.getInventory().useItem(choice, hero);
    }

}
