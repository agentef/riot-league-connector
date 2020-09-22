package com.leagueofteams.riotconnector.leagueoflegends.client.response.match

data class MatchlistDto (

        val startIndex: Int,
        val totalGames: Int,
        val endIndex: Int,
        val matches: Set<MatchReferenceDto>

)
