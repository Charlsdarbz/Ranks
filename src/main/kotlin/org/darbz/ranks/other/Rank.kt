package org.darbz.ranks.other

import org.bukkit.ChatColor

enum class Rank(private val display: String) {
    OWNER("${ChatColor.YELLOW}${ChatColor.BOLD}Owner"),
    MEMBER("${ChatColor.GRAY}${ChatColor.BOLD}Member"),
    ADMIN("${ChatColor.RED}${ChatColor.BOLD}Admin"),
    HELPER("${ChatColor.GREEN}${ChatColor.BOLD}Helper"),
    MODERATOR("${ChatColor.BLUE}${ChatColor.BOLD}Moderator"),
    SMP_MEMBER("${ChatColor.WHITE}${ChatColor.BOLD}SMP Member");

    fun getDisplay(): String { return display }
}
