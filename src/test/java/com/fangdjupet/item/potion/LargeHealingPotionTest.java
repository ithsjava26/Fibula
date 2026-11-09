package com.fangdjupet.item.potion;

import com.fangdjupet.character.Hero;
import com.fangdjupet.common.Effect;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LargeHealingPotionTest {
    @Test
    void largeBurnPotionOnlyCuresBurning() {
        verifyStatuses(new LargeBurnHealingPotion(), "burn", "burn injury",
                "heal your burn injury");
    }

    @Test
    void largeCutPotionOnlyCuresBleeding() {
        verifyStatuses(new LargeCutInjuryHealingPotion(), "cut", "cut injury",
                "heal your cut injury");
    }

    @Test
    void largePoisonPotionOnlyCuresPoison() {
        verifyStatuses(new LargePoisonHealingPotion(), "poison", "poison",
                "remove the poison from your body");
    }

    private void verifyStatuses(HealingPotion potion, String name, String condition, String cure) {
        for (int healingAmount : new int[]{potion.getHealingAmount(), 23}) {
            potion.setHealingAmount(healingAmount);
            for (Effect status : Effect.values()) {
                Hero hero = new Hero("Test hero", 40);
                hero.setStatus(status);
                ByteArrayOutputStream output = new ByteArrayOutputStream();
                PrintStream originalOut = System.out;
                try (PrintStream capture = new PrintStream(output, true, StandardCharsets.UTF_8)) {
                    System.setOut(capture);
                    potion.usePotion(hero);
                } finally {
                    System.setOut(originalOut);
                }
                boolean matching = status == potion.getPotionEffect();
                assertEquals(matching ? Effect.NEUTRAL : status, hero.getStatus());
                assertEquals(40 + healingAmount, hero.getCurrentHealth());
                String message = matching
                        ? "You " + cure + ". You now feel better."
                        : "You have no " + condition + " to heal.";
                assertEquals("You drink the large " + name + " healing potion and heal "
                        + healingAmount + " HP." + System.lineSeparator()
                        + message + System.lineSeparator(), output.toString(StandardCharsets.UTF_8));
            }
        }
    }
}
