package org.darbz.ranks.commands

import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import org.bukkit.permissions.Permission
import org.darbz.ranks.Ranks
import org.darbz.ranks.other.Rank

class rankCommand(private val plugin: Ranks) : CommandExecutor {

    override fun onCommand(sender: CommandSender, command: Command, s: String, args: Array<out String>): Boolean {
        if (sender !is Player) return false

        val p = sender

        if (args.size < 2) { p.sendMessage("${ChatColor.RED} Invalid usage. /rank <player> <rank>")}

        if (p.isOp) {
            if (Bukkit.getOfflinePlayer(args[0]) != null) {
                val target = Bukkit.getOfflinePlayer(args[0])
                for (rank: Rank in Rank.values()) {
                    if (rank.name.equals(args[1], true)) {
                        plugin.getRankManager().setRank(target.uniqueId, rank)
                        p.sendMessage("${ChatColor.GREEN} You changed the rank of ${ChatColor.GRAY}${target.name}'s ${ChatColor.GREEN}to ${rank.getDisplay()}${ChatColor.GREEN}.")
                        if (target.isOnline) {
                            target.player!!.sendMessage("${ChatColor.GRAY}Your rank has been updated")
                        }
                        return false
                    }
                }
                p.sendMessage("${ChatColor.RED} You did not specify a valid rank! Options are ${Rank.values()}")
            } else {
                p.sendMessage("${ChatColor.RED} There is no player with that name who has joined this server.")
            }
        } else {
            p.sendMessage("${ChatColor.RED} This command requiers operator.")
        }





        return true
    }
}