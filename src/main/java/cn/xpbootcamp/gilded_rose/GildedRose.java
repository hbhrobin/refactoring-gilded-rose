package cn.xpbootcamp.gilded_rose;

import cn.xpbootcamp.gilded_rose.items.Item;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class GildedRose {
    private List<Item> items = new ArrayList<>();

    public GildedRose(Item[] items) {
        Collections.addAll(this.items, items);
    }

    public void updateByDay() {
        items.forEach(Item::update);
    }
}
