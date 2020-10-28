package com.leagueofteams.riotconnector.leagueoflegends.client.response.datadragon.champion

import com.leagueofteams.riotconnector.leagueoflegends.client.response.datadragon.RecommendedItems
import com.leagueofteams.riotconnector.leagueoflegends.client.response.datadragon.Skin

data class ChampionDetailsData (

        val version: String,
        val id: String,
        val key: Int,
        val name: String,
        val title: String,
        val image: ChampionImage,
        val skins: List<Skin>,
        val lore: String,
        val blurb: String,
        val allytips: List<String>,
        val enemytips: List<String>,
        val tags: Set<ChampionTag>,
        val partype: String,
        val info: ChampionInfo,
        val stats: ChampionStats,
        val spells: List<ChampionSpell>,
        val passive: ChampionPassive,
        val recommended: List<RecommendedItems>

)