package com.lent.snapchat

import org.bukkit.Bukkit
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerEditBookEvent
import org.bukkit.persistence.PersistentDataType

class SnapChatEvents(private val plugin: Main) : Listener {

    @EventHandler
    fun onPlayerWrite(bookEvent: PlayerEditBookEvent) {
        val updatedMeta = bookEvent.newBookMeta

        // Check if this is a Snapchat book
        if (!updatedMeta.persistentDataContainer.has(plugin.item.snapchatKey, PersistentDataType.BOOLEAN)) {
            return
        }

        // Update all Snapchat books for online players
        for (onlinePlayer in Bukkit.getOnlinePlayers()) {
            val inventory = onlinePlayer.inventory

            // Find all Snapchat books in the player's inventory
            inventory.contents.filterNotNull().forEach { item ->
                val itemMeta = item.itemMeta ?: return@forEach

                if (itemMeta.persistentDataContainer.has(plugin.item.snapchatKey, PersistentDataType.BOOLEAN)) {
                    val updatedBook = item.clone()
                    val updatedBookMeta = updatedBook.itemMeta as? org.bukkit.inventory.meta.BookMeta ?: return@forEach
                    updatedBookMeta.pages = updatedMeta.pages
                    updatedBook.itemMeta = updatedBookMeta

                    // Remove old book and add updated one
                    inventory.removeItem(item)
                    inventory.addItem(updatedBook)
                }
            }
        }
    }
}