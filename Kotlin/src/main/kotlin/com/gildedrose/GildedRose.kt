package com.gildedrose

import java.lang.Integer.min

class GildedRose(var items: Array<Item>) {
    companion object {
        const val BRIE = "Aged Brie"
        const val BACKSTAGE = "Backstage passes to a TAFKAL80ETC concert"
        const val SULFURAS = "Sulfuras, Hand of Ragnaros"
    }

    fun updateQuality() {
        for (i in items.indices) {

            when (items[i].name) {
                //BRIE -> {}
                BACKSTAGE -> {

                    when (items[i].sellIn) {
                        in 1..5 -> items[i].quality += 3
                        in 6..10 -> items[i].quality += 2
                        in 11..10000000 -> items[i].quality++
                        else -> items[i].quality = 0
                    }
                    items[i].quality = min(50, items[i].quality)

                    items[i].sellIn--

                } // end backstage
                SULFURAS -> {}
                else -> {
                    if (items[i].name != BRIE && items[i].name != BACKSTAGE) {
                        if (items[i].quality > 0) {
                            items[i].quality = items[i].quality - 1
                        }
                    } else {
                        if (items[i].quality < 50) {
                            items[i].quality = items[i].quality + 1

                            if (items[i].name == BACKSTAGE) {
                                if (items[i].sellIn < 11) {
                                    if (items[i].quality < 50) {
                                        items[i].quality = items[i].quality + 1
                                    }
                                }

                                if (items[i].sellIn < 6) {
                                    if (items[i].quality < 50) {
                                        items[i].quality = items[i].quality + 1
                                    }
                                }
                            }
                        }
                    }

                    items[i].sellIn = items[i].sellIn - 1

                    if (items[i].sellIn < 0) {
                        if (items[i].name != BRIE) {
                            if (items[i].name != BACKSTAGE) {
                                if (items[i].quality > 0) {
                                    items[i].quality = items[i].quality - 1
                                }
                            } else {
                                items[i].quality = items[i].quality - items[i].quality
                            }
                        } else {
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1
                            }
                        }
                    }
                }
            }
        }
    }
}

