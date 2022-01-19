# -*- coding: utf-8 -*-
import unittest

from gilded_rose import Item, GildedRose


class GildedRoseTest(unittest.TestCase):

    def test_standard_item(self):
        item = Item(name="+5 Dexterity Vest", sell_in=10, quality=20)
        gilded_rose = GildedRose([item])
        gilded_rose.update_quality_sellin()
        self.assertEquals(item.quality, 19)
        self.assertEquals(item.sell_in, 9)

    def test_brie_item_quality_goes_up(self):
        item =  Item(name="Aged Brie", sell_in=2, quality=0)
        gilded_rose = GildedRose([item])
        gilded_rose.update_quality_sellin()
        self.assertEquals(item.quality, 1)
        self.assertEquals(item.sell_in, 1)

    def test_brie_item_quality_goes_up(self):
        item =  Item(name="Elixir of the Mongoose", sell_in=5, quality=7)
        gilded_rose = GildedRose([item])
        gilded_rose.update_quality_sellin()
        self.assertEquals(item.quality, 6)
        self.assertEquals(item.sell_in, 4)
        
if __name__ == '__main__':
    unittest.main()
