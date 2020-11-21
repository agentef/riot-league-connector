package com.leagueofteams.riotconnector.leagueoflegends.impl

import com.leagueofteams.riotconnector.leagueoflegends.LeagueConnector
import com.leagueofteams.riotconnector.leagueoflegends.client.client.LeagueClient
import com.leagueofteams.riotconnector.leagueoflegends.client.constants.RegionUrl
import com.leagueofteams.riotconnector.leagueoflegends.client.request.league.Division
import com.leagueofteams.riotconnector.leagueoflegends.client.request.league.Queue
import com.leagueofteams.riotconnector.leagueoflegends.client.request.league.Tier
import com.leagueofteams.riotconnector.leagueoflegends.client.response.league.LeagueEntryDTO
import com.leagueofteams.riotconnector.leagueoflegends.client.response.league.LeagueListDTO
import com.leagueofteams.riotconnector.leagueoflegends.exception.LeagueException
import com.leagueofteams.riotconnector.leagueoflegends.exception.RiotException
import com.leagueofteams.riotconnector.leagueoflegends.exception.error.LeagueError
import org.springframework.http.HttpStatus.*
import org.springframework.stereotype.Service
import java.net.URI

@Service
class LeagueConnectorImpl(
        private val leagueClient: LeagueClient
) : LeagueConnector {

    override
    fun getChallengerLeagueByQueue(region: RegionUrl, queue: Queue): LeagueListDTO {
        try {
            return leagueClient.getChallengerLeagueByQueue(URI(region.urlPrefix), queue.name)
        } catch (ex: RiotException) {
            when (ex.statusCode) {
                TOO_MANY_REQUESTS -> throw LeagueException(LeagueError.REQUEST_LIMIT_EXCEEDED)
                BAD_REQUEST -> throw LeagueException(LeagueError.INVALID_LEAGUE)
                NOT_FOUND -> throw LeagueException(LeagueError.LEAGUE_NOT_FOUND_ERROR)
                else -> throw LeagueException(LeagueError.UNKNOWN_ERROR)
            }
        }
    }

    override
    fun getGrandmasterLeagueByQueue(region: RegionUrl, queue: Queue): LeagueListDTO {
        try {
            return leagueClient.getGrandmasterLeagueByQueue(URI(region.urlPrefix), queue.name)
        } catch (ex: RiotException) {
            when (ex.statusCode) {
                FORBIDDEN -> throw LeagueException(LeagueError.INVALID_API_KEY)
                TOO_MANY_REQUESTS -> throw LeagueException(LeagueError.REQUEST_LIMIT_EXCEEDED)
                BAD_REQUEST -> throw LeagueException(LeagueError.INVALID_LEAGUE)
                NOT_FOUND -> throw LeagueException(LeagueError.LEAGUE_NOT_FOUND_ERROR)
                else -> throw LeagueException(LeagueError.UNKNOWN_ERROR)
            }
        }
    }

    override
    fun getMasterLeagueByQueue(region: RegionUrl, queue: Queue): LeagueListDTO {
        try {
            return leagueClient.getMasterLeagueByQueue(URI(region.urlPrefix), queue.name)
        } catch (ex: RiotException) {
            when (ex.statusCode) {
                FORBIDDEN -> throw LeagueException(LeagueError.INVALID_API_KEY)
                TOO_MANY_REQUESTS -> throw LeagueException(LeagueError.REQUEST_LIMIT_EXCEEDED)
                BAD_REQUEST -> throw LeagueException(LeagueError.INVALID_LEAGUE)
                NOT_FOUND -> throw LeagueException(LeagueError.LEAGUE_NOT_FOUND_ERROR)
                else -> throw LeagueException(LeagueError.UNKNOWN_ERROR)
            }
        }
    }

    override
    fun getAllTheLeagueEntries(region: RegionUrl, queue: Queue, division: Division, tier: Tier): List<LeagueEntryDTO> {
        try {
            return leagueClient.getAllTheLeagueEntries(URI(region.urlPrefix), queue.name, division.name, tier.name)
        } catch (ex: RiotException) {
            when (ex.statusCode) {
                FORBIDDEN -> throw LeagueException(LeagueError.INVALID_API_KEY)
                TOO_MANY_REQUESTS -> throw LeagueException(LeagueError.REQUEST_LIMIT_EXCEEDED)
                BAD_REQUEST -> throw LeagueException(LeagueError.INVALID_LEAGUE)
                NOT_FOUND -> throw LeagueException(LeagueError.LEAGUE_NOT_FOUND_ERROR)
                else -> throw LeagueException(LeagueError.UNKNOWN_ERROR)
            }
        }
    }

    override
    fun getLeagueByLeagueId(region: RegionUrl, leagueId: Long): LeagueListDTO {
        try {
            return leagueClient.getLeagueByLeagueId(URI(region.urlPrefix), leagueId)
        } catch (ex: RiotException) {
            when (ex.statusCode) {
                FORBIDDEN -> throw LeagueException(LeagueError.INVALID_API_KEY)
                TOO_MANY_REQUESTS -> throw LeagueException(LeagueError.REQUEST_LIMIT_EXCEEDED)
                BAD_REQUEST -> throw LeagueException(LeagueError.INVALID_LEAGUE)
                NOT_FOUND -> throw LeagueException(LeagueError.LEAGUE_NOT_FOUND_ERROR)
                else -> throw LeagueException(LeagueError.UNKNOWN_ERROR)
            }
        }
    }

    override fun getLeagueEntriesBySummonerId(summonerId: String, region: RegionUrl): List<LeagueEntryDTO> {
        try {
            return leagueClient.getLeagueEntriesBySummonerId(URI(region.urlPrefix), summonerId)
        } catch (ex: RiotException) {
            when (ex.statusCode) {
                FORBIDDEN -> throw LeagueException(LeagueError.INVALID_API_KEY)
                TOO_MANY_REQUESTS -> throw LeagueException(LeagueError.REQUEST_LIMIT_EXCEEDED)
                BAD_REQUEST -> throw LeagueException(LeagueError.INVALID_LEAGUE)
                NOT_FOUND -> throw LeagueException(LeagueError.LEAGUE_NOT_FOUND_ERROR)
                else -> throw LeagueException(LeagueError.UNKNOWN_ERROR)
            }
        }    }

}