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
        if (!isAgedBrie()
                && !isBackstagePass()) {
            if (quality > 0) {
                if (!isSulfuras()) {
                    quality = quality - 1;
                }
            }
        } else {
            if (quality < 50) {
                quality = quality + 1;

                if (isBackstagePass()) {
                    if (sellIn < 11) {
                        increaseQuality();
                    }

                    if (sellIn < 6) {
                        increaseQuality();
                    }
                }
            }
        }
    }

    private void updateSellIn() {
        if (!isSulfuras()) {
            sellIn = sellIn - 1;
        }
    }

    private void updateQualityAfterExpired() {
        if (!isAgedBrie()) {
            if (!isBackstagePass()) {
                if (quality > 0) {
                    if (!isSulfuras()) {
                        quality = quality - 1;
                    }
                }
            } else {
                quality = 0;
            }
        } else {
            increaseQuality();
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
