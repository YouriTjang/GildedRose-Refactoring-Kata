package com.gildedrose

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class GildedRoseTest {

    @Test
    fun `Check name`() {
        
        val items = arrayOf<Item>(Item("foo", 0, 0))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals("foo", app.items[0].name)
    }

    @Test
    fun `Check that sellIn decreases when Quality is updated (day passes)`() {
        val items = arrayOf<Item>(Item("foo", 0, 0))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(-1, app.items[0].sellIn)
    }

    @Test
    fun `The quality of an item decreases after day passes`() {
        val items = arrayOf<Item>(Item("foo", 1, 10))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(9, app.items[0].quality)
    }

    @Test
    fun `The quality decreases by 2 when the sellIN is lower than 1`() {
        val items = arrayOf<Item>(Item("foo", 0, 10))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(8, app.items[0].quality)
    }

    @Test
    fun `The quality is never negative`() {
        val items = arrayOf<Item>(Item("foo", 0, 0))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(0, app.items[0].quality)
    }

    @Test
    fun `The quality is never negative when sell IN is bigger than 0`() {
        val items = arrayOf<Item>(Item("foo", 1, 0))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(0, app.items[0].quality)
    }

    @Test
    fun `Aged Brie actually increases in Quality the older it gets`() {
        val items = arrayOf<Item>(Item("Aged Brie", 10, 8))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(9, app.items[0].quality)
    }


    @Test
    fun `The Quality of an item is never more than 50`() {
        val items = arrayOf<Item>(
            Item("Aged Brie", 10, 50),
            Item("Aged Brie", 0, 48))

        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(50, app.items[0].quality)
        assertEquals(50, app.items[1].quality)
    }

    @Test
    fun `Sulfuras the sellIn never decreases and the Quality never decreases`() {
        val items = arrayOf<Item>(
            Item("Sulfuras, Hand of Ragnaros", 10, 80)

        )
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(10, app.items[0].sellIn)
        assertEquals(80, app.items[0].quality)
    }

//    @Test
//    fun `tryout normalItem`() {
//        val normalItem = NormalItem("foo", 1, 1)
//        normalItem.passDay()
//        assertEquals("foo", normalItem.name)
//        assertEquals(0, normalItem.quality)
//        assertEquals(0, normalItem.sellIn)
//    }

    fun Item.build(name: String, sellIn: Int, quality: Int): String =
        "foo"

}