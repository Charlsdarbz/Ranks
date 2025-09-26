package org.darbz.ranks.other

import org.bukkit.ChatColor

enum class Rank(private val display: String) {
    OWNER("${ChatColor.YELLOW}Owner"),
    MEMBER("${ChatColor.GRAY}Member"),
    ADMIN("${ChatColor.RED}Admin"),
    HELPER("${ChatColor.GREEN}Helper"),
    MODERATOR("${ChatColor.BLUE}Moderator"),
    SMP_MEMBER("${ChatColor.WHITE}SMP Member");

    fun getDisplay(): String { return display }
}
