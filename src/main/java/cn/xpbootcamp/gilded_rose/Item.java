package cn.xpbootcamp.gilded_rose;

public class Item {

    private String name;

    private int sellIn;

    private int quality;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }

    void update() {
        updateQuality();

        updateSellIn();

        if (isExpired()) {
            updateQualityAfterExpired();
        }
    }

    private boolean isExpired() {
        return sellIn < 0;
    }

    private void updateQuality() {
        if (isAgedBrie()) {
            if (quality < 50) {
                quality = quality + 1;
            }
            return;
        }
        if (isBackstagePass()) {
            increaseQuality();
            if (sellIn < 11) {
                increaseQuality();
            }
            if (sellIn < 6) {
                increaseQuality();
            }
            return;
        }
        if (isSulfuras()) {
            return;
        }
        if (quality > 0) {
            quality = quality - 1;
        }
    }

    private void updateSellIn() {
        if (isSulfuras()) {
            return;
        }
        sellIn = sellIn - 1;
    }

    private void updateQualityAfterExpired() {
        if (isAgedBrie()) {
            increaseQuality();
            return;
        }
        if (isBackstagePass()) {
            quality = 0;
            return;
        }
        if (isSulfuras()) {
            return;
        }
        if (quality > 0) {
            quality = quality - 1;
        }
    }

    private void increaseQuality() {
        if (quality < 50) {
            quality = quality + 1;
        }
    }

    private boolean isSulfuras() {
        return name.equals("Sulfuras, Hand of Ragnaros");
    }

    private boolean isBackstagePass() {
        return name.equals("Backstage passes to a TAFKAL80ETC concert");
    }

    private boolean isAgedBrie() {
        return name.equals("Aged Brie");
    }
}
