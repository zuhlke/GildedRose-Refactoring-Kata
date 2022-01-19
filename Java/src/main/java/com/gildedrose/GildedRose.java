package com.gildedrose;

class GildedRose {
    Item[] items;
    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void decreaseQuality(int i) {
        if (items[i].quality > 0) {
            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                items[i].quality = items[i].quality - 1;
            }
        }
    }

    public void decreaseSellIn(int i) {
        if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
            items[i].sellIn = items[i].sellIn - 1;
        }
    }

    public void updateBackstagePass(int i) {
        if (items[i].sellIn < 0) {
            items[i].quality = 0;
        }
        else {
            if (items[i].sellIn < 11) {
                increaseQualityIfQualityLessThan50(i);
            }
            if (items[i].sellIn < 6) {
                increaseQualityIfQualityLessThan50(i);
            }
        }
    }

    public void updateAgedBrie(int i) {
        if (items[i].sellIn < 0) {
            increaseQualityIfQualityLessThan50(i);
        }
    }

    public void increaseQualityIfQualityLessThan50(int i) {
        if (items[i].quality < 50) {
            items[i].quality = items[i].quality + 1;
        }
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            decreaseSellIn(i);
            if (items[i].name.equals("Aged Brie") || items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                increaseQualityIfQualityLessThan50(i);
                if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                    updateBackstagePass(i);
                }
                if(items[i].name.equals("Aged Brie")) {
                    updateAgedBrie(i);
                }
            }
            else {
                decreaseQuality(i);
                if (items[i].sellIn < 0) {
                    decreaseQuality(i);
                }
            }
        }
    }
}
