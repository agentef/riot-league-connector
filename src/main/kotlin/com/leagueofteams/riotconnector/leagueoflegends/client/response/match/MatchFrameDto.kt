package com.leagueofteams.riotconnector.leagueoflegends.client.response.match

data class MatchFrameDto (

        var participantFrames: Map<String, MatchParticipantFrameDto>,
        var events: Set<MatchEventDto>,
        var timestamp: Long

)
