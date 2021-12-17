package com.gildedrose

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class BackstageTest {

    @Test
    fun `Backstage passes increases by one in Quality when the sellIn is greater than 10`() {
        val items = arrayOf<Item>(
            Item("Backstage passes to a TAFKAL80ETC concert", 11, 8),
            Item("Backstage passes to a TAFKAL80ETC concert", 100, 8),
        )

        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(9, app.items[0].quality)
        assertEquals(9, app.items[1].quality)
    }

    @Test
    fun `Backstage passes actually increases by two in Quality when the sellIn is between 10 and 5`() {
        val items = arrayOf<Item>(
            Item("Backstage passes to a TAFKAL80ETC concert", 10, 8),
            Item("Backstage passes to a TAFKAL80ETC concert", 6, 8),
        )

        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(10, app.items[0].quality)
        assertEquals(10, app.items[1].quality)
    }

    @Test
    fun `Backstage passes actually increases by three in Quality when the sellIn lower than 5`() {
        val items = arrayOf<Item>(
            Item("Backstage passes to a TAFKAL80ETC concert", 5, 8),
            Item("Backstage passes to a TAFKAL80ETC concert", 1, 8),
        )

        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(11, app.items[0].quality)
        assertEquals(11, app.items[1].quality)
    }

    @Test
    fun `Backstage passes Quality drops to 0 after the concert`() {
        val items = arrayOf<Item>(
            Item("Backstage passes to a TAFKAL80ETC concert", 0, 8),
            Item("Backstage passes to a TAFKAL80ETC concert", -1, 8),
        )

        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(0, app.items[0].quality)
        assertEquals(0, app.items[1].quality)
    }

    @Test
    fun `The Quality of an item is never more than 50`() {
        val items = arrayOf<Item>(
            Item("Backstage passes to a TAFKAL80ETC concert", 1, 50)
        )

        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(50, app.items[0].quality)
    }
}