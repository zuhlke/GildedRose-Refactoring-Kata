package com.gildedrose;

class GildedRose {
    Item[] items;
    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void decreaseQuality(int i) {
        if (items[i].quality > 0) {
            if (!itemNameIsSulfuras(i)) {
                items[i].quality = items[i].quality - 1;
            }
        }
    }

    public void decreaseSellIn(int i) {
        if (!itemNameIsSulfuras(i)) {
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

    public boolean itemNameIsAgedBrie(int i) {
        return items[i].name.equals("Aged Brie");
    }

    public boolean itemNameIsBackstagePass(int i) {
        return items[i].name.contains("Backstage pass");
    }

    public boolean itemNameIsSulfuras(int i) {
        return items[i].name.contains("Sulfuras");
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            decreaseSellIn(i);
            if (itemNameIsAgedBrie(i) || itemNameIsBackstagePass(i)) {
                increaseQualityIfQualityLessThan50(i);
                if (itemNameIsBackstagePass(i)) {
                    updateBackstagePass(i);
                }
                if(itemNameIsAgedBrie(i)) {
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
