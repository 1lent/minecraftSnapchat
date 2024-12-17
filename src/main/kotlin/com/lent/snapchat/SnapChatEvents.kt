package com.lent.snapchat

import com.lent.snapchat.Main.Companion.item
import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerEditBookEvent
import org.bukkit.inventory.meta.BookMeta

class SnapChatEvents : Listener {

    @EventHandler
    fun onPlayerWrite(bookEvent: PlayerEditBookEvent) {
        val updatedMeta = bookEvent.newBookMeta
        for (onlinePlayer in Bukkit.getOnlinePlayers()) {
            for (item in onlinePlayer.inventory.contents) {
                val meta = item.itemMeta
                if (item != null && item.type == Material.WRITABLE_BOOK) {
                    if (meta is BookMeta && meta.persistentDataContainer.has(Main.Keys.CUSTOM_BOOK)) {
                            val updatedBookMeta = item.itemMeta as BookMeta
                            updatedBookMeta.pages = updatedMeta.pages
                            item.itemMeta = updatedBookMeta
                        }
                }
            }
        }

    }
}