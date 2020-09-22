package com.leagueofteams.riotconnector.leagueoflegends.client.client

import com.leagueofteams.riotconnector.leagueoflegends.client.configuration.ClientConfiguration
import com.leagueofteams.riotconnector.leagueoflegends.client.response.summoner.SummonerDTO
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@FeignClient(url = "\${connector.league.summoner.url}", name = "\${connector.league.summoner.name}", configuration = [ClientConfiguration::class] )
interface SummonerClient {

    @GetMapping("/lol/summoner/v4/summoners/by-account/{encryptedAccountId}")
    fun getSummonerByAccountId(@PathVariable encryptedAccountId: String): SummonerDTO

    @GetMapping("/lol/summoner/v4/summoners/by-name/{summonerName}")
    fun getSummonerBySummonerName(@PathVariable summonerName: String): SummonerDTO

    @GetMapping("/lol/summoner/v4/summoners/by-puuid/{encryptedPUUID}")
    fun getSummonerByPUUID(@PathVariable encryptedPUUID: String): SummonerDTO

    @GetMapping("/lol/summoner/v4/summoners/{encryptedSummonerId}")
    fun getSummonerBySummonerId(@PathVariable encryptedSummonerId: String): SummonerDTO

}