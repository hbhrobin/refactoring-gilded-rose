package cn.xpbootcamp.gilded_rose;

public class RegularItem extends Item {
    public RegularItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    protected void updateQuality() {
        decreaseQuality();
    }

    protected void updateSellIn() {
        sellIn = sellIn - 1;
    }

    protected void updateQualityAfterExpired() {
        decreaseQuality();
    }

    private void decreaseQuality() {
        if (quality > 0) {
            quality = quality - 1;
        }
    }
}
