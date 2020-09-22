package com.leagueofteams.riotconnector.leagueoflegends.exception

import com.leagueofteams.riotconnector.leagueoflegends.exception.error.MatchError

class MatchException(matchError: MatchError) : RiotException(
        "Riot Match API",
        matchError.status,
        matchError.code,
        matchError.description
)