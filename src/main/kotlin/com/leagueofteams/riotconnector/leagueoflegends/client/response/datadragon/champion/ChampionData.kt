package com.leagueofteams.riotconnector.leagueoflegends.client.response.datadragon.champion

data class ChampionData (

        val version: String,
        val id: String,
        val key: Int,
        val name: String,
        val title: String,
        val blurb: String,
        val info: ChampionInfo,
        val image: ChampionImage,
        val tags: Set<ChampionTag>,
        val partype: String,
        val stats: ChampionStats

)