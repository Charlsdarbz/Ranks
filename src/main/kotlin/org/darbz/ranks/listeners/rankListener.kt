package org.darbz.ranks.listeners

import io.papermc.paper.event.player.AsyncChatEvent
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent
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
    }
    @EventHandler
    fun onChat(e: AsyncChatEvent) {

    }
}