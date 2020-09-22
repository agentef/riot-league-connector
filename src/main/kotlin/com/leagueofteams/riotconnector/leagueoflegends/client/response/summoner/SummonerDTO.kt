package com.leagueofteams.riotconnector.leagueoflegends.client.response.summoner

data class SummonerDTO (

        var accountId: String,
        var profileIconId: Int,
        var revisionDate: Long,
        var name: String,
        var id: String,
        var puuid: String,
        var summonerLevel: Long
)
