package com.leagueofteams.riotconnector.leagueoflegends.client.response.league

data class LeagueEntryDTO (

        var leagueId: String,
        var summonerId: String,
        var summonerName: String,
        var queueType: String,
        var tier: String,
        var rank: String,
        var leaguePoints: Int,
        var wins: Int,
        var losses: Int,
        var hotStreak: Boolean,
        var veteran: Boolean,
        var freshBlood: Boolean,
        var inactive: Boolean,
        var miniSeries: MiniSeriesDTO
)