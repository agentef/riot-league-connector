package com.leagueofteams.riotconnector.leagueoflegends.impl

import com.leagueofteams.riotconnector.leagueoflegends.MatchConnector
import com.leagueofteams.riotconnector.leagueoflegends.client.client.MatchClient
import com.leagueofteams.riotconnector.leagueoflegends.client.constants.Queue
import com.leagueofteams.riotconnector.leagueoflegends.client.constants.RegionUrl
import com.leagueofteams.riotconnector.leagueoflegends.client.response.datadragon.champion.ChampionData
import com.leagueofteams.riotconnector.leagueoflegends.client.response.match.MatchDto
import com.leagueofteams.riotconnector.leagueoflegends.client.response.match.MatchTimelineDto
import com.leagueofteams.riotconnector.leagueoflegends.client.response.match.MatchlistDto
import com.leagueofteams.riotconnector.leagueoflegends.exception.MatchException
import com.leagueofteams.riotconnector.leagueoflegends.exception.RiotException
import com.leagueofteams.riotconnector.leagueoflegends.exception.error.MatchError
import org.springframework.http.HttpStatus.*
import org.springframework.stereotype.Service
import java.net.URI
import java.time.LocalDateTime
import java.time.ZoneOffset

@Service
class MatchConnectorImpl(
        private val matchClient: MatchClient
) : MatchConnector {

    override
    fun getMatchByMatchId(region: RegionUrl, matchId: Long): MatchDto {
        try {
            return matchClient.getMatchByMatchId(URI(region.urlPrefix), matchId)
        } catch (ex: RiotException) {
            when (ex.statusCode) {
                FORBIDDEN -> throw MatchException(MatchError.INVALID_API_KEY)
                TOO_MANY_REQUESTS -> throw MatchException(MatchError.REQUEST_LIMIT_EXCEEDED)
                NOT_FOUND -> throw MatchException(MatchError.MATCH_NOT_FOUND_ERROR)
                else -> throw MatchException(MatchError.UNKNOWN_ERROR, ex.statusCode)
            }
        }
    }

    override
    fun getMatchByMatchIdAndTournamentCode(region: RegionUrl, matchId: Long, tournamentCode: String): MatchDto {
        try {
            return matchClient.getMatchByMatchIdAndTournamentCode(URI(region.urlPrefix), matchId, tournamentCode)
        } catch (ex: RiotException) {
            when (ex.statusCode) {
                FORBIDDEN -> throw MatchException(MatchError.INVALID_API_KEY)
                TOO_MANY_REQUESTS -> throw MatchException(MatchError.REQUEST_LIMIT_EXCEEDED)
                NOT_FOUND -> throw MatchException(MatchError.MATCH_NOT_FOUND_ERROR)
                else -> throw MatchException(MatchError.UNKNOWN_ERROR)
            }
        }
    }

    override
    fun getMatchIdsByTournamentCode(tournamentCode: String, region: RegionUrl): List<Long> {
        try {
            return matchClient.getMatchIdsByTournamentCode(URI(region.urlPrefix), tournamentCode)
        } catch (ex: RiotException) {
            when (ex.statusCode) {
                FORBIDDEN -> throw MatchException(MatchError.INVALID_API_KEY)
                TOO_MANY_REQUESTS -> throw MatchException(MatchError.REQUEST_LIMIT_EXCEEDED)
                NOT_FOUND -> throw MatchException(MatchError.MATCH_NOT_FOUND_ERROR)
                else -> throw MatchException(MatchError.UNKNOWN_ERROR)
            }
        }
    }

    override
    fun getMatchTimeLineByMatchId(region: RegionUrl, matchId: Long): MatchTimelineDto {
        try {
            return matchClient.getMatchTimeLineByMatchId(URI(region.urlPrefix), matchId)
        } catch (ex: RiotException) {
            when (ex.statusCode) {
                FORBIDDEN -> throw MatchException(MatchError.INVALID_API_KEY)
                TOO_MANY_REQUESTS -> throw MatchException(MatchError.REQUEST_LIMIT_EXCEEDED)
                NOT_FOUND -> throw MatchException(MatchError.MATCH_NOT_FOUND_ERROR)
                else -> throw MatchException(MatchError.UNKNOWN_ERROR)
            }
        }
    }

    override
    fun getMatchesByEncryptedAccountId(
            region: RegionUrl,
            accountId: String,
            champion: ChampionData?,
            queue: Queue?,
            endTime: LocalDateTime?,
            beginTime: LocalDateTime?,
            endIndex: Int?,
            beginIndex: Int?
    ): MatchlistDto {
        try {
            val params = hashMapOf<String, Any>()
            if (champion != null) params["champion"] = champion.name
            if (queue != null) params["queue"] = queue.id
            if (endTime != null) params["endTime"] = endTime.toInstant(ZoneOffset.ofHours(-3)).toEpochMilli()
            if (beginTime != null) params["beginTime"] = beginTime.toInstant(ZoneOffset.ofHours(-3)).toEpochMilli()
            if (endIndex != null) params["endIndex"] = endIndex
            if (beginIndex != null) params["beginIndex"] = beginIndex
            return matchClient.getMatchesByEncryptedAccountId(URI(region.urlPrefix), accountId, params)
        } catch (ex: RiotException) {
            when (ex.statusCode) {
                FORBIDDEN -> throw MatchException(MatchError.INVALID_API_KEY)
                TOO_MANY_REQUESTS -> throw MatchException(MatchError.REQUEST_LIMIT_EXCEEDED)
                NOT_FOUND -> throw MatchException(MatchError.MATCH_NOT_FOUND_ERROR)
                else -> throw MatchException(MatchError.UNKNOWN_ERROR)
            }
        }
    }

}