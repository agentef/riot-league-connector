package com.leagueofteams.riotconnector.leagueoflegends

import com.leagueofteams.riotconnector.leagueoflegends.client.response.match.MatchDto
import com.leagueofteams.riotconnector.leagueoflegends.client.response.match.MatchTimelineDto
import com.leagueofteams.riotconnector.leagueoflegends.client.response.match.MatchlistDto

interface MatchConnector {

    fun getMatchByMatchId(matchId: Long): MatchDto
    fun getMatchByMatchIdAndTournamentCode(matchId: Long, tournamentCode: String): MatchDto
    fun getMatchIdsByTournamentCode(tournamentCode: String): List<Long>
    fun getMatchTimeLineByMatchId(matchId: Long): MatchTimelineDto
    fun getMatchesByEncryptedAccountId(accountId: String): MatchlistDto

}