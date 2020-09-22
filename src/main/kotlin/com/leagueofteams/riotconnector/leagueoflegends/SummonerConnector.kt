package com.leagueofteams.riotconnector.leagueoflegends

import com.leagueofteams.riotconnector.leagueoflegends.client.response.summoner.SummonerDTO

interface SummonerConnector {
    fun getSummonerByAccountId(encryptedAccountId: String): SummonerDTO
    fun getSummonerBySummonerId(encryptedSummonerId: String): SummonerDTO
    fun getSummonerByPUUID(puuid: String): SummonerDTO
    fun getSummonerBySummonerName(summonerName: String): SummonerDTO
}