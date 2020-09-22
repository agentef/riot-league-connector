package com.leagueofteams.riotconnector.leagueoflegends.client.response.match

data class MatchReferenceDto (

    val gameId: Long,
    val role: String,
    val season: Int,
    val platformId: String,
    val champion: Int,
    val queue: Int,
    val lane: String,
    val timestamp: Long

)
