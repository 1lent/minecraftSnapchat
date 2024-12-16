package com.lent.snapchat

import com.github.supergluelib.foundation.util.ItemBuilder
import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.inventory.meta.BookMeta
import org.bukkit.persistence.PersistentDataType

class Item(private val plugin: Main) {
    val snapchatKey = NamespacedKey(plugin, "snapchat-book")

    var snapbook = ItemBuilder(Material.WRITABLE_BOOK, "Snapchat App", 1)
        .glowing(true)
        .build().apply {
            val meta = itemMeta as BookMeta
            meta.title = "Snapchat App"
            meta.author = "System"
            meta.pages = listOf("Welcome to Snapchat! Start writing your messages here!")
            // Add PDC tag to identify this as a Snapchat book
            meta.persistentDataContainer.set(snapchatKey, PersistentDataType.BOOLEAN, true)
            itemMeta = meta
        }
}