package org.darbz.ranks.listeners

import io.papermc.paper.event.player.AsyncChatEvent
import net.kyori.adventure.text.serializer.plain.PlainTextComponentSerializer
import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.event.player.PlayerQuitEvent
import org.darbz.ranks.Ranks
import org.darbz.ranks.other.Rank


class rankListener : Listener {
    private var plugin = Ranks.instance


    @EventHandler
    fun onJoin(e: PlayerJoinEvent) {
        val p = e.player

        if (!p.hasPlayedBefore()) {
            plugin.getRankManager().setRank(p.uniqueId, Rank.MEMBER)

        }
        plugin.nameTagManager().setNameTags(p)
        plugin.nameTagManager().newTag(p)
    }
    @EventHandler
    fun onQuit(e: PlayerQuitEvent) {
        plugin.nameTagManager().removeTag(e.player)
    }

    @EventHandler
    fun onChat(e: AsyncChatEvent) {
        e.isCancelled = true
        var p = e.player

        val m = e.message()

        val convert = PlainTextComponentSerializer.plainText().serialize(m)

        Bukkit.broadcastMessage("${ChatColor.GRAY}[${ChatColor.BOLD}${plugin.getRankManager().getRank(p.uniqueId).getDisplay()}${ChatColor.GRAY}] ${ChatColor.GRAY}${p.name}${ChatColor.DARK_GRAY}:${ChatColor.WHITE} $convert")

    }
}