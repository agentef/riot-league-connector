package com.leagueofteams.riotconnector.leagueoflegends.client.client

import com.leagueofteams.riotconnector.leagueoflegends.client.configuration.ClientConfiguration
import com.leagueofteams.riotconnector.leagueoflegends.client.response.league.LeagueEntryDTO
import com.leagueofteams.riotconnector.leagueoflegends.client.response.league.LeagueListDTO
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestParam

@FeignClient(url = "\${connector.league.league.url}", name = "\${connector.league.league.name}", configuration = [ClientConfiguration::class] )
interface LeagueClient {

    @GetMapping("/lol/league/v4/challengerleagues/by-queue/{queue}")
    fun getChallengerLeagueByQueue(@PathVariable queue: String): LeagueListDTO

    @GetMapping("/lol/league/v4/entries/by-summoner/{encryptedSummonerId}")
    fun getLeagueEntriesBySummonerId(
            @PathVariable encryptedSummonerId: String,
            @RequestParam champion: List<Int>,
            @RequestParam queue: List<Int>,
            @RequestParam endTime: Long,
            @RequestParam beginTime: Long,
            @RequestParam endIndex: Int,
            @RequestParam beginIndex: Int
    ): List<LeagueEntryDTO>

    @GetMapping("/lol/league/v4/entries/{queue}/{tier}/{division}")
    fun getAllTheLeagueEntries(
            @PathVariable queue: String,
            @PathVariable tier: String,
            @PathVariable division: String
    ): List<LeagueEntryDTO>

    @GetMapping("/lol/league/v4/grandmasterleagues/by-queue/{queue}")
    fun getGrandmasterLeagueByQueue(@PathVariable queue: String): LeagueListDTO

    @GetMapping("/lol/league/v4/leagues/{leagueId}")
    fun getLeagueByLeagueId(@PathVariable leagueId: Long): LeagueListDTO

    @GetMapping("/lol/league/v4/masterleagues/by-queue/{queue}")
    fun getMasterLeagueByQueue(@PathVariable queue: String): LeagueListDTO

}