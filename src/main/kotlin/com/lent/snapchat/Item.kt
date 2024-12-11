package com.lent.snapchat

import com.github.supergluelib.foundation.util.ItemBuilder
import org.bukkit.Material
import org.bukkit.inventory.meta.BookMeta

class Item {
    var snapbook = ItemBuilder(Material.WRITABLE_BOOK, "Snapchat App", 1)
        .glowing(true)
        .build().apply {
            val meta = itemMeta as BookMeta
            meta.title = "Snapchat App"
            meta.author = "System"
            meta.pages = listOf("Welcome to Snapchat! Start writing your messages here!")
            itemMeta = meta
        }

    val bookMeta = snapbook.itemMeta as BookMeta
}
