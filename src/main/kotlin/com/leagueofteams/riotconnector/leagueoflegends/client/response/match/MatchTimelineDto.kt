package com.leagueofteams.riotconnector.leagueoflegends.client.response.match

data class MatchTimelineDto (

        var frames: Set<MatchFrameDto>,
        var frameInterval: Long

)