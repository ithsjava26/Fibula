package com.fangdjupet.item;

public interface ConsumableItem extends Item {
    ConsumableItemCategory getConsumableItemCategory();

    void consumeItem();
}
