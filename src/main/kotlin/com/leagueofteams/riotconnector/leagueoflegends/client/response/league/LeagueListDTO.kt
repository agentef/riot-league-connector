package com.leagueofteams.riotconnector.leagueoflegends.client.response.league

data class LeagueListDTO (

        var leagueId: String,
        var entries: Set<LeagueItemDTO>,
        var tier: String,
        var name: String,
        var queue: String
)