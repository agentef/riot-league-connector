package com.leagueofteams.riotconnector.leagueoflegends.client.response.league

data class LeagueItemDTO (

        var freshBlood: Boolean,
        var wins: Int,
        var summonerName: String,
        var miniSeries: MiniSeriesDTO,
        var inactive: Boolean,
        var veteran: Boolean,
        var hotStreak: Boolean,
        var rank: String,
        var leaguePoints: Int,
        var losses: Int,
        var summonerId: String
)