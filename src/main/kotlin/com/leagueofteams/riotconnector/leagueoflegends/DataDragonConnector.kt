package com.leagueofteams.riotconnector.leagueoflegends

import com.leagueofteams.riotconnector.leagueoflegends.client.response.datadragon.Languages
import com.leagueofteams.riotconnector.leagueoflegends.client.response.datadragon.Version
import com.leagueofteams.riotconnector.leagueoflegends.client.response.datadragon.champion.ChampionData
import com.leagueofteams.riotconnector.leagueoflegends.client.response.datadragon.champion.ChampionDetails
import com.leagueofteams.riotconnector.leagueoflegends.client.response.datadragon.champion.ChampionsResponse

interface DataDragonConnector {

    fun getVersions(): List<String>
    fun getLanguages(): Languages
    fun getChampionsByVersion(version: List<String>, region: String): ChampionsResponse
    fun getChampionDetails(version: List<String>, region: String, champion: ChampionData): ChampionDetails

}