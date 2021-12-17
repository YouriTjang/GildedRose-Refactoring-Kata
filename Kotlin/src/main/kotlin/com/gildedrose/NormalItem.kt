package com.gildedrose

class NormalItem(name: String, sellIn: Int, quality: Int) : InterfaceItem, Item(name, sellIn, quality) {

    override fun passDay() {
        quality--
        sellIn--
    }
}
