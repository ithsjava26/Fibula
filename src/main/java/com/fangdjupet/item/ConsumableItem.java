package com.fangdjupet.item;

public interface ConsumableItem extends Item {
    ConsumableItemCategory getConsumableItemType();

    void useConsumableItem();
}
