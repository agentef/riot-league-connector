package com.leagueofteams.riotconnector.leagueoflegends

import com.leagueofteams.riotconnector.leagueoflegends.client.constants.RegionUrl
import com.leagueofteams.riotconnector.leagueoflegends.client.response.summoner.SummonerDTO

interface SummonerConnector {
    fun getSummonerByAccountId(encryptedAccountId: String, region: RegionUrl): SummonerDTO
    fun getSummonerBySummonerId(region: RegionUrl, encryptedSummonerId: String): SummonerDTO
    fun getSummonerByPUUID(region: RegionUrl, puuid: String): SummonerDTO
    fun getSummonerBySummonerName(region: RegionUrl, summonerName: String): SummonerDTO
}