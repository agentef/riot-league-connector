package com.leagueofteams.riotconnector.leagueoflegends.exception

import com.leagueofteams.riotconnector.leagueoflegends.exception.error.LeagueError

class LeagueException(leagueError: LeagueError) : RiotException(
        "Riot League API",
        leagueError.status,
        leagueError.code,
        leagueError.description
)