package com.lent.snapchat

import com.github.supergluelib.foundation.util.ItemBuilder
import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.enchantments.Enchantment
import org.bukkit.inventory.ItemFlag
import org.bukkit.inventory.meta.BookMeta
import org.bukkit.persistence.PersistentDataType

class Item {
    var snapbook = ItemBuilder(Material.WRITABLE_BOOK, "Snapchat App", 1)
        .glowing(true)
        .build().apply {
            val meta = itemMeta as BookMeta
            meta.title = "Snapchat App"
            meta.author = "System"
            meta.pages = listOf("Welcome to Snapchat! Start writing your messages here! ")
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS)
            meta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true)
            meta.persistentDataContainer.set(Main.Keys.CUSTOM_BOOK, PersistentDataType.BOOLEAN, true)
            itemMeta = meta
        }
}