package com.fangdjupet.item;

import com.fangdjupet.common.Difficulty;

public interface Item {
    String getItemName();

    ItemCategory getItemCategory();

    Difficulty getItemDifficultyLevel();
}