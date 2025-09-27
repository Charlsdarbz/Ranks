package org.darbz.ranks

import org.bukkit.plugin.java.JavaPlugin
import org.darbz.ranks.commands.completions.complete
import org.darbz.ranks.commands.rankCommand
import org.darbz.ranks.listeners.rankListener
import org.darbz.ranks.managers.nameTagManager
import org.darbz.ranks.managers.rankManager

class Ranks : JavaPlugin() {

    companion object {
        lateinit var instance: Ranks
            private set
    }

    private lateinit var rm: rankManager

    private lateinit var nt: nameTagManager

    override fun onEnable() {
        instance = this
        enableMessage()

        rm = rankManager(this)
        nt = nameTagManager(this)
        registerCommands()
        registerEvents()
    }

    override fun onDisable() {
        disableMessage()
    }

    private fun registerCommands() {
        getCommand("rank")!!.apply {
            setExecutor(rankCommand(instance))
        }
    }

    private fun registerEvents() {
        server.pluginManager.registerEvents(rankListener(), this)
    }

    private fun enableMessage() {
        server.consoleSender.sendMessage("§8§m----------------------------------------")
        server.consoleSender.sendMessage("§6[Ranks] §aPlugin Enabled!")
        server.consoleSender.sendMessage("§7Version: §f1.0.0")
        server.consoleSender.sendMessage("§7Author: §fDarbz")
        server.consoleSender.sendMessage("§7Status: §aRegistering Commands, Checking if Data.yml exists, Registering Events, ... §aReady!")
        server.consoleSender.sendMessage("§8§m----------------------------------------")
        logger.info("Ranks v1.0.0 enabled!")
    }

    private fun disableMessage() {
        server.consoleSender.sendMessage("§8§m----------------------------------------")
        server.consoleSender.sendMessage("§6[Ranks] §cPlugin Disabled")
        server.consoleSender.sendMessage("§7Unloading listeners and commands...")
        server.consoleSender.sendMessage("§7All listeners and commands unregistered")
        server.consoleSender.sendMessage("§8§m----------------------------------------")
    }

    fun getRankManager(): rankManager = rm

    fun nameTagManager(): nameTagManager = nt
}
