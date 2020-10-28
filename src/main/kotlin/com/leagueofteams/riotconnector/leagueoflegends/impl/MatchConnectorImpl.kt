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
import com.leagueofteams.riotconnector.leagueoflegends.exception.error.MatchError
import com.leagueofteams.riotconnector.leagueoflegends.exception.RiotException
import org.springframework.beans.factory.annotation.Value
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
                INTERNAL_SERVER_ERROR -> throw MatchException(MatchError.MATCH_NOT_FOUND_ERROR)
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
                INTERNAL_SERVER_ERROR -> throw MatchException(MatchError.MATCH_NOT_FOUND_ERROR)
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
                INTERNAL_SERVER_ERROR -> throw MatchException(MatchError.MATCH_NOT_FOUND_ERROR)
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
                INTERNAL_SERVER_ERROR -> throw MatchException(MatchError.MATCH_NOT_FOUND_ERROR)
                else -> throw MatchException(MatchError.UNKNOWN_ERROR)
            }
        }
    }

    override
    fun getMatchesByEncryptedAccountId(
            region: RegionUrl,
            accountId: String,
            champion: Set<ChampionData>?,
            queue: Set<Queue>?,
            endTime: LocalDateTime?,
            beginTime: LocalDateTime?,
            endIndex: Int?,
            beginIndex: Int?
    ): MatchlistDto {
        try {
            var map = hashMapOf<String, Any>()
            if (champion != null) map["champion"] = champion.map { it.name }
            if (queue != null) map["queue"] = queue.map { it.id }
            if (endTime != null) map["endTime"] = endTime.toInstant(ZoneOffset.ofHours(-3)).toEpochMilli()
            if (beginTime != null) map["beginTime"] = beginTime.toInstant(ZoneOffset.ofHours(-3)).toEpochMilli()
            if (endIndex != null) map["endIndex"] = endIndex
            if (beginIndex != null) map["beginIndex"] = beginIndex
            return matchClient.getMatchesByEncryptedAccountId(
                    URI(region.urlPrefix),
                    accountId, map)
        } catch (ex: RiotException) {
            when (ex.statusCode) {
                INTERNAL_SERVER_ERROR -> throw MatchException(MatchError.MATCH_NOT_FOUND_ERROR)
                else -> throw MatchException(MatchError.UNKNOWN_ERROR)
            }
        }
    }

}