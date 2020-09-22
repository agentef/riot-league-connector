package com.leagueofteams.riotconnector.leagueoflegends.impl

import com.leagueofteams.riotconnector.leagueoflegends.LeagueConnector
import com.leagueofteams.riotconnector.leagueoflegends.client.client.LeagueClient
import com.leagueofteams.riotconnector.leagueoflegends.client.request.league.Division
import com.leagueofteams.riotconnector.leagueoflegends.client.request.league.Queue
import com.leagueofteams.riotconnector.leagueoflegends.client.request.league.Tier
import com.leagueofteams.riotconnector.leagueoflegends.client.response.league.LeagueEntryDTO
import com.leagueofteams.riotconnector.leagueoflegends.client.response.league.LeagueListDTO
import com.leagueofteams.riotconnector.leagueoflegends.exception.error.LeagueError
import com.leagueofteams.riotconnector.leagueoflegends.exception.LeagueException
import com.leagueofteams.riotconnector.leagueoflegends.exception.RiotException
import org.springframework.http.HttpStatus.BAD_REQUEST
import org.springframework.http.HttpStatus.NOT_FOUND
import org.springframework.stereotype.Service

@Service
class LeagueConnectorImpl(
        private val leagueClient: LeagueClient
) : LeagueConnector {

    override
    fun getChallengerLeagueByQueue(queue: Queue): LeagueListDTO {
        try {
            return leagueClient.getChallengerLeagueByQueue(queue.name)
        } catch (ex: RiotException) {
            when (ex.statusCode) {
                BAD_REQUEST -> throw LeagueException(LeagueError.INVALID_LEAGUE)
                NOT_FOUND -> throw LeagueException(LeagueError.LEAGUE_NOT_FOUND_ERROR)
                else -> throw LeagueException(LeagueError.UNKNOWN_ERROR)
            }
        }
    }

    override
    fun getGrandmasterLeagueByQueue(queue: Queue): LeagueListDTO {
        try {
            return leagueClient.getGrandmasterLeagueByQueue(queue.name)
        } catch (ex: RiotException) {
            when (ex.statusCode) {
                BAD_REQUEST -> throw LeagueException(LeagueError.INVALID_LEAGUE)
                NOT_FOUND -> throw LeagueException(LeagueError.LEAGUE_NOT_FOUND_ERROR)
                else -> throw LeagueException(LeagueError.UNKNOWN_ERROR)
            }
        }
    }

    override
    fun getMasterLeagueByQueue(queue: Queue): LeagueListDTO {
        try {
            return leagueClient.getMasterLeagueByQueue(queue.name)
        } catch (ex: RiotException) {
            when (ex.statusCode) {
                BAD_REQUEST -> throw LeagueException(LeagueError.INVALID_LEAGUE)
                NOT_FOUND -> throw LeagueException(LeagueError.LEAGUE_NOT_FOUND_ERROR)
                else -> throw LeagueException(LeagueError.UNKNOWN_ERROR)
            }
        }
    }

    override
    fun getAllTheLeagueEntries(queue: Queue, division: Division, tier: Tier): List<LeagueEntryDTO> {
        try {
            return leagueClient.getAllTheLeagueEntries(queue.name, division.name, tier.name)
        } catch (ex: RiotException) {
            when (ex.statusCode) {
                BAD_REQUEST -> throw LeagueException(LeagueError.INVALID_LEAGUE)
                NOT_FOUND -> throw LeagueException(LeagueError.LEAGUE_NOT_FOUND_ERROR)
                else -> throw LeagueException(LeagueError.UNKNOWN_ERROR)
            }
        }
    }

    override
    fun getLeagueByLeagueId(leagueId: Long): LeagueListDTO {
        try {
            return leagueClient.getLeagueByLeagueId(leagueId)
        } catch (ex: RiotException) {
            when (ex.statusCode) {
                BAD_REQUEST -> throw LeagueException(LeagueError.INVALID_LEAGUE)
                NOT_FOUND -> throw LeagueException(LeagueError.LEAGUE_NOT_FOUND_ERROR)
                else -> throw LeagueException(LeagueError.UNKNOWN_ERROR)
            }
        }
    }

}