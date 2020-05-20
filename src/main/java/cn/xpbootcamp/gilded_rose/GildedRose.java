package cn.xpbootcamp.gilded_rose;

class GildedRose {
    private Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void update_quality() {
        for (int i = 0; i < items.length; i++) {
            Item item = items[i];
            item.update();
        }
    }
}
