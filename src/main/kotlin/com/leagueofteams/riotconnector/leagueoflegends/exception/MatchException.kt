package com.leagueofteams.riotconnector.leagueoflegends.exception

import com.leagueofteams.riotconnector.leagueoflegends.exception.error.MatchError
import org.springframework.http.HttpStatus

class MatchException(matchError: MatchError, args: String) : RiotException(
        "Riot Match API",
        matchError.status,
        matchError.code,
        matchError.description + args
) {
    constructor(matchError: MatchError) : this(matchError, "")

    constructor(matchError: MatchError, args: HttpStatus) : this(matchError, args.value().toString())

}