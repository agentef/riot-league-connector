package com.leagueofteams.riotconnector.leagueoflegends.client.client

import com.leagueofteams.riotconnector.leagueoflegends.client.configuration.ClientConfiguration
import com.leagueofteams.riotconnector.leagueoflegends.client.response.datadragon.Languages
import com.leagueofteams.riotconnector.leagueoflegends.client.response.datadragon.Version
import com.leagueofteams.riotconnector.leagueoflegends.client.response.datadragon.champion.ChampionDetails
import com.leagueofteams.riotconnector.leagueoflegends.client.response.datadragon.champion.ChampionsResponse
import feign.Param
import feign.RequestLine
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@FeignClient(url = "\${connector.league.data-dragon.url}", name = "\${connector.league.data-dragon.name}", configuration = [ClientConfiguration::class])
interface DataDragonClient {

    @RequestLine("GET /api/versions.json")
    fun getVersion(): List<String>

    @RequestLine("GET /cdn/languages.json")
    fun getLanguages(): Languages

    @RequestLine("GET /cdn/{version}/data/{region}/champion.json")
    fun getChampions(@Param("version") version: String, @Param("region") region: String): ChampionsResponse

    @RequestLine("GET /cdn/{version}/data/{region}/champion/{champion}.json")
    fun getChampionDetailsByName(@Param("version") version: String, @Param("region") region: String, @Param("champion") champion: String): ChampionDetails

}