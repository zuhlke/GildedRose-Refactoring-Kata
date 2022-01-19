package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void foo() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }

    @Test
    void sellByDatePassedQualityDegradesTwiceAsFast() {
        Item[] items = new Item[] { new Item("foo", 1, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        int qualityExpected = 19;
        assertEquals(qualityExpected, app.items[0].quality);
        app.updateQuality();
        qualityExpected = 17;
        assertEquals(qualityExpected, app.items[0].quality);
    }

    @Test
    void qualityOfItemCannotBeNegative() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        int qualityExpected = 0;
        app.updateQuality();
        assertEquals(qualityExpected, app.items[0].quality);
    }

    @Test
    void qualityOfAgedBrieIncreasesWithAge() {
        Item[] items = new Item[] { new Item("Aged Brie", 3, 0) };
        GildedRose app = new GildedRose(items);
        int qualityExpected = 1;
        app.updateQuality();
        assertEquals(qualityExpected, app.items[0].quality);
    }

    @Test
    void qualityOfAgedBrieIncreasesDoublePastSellBy() {
        Item[] items = new Item[] { new Item("Aged Brie", 0, 0) };
        GildedRose app = new GildedRose(items);
        int qualityExpected = 2;
        app.updateQuality();
        assertEquals(qualityExpected, app.items[0].quality);
    }

    @Test
    void qualityCannotBeLargerThanFifty() {
        Item[] items = new Item[] { new Item("Aged Brie", 20, 49) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
    }
    /*
    Once the sell by date has passed, Quality degrades twice as fast = Done
    The Quality of an item is never negative = Done
    "Aged Brie" actually increases in Quality the older it gets = Done
    The Quality of an item is never more than 50
    "Sulfuras", being a legendary item, never has to be sold or decreases in Quality
    "Backstage passes", like aged brie, increases in Quality as it's SellIn value approaches;
    Quality increases by 2 when there are 10 days or less and by 3 when there are 5 days or less but Quality drops to 0 after the concert
     */

}
