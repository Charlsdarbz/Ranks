package org.darbz.ranks.managers

import org.bukkit.configuration.file.YamlConfiguration
import org.darbz.ranks.Ranks
import java.io.File
import java.io.IOException
import java.util.UUID
import org.darbz.ranks.other.Rank

class rankManager(private val plugin: Ranks) {

    private val file: File = File(plugin.dataFolder, "data.yml")
    private val config: YamlConfiguration

    init {
        if (!plugin.dataFolder.exists()) {
            plugin.dataFolder.mkdir()
        }

        if (!file.exists()) {
            try {
                file.createNewFile()
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
        config = YamlConfiguration.loadConfiguration(file)
    }

    fun getRank(uuid: UUID): Rank {
        return Rank.valueOf(config.getString(uuid.toString()) ?: Rank.MEMBER.name)
    }

    fun setRank(uuid: UUID, rank: Rank) {
        config.set(uuid.toString(), rank.name)
        try {
            config.save(file)
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }
}
