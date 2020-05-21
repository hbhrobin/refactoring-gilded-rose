package cn.xpbootcamp.gilded_rose.items;

abstract public class Item {

    protected String name;

    protected int sellIn;

    protected int quality;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }

    public final void update() {
        updateQuality();

        updateSellIn();

        if (isExpired()) {
            updateQualityAfterExpired();
        }
    }

    private boolean isExpired() {
        return sellIn < 0;
    }

    abstract protected void updateQuality();

    abstract protected void updateSellIn();

    abstract protected void updateQualityAfterExpired();

    protected void increaseQuality() {
        if (quality < 50) {
            quality = quality + 1;
        }
    }
}
