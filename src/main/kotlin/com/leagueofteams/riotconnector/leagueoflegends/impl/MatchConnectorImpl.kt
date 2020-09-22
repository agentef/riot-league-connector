package com.leagueofteams.riotconnector.leagueoflegends.impl

import com.leagueofteams.riotconnector.leagueoflegends.MatchConnector
import com.leagueofteams.riotconnector.leagueoflegends.client.client.MatchClient
import com.leagueofteams.riotconnector.leagueoflegends.client.response.match.MatchDto
import com.leagueofteams.riotconnector.leagueoflegends.client.response.match.MatchTimelineDto
import com.leagueofteams.riotconnector.leagueoflegends.client.response.match.MatchlistDto
import com.leagueofteams.riotconnector.leagueoflegends.exception.MatchException
import com.leagueofteams.riotconnector.leagueoflegends.exception.error.MatchError
import com.leagueofteams.riotconnector.leagueoflegends.exception.RiotException
import org.springframework.http.HttpStatus.*
import org.springframework.stereotype.Service

@Service
class MatchConnectorImpl(
        private val matchClient: MatchClient
) : MatchConnector {

    override
    fun getMatchByMatchId(matchId: Long): MatchDto {
        try {
            return matchClient.getMatchByMatchId(matchId)
        } catch (ex: RiotException) {
            when (ex.statusCode) {
                INTERNAL_SERVER_ERROR -> throw MatchException(MatchError.MATCH_NOT_FOUND_ERROR)
                else -> throw MatchException(MatchError.UNKNOWN_ERROR)
            }
        }
    }

    override
    fun getMatchByMatchIdAndTournamentCode(matchId: Long, tournamentCode: String): MatchDto {
        try {
            return matchClient.getMatchByMatchIdAndTournamentCode(matchId, tournamentCode)
        } catch (ex: RiotException) {
            when (ex.statusCode) {
                INTERNAL_SERVER_ERROR -> throw MatchException(MatchError.MATCH_NOT_FOUND_ERROR)
                else -> throw MatchException(MatchError.UNKNOWN_ERROR)
            }
        }
    }

    override
    fun getMatchIdsByTournamentCode(tournamentCode: String): List<Long> {
        try {
            return matchClient.getMatchIdsByTournamentCode(tournamentCode)
        } catch (ex: RiotException) {
            when (ex.statusCode) {
                INTERNAL_SERVER_ERROR -> throw MatchException(MatchError.MATCH_NOT_FOUND_ERROR)
                else -> throw MatchException(MatchError.UNKNOWN_ERROR)
            }
        }
    }

    override
    fun getMatchTimeLineByMatchId(matchId: Long): MatchTimelineDto {
        try {
            return matchClient.getMatchTimeLineByMatchId(matchId)
        } catch (ex: RiotException) {
            when (ex.statusCode) {
                INTERNAL_SERVER_ERROR -> throw MatchException(MatchError.MATCH_NOT_FOUND_ERROR)
                else -> throw MatchException(MatchError.UNKNOWN_ERROR)
            }
        }
    }

    override
    fun getMatchesByEncryptedAccountId(accountId: String): MatchlistDto {
        try {
            return matchClient.getMatchesByEncryptedAccountId(accountId)
        } catch (ex: RiotException) {
            when (ex.statusCode) {
                INTERNAL_SERVER_ERROR -> throw MatchException(MatchError.MATCH_NOT_FOUND_ERROR)
                else -> throw MatchException(MatchError.UNKNOWN_ERROR)
            }
        }
    }

}