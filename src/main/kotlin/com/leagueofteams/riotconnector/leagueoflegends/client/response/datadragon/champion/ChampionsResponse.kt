package com.leagueofteams.riotconnector.leagueoflegends.client.response.datadragon.champion

import com.leagueofteams.riotconnector.leagueoflegends.client.response.datadragon.DataDragonType

data class ChampionsResponse (

        val type: DataDragonType,

        val format: String,

        val version: String,

        val data: Map<String, ChampionData>

)