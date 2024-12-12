package com.lent.snapchat

import org.bukkit.Bukkit
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerEditBookEvent

class SnapChatEvents : Listener {

    @EventHandler
    fun onPlayerWrite(bookEvent: PlayerEditBookEvent) {
        val player = bookEvent.player
        val updatedMeta = bookEvent.newBookMeta
        for (onlinePlayer in Bukkit.getOnlinePlayers()) {
            if (onlinePlayer.inventory.contains(Main.item.snapbook)) {
                val snapbook = Main.item.snapbook
                val updatedBook = snapbook.clone()
                val updatedBookMeta = updatedBook.itemMeta as org.bukkit.inventory.meta.BookMeta
                updatedBookMeta.pages = updatedMeta.pages
                updatedBook.itemMeta = updatedBookMeta

                onlinePlayer.inventory.removeItem(snapbook)
                onlinePlayer.inventory.addItem(updatedBook)
            }
        }

    }
}
