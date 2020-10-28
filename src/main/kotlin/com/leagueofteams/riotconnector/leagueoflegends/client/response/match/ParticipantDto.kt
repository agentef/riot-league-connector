package com.leagueofteams.riotconnector.leagueoflegends.client.response.match

data class ParticipantDto (

        val participantId: Int,
        val teamId: Int,
        val championId: Int,
        val spell1Id: Int,
        val spell2Id: Int,
        val stats: ParticipantStatsDto,
        val timeline: ParticipantTimelineDto,
        val highestAchievedSeasonTier: String?

)