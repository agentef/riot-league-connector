package com.leagueofteams.riotconnector.leagueoflegends.impl

import com.leagueofteams.riotconnector.leagueoflegends.DataDragonConnector
import com.leagueofteams.riotconnector.leagueoflegends.client.client.DataDragonClient
import com.leagueofteams.riotconnector.leagueoflegends.client.response.datadragon.Languages
import com.leagueofteams.riotconnector.leagueoflegends.client.response.datadragon.Version
import com.leagueofteams.riotconnector.leagueoflegends.client.response.datadragon.champion.ChampionData
import com.leagueofteams.riotconnector.leagueoflegends.client.response.datadragon.champion.ChampionDetails
import com.leagueofteams.riotconnector.leagueoflegends.client.response.datadragon.champion.ChampionsResponse
import org.springframework.stereotype.Service

@Service
class DataDragonConnectorImpl (
        private val dataDragonClient: DataDragonClient
) : DataDragonConnector {

    override
    fun getLanguages(): Languages {
        return dataDragonClient.getLanguages()
    }

    override
    fun getVersions(): List<String> {
        return dataDragonClient.getVersion()
    }

    override
    fun getChampionsByVersion(version: List<String>, region: String): ChampionsResponse {
        return dataDragonClient.getChampions(version[0], region)
    }

    override
    fun getChampionDetails(version: List<String>, region: String, champion: ChampionData): ChampionDetails {
        return dataDragonClient.getChampionDetailsByName(version[0], region, champion.name)
    }
}