package com.leagueofteams.riotconnector.leagueoflegends.client.client

import com.leagueofteams.riotconnector.leagueoflegends.client.configuration.ClientConfiguration
import com.leagueofteams.riotconnector.leagueoflegends.client.response.league.LeagueEntryDTO
import com.leagueofteams.riotconnector.leagueoflegends.client.response.league.LeagueListDTO
import feign.Param
import feign.RequestLine
import org.springframework.cloud.openfeign.FeignClient
import java.net.URI

@FeignClient(name = "\${connector.league.league.name}", configuration = [ClientConfiguration::class])
interface LeagueClient {

    @RequestLine("GET /lol/league/v4/challengerleagues/by-queue/{queue}")
    fun getChallengerLeagueByQueue(urlPrefix: URI, @Param("queue") queue: String): LeagueListDTO

    @RequestLine("GET /lol/league/v4/entries/by-summoner/{encryptedSummonerId}")
    fun getLeagueEntriesBySummonerId(urlPrefix: URI, @Param("encryptedSummonerId") encryptedSummonerId: String): List<LeagueEntryDTO>

    @RequestLine("GET /lol/league/v4/entries/{queue}/{tier}/{division}")
    fun getAllTheLeagueEntries(
            urlPrefix: URI,
            @Param("queue") queue: String,
            @Param("tier") tier: String,
            @Param("division") division: String
    ): List<LeagueEntryDTO>

    @RequestLine("GET /lol/league/v4/grandmasterleagues/by-queue/{queue}")
    fun getGrandmasterLeagueByQueue(urlPrefix: URI, @Param("queue") queue: String): LeagueListDTO

    @RequestLine("GET /lol/league/v4/leagues/{leagueId}")
    fun getLeagueByLeagueId(urlPrefix: URI, @Param("leagueId") leagueId: Long): LeagueListDTO

    @RequestLine("GET /lol/league/v4/masterleagues/by-queue/{queue}")
    fun getMasterLeagueByQueue(urlPrefix: URI, @Param("queue") queue: String): LeagueListDTO

}