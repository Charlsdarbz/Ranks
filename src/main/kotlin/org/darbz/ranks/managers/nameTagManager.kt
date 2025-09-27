package org.darbz.ranks.managers

import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.entity.Player
import org.darbz.ranks.Ranks
import org.darbz.ranks.other.Rank

class nameTagManager(private val plugin: Ranks) {
    fun setNameTags(p: Player) {
        p.setScoreboard(Bukkit.getScoreboardManager().getNewScoreboard())
        for (rank: Rank in Rank.values()) {
            var team = p.scoreboard.registerNewTeam(rank.name)
            team.prefix ="${ChatColor.GRAY}[${rank.getDisplay()}${ChatColor.GRAY}] "

        }
        for (target: Player in Bukkit.getOnlinePlayers()) {
            if (p.uniqueId != target.uniqueId) {
                p.scoreboard.getTeam(plugin.getRankManager().getRank(target.uniqueId).name)!!.addEntry(target.name)

            }
        }
    }

    fun newTag(p: Player?) {
        val rank = plugin.getRankManager().getRank(p!!.uniqueId)
        for (target: Player in Bukkit.getOnlinePlayers()) {
            target.scoreboard.getTeam(rank.name)!!.addEntry(p.name)
        }
    }

    fun removeTag(p: Player?) {
        for (target: Player in Bukkit.getOnlinePlayers()) {
            target.scoreboard.getEntryTeam(p!!.name)!!.removeEntry(p.name)
        }
    }
}