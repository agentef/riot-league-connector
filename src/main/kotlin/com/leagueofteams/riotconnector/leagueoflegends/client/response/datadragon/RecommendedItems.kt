package com.leagueofteams.riotconnector.leagueoflegends.client.response.datadragon

import com.leagueofteams.riotconnector.leagueoflegends.client.constants.Map

data class RecommendedItems (

        val champion: String,
        val title: String,
        val map: Map,
        val mode: String, //GameMode
        val type: String,
        val customTag: String,
        val sortrank: Int,
        val extensionPage: Boolean,
        val useObviousCheckmark: Boolean,
        val customPanel: Any?,
        val blocks: List<ItemBlocks>

)

