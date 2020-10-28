package com.leagueofteams.riotconnector.leagueoflegends.client.client

import com.leagueofteams.riotconnector.leagueoflegends.client.configuration.ClientConfiguration
import com.leagueofteams.riotconnector.leagueoflegends.client.response.summoner.SummonerDTO
import feign.Param
import feign.RequestLine
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import java.net.URI

@FeignClient(name = "\${connector.league.summoner.name}", configuration = [ClientConfiguration::class])
interface SummonerClient {

    @RequestLine("GET /lol/summoner/v4/summoners/by-account/{encryptedAccountId}")
    fun getSummonerByAccountId(urlPrefix: URI, @Param("encryptedAccountId") encryptedAccountId: String): SummonerDTO

    @RequestLine("GET /lol/summoner/v4/summoners/by-name/{summonerName}")
    fun getSummonerBySummonerName(urlPrefix: URI, @Param("summonerName") summonerName: String): SummonerDTO

    @RequestLine("GET /lol/summoner/v4/summoners/by-puuid/{encryptedPUUID}")
    fun getSummonerByPUUID(urlPrefix: URI, @Param("encryptedPUUID") encryptedPUUID: String): SummonerDTO

    @RequestLine("GET /lol/summoner/v4/summoners/{encryptedSummonerId}")
    fun getSummonerBySummonerId(urlPrefix: URI, @Param("encryptedSummonerId") encryptedSummonerId: String): SummonerDTO

}