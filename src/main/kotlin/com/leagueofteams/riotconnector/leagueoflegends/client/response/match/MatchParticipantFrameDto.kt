package com.leagueofteams.riotconnector.leagueoflegends.client.response.match

data class MatchParticipantFrameDto (

        var participantId: Int,
        var minionsKilled: Int,
        var teamScore: Int,
        var dominionScore: Int,
        var totalGold: Int,
        var level: Int,
        var xp: Int,
        var currentGold: Int,
        var position: MatchPositionDto,
        var jungleMinionsKilled: Int

)