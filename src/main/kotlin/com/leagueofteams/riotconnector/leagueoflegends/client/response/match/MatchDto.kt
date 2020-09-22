package com.leagueofteams.riotconnector.leagueoflegends.client.response.match

data class MatchDto (

        val gameId: Long,
        val participantIdentities: Set<ParticipantIdentityDto>,
        val queueId: Int,
        val gameType: String,
        val gameDuration: Long,
        val teams: Set<TeamStatsDto>,
        val platformId: String,
        val gameCreation: Long,
        val seasonId: Int,
        val gameVersion: String,
        val mapId: Int,
        val gameMode: String,
        val participants: Set<ParticipantDto>

)