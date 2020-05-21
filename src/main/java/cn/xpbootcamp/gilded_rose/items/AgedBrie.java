package cn.xpbootcamp.gilded_rose.items;

public class AgedBrie extends Item {
    public AgedBrie(int sellIn, int quality) {
        super("Aged Brie", sellIn, quality);
    }

    protected void updateQuality() {
        if (quality < 50) {
            quality = quality + 1;
        }

    }

    protected void updateSellIn() {
        sellIn = sellIn - 1;
    }

    protected void updateQualityAfterExpired() {
        increaseQuality();
    }
}
