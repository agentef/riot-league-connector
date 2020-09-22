package com.leagueofteams.riotconnector.leagueoflegends.client.response.match

data class ParticipantDto (

        val participantId: Int,
        val championId: Int,
        val runes: Set<RuneDto>,
        val stats: ParticipantStatsDto,
        val teamId: Int,
        val timeline: ParticipantTimelineDto,
        val spell1Id: Int,
        val spell2Id: Int,
        val highestAchievedSeasonTier: String,
        val masteries: Set<MasteryDto>

)