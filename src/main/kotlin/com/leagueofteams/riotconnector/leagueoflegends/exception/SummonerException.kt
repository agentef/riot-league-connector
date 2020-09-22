package com.leagueofteams.riotconnector.leagueoflegends.exception

import com.leagueofteams.riotconnector.leagueoflegends.exception.error.SummonerError

class SummonerException(summonerError: SummonerError) : RiotException(
        "Riot Summoner API",
        summonerError.status,
        summonerError.code,
        summonerError.description
)