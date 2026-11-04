package com.fangdjupet.common;

/**
 * Represents the additional effects of an enemy attack on the player. Certain enemy attacks change the current state of the player.
 * They deal passive damage over 'time' during combat, which can be mitigated/neutralized by certain items
 * (using the corresponding healing potions).
 */

public enum Effect {
    NEUTRAL, BLEEDING, POISONED, BURNING
}
