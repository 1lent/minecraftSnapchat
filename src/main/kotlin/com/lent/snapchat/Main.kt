package com.lent.snapchat

import com.github.supergluelib.command.LampManager.registerCommands
import com.github.supergluelib.foundation.Foundations
import com.github.supergluelib.foundation.util.ItemBuilder
import org.bukkit.Bukkit
import org.bukkit.Bukkit.getPluginManager
import org.bukkit.Material
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import org.bukkit.plugin.java.JavaPlugin
import revxrsal.commands.annotation.Command
import revxrsal.commands.bukkit.annotation.CommandPermission

class Main : JavaPlugin() {

    companion object {
        lateinit var plugin: Main private set
        val item = Item()
    }


    override fun onEnable() {
        plugin = this
        val foundation = Foundations.setup(this)
        logger.info("Snapchat plugin has been enabled successfully!")
        val snapChatEvents = SnapChatEvents()
        getPluginManager().registerEvents(snapChatEvents, this)
        foundation.registerCommands(this)

    }



    @Command("snapchat")
    @CommandPermission("snapchat.conversation")
    fun onCommand(sender: CommandSender) {
        val player = sender as Player
        player.inventory.addItem(item.snapbook)
     }

}
