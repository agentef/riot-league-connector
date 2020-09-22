package com.leagueofteams.riotconnector.leagueoflegends.impl

import com.leagueofteams.riotconnector.leagueoflegends.SummonerConnector
import com.leagueofteams.riotconnector.leagueoflegends.client.client.SummonerClient
import com.leagueofteams.riotconnector.leagueoflegends.client.response.summoner.SummonerDTO
import com.leagueofteams.riotconnector.leagueoflegends.exception.RiotException
import com.leagueofteams.riotconnector.leagueoflegends.exception.error.SummonerError
import com.leagueofteams.riotconnector.leagueoflegends.exception.SummonerException
import org.springframework.http.HttpStatus.NOT_FOUND
import org.springframework.stereotype.Service

@Service
class SummonerConnectorImpl(
        private val summonerClient: SummonerClient
) : SummonerConnector {

    override
    fun getSummonerByAccountId(encryptedAccountId: String): SummonerDTO {
        try {
            return summonerClient.getSummonerByAccountId(encryptedAccountId)
        } catch (ex: RiotException) {
            when (ex.statusCode) {
                NOT_FOUND -> throw SummonerException(SummonerError.SUMMONER_NOT_FOUND_ERROR)
                else -> throw SummonerException(SummonerError.UNKNOWN_ERROR)
            }
        }
    }

    override
    fun getSummonerBySummonerId(encryptedSummonerId: String): SummonerDTO {
        try {
            return summonerClient.getSummonerBySummonerId(encryptedSummonerId)
        } catch (ex: RiotException) {
            when (ex.statusCode) {
                NOT_FOUND -> throw SummonerException(SummonerError.SUMMONER_NOT_FOUND_ERROR)
                else -> throw SummonerException(SummonerError.UNKNOWN_ERROR)
            }
        }
    }

    override
    fun getSummonerByPUUID(puuid: String): SummonerDTO {
        try {
            return summonerClient.getSummonerByPUUID(puuid)
        } catch (ex: RiotException) {
            when (ex.statusCode) {
                NOT_FOUND -> throw SummonerException(SummonerError.SUMMONER_NOT_FOUND_ERROR)
                else -> throw SummonerException(SummonerError.UNKNOWN_ERROR)
            }
        }
    }

    override
    fun getSummonerBySummonerName(summonerName: String): SummonerDTO {
        try {
            return summonerClient.getSummonerBySummonerName(summonerName)
        } catch (ex: RiotException) {
            when (ex.statusCode) {
                NOT_FOUND -> throw SummonerException(SummonerError.SUMMONER_NOT_FOUND_ERROR)
                else -> throw SummonerException(SummonerError.UNKNOWN_ERROR)
            }
        }
    }

}