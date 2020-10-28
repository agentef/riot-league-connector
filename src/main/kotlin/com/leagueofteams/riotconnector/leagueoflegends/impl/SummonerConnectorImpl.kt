package com.leagueofteams.riotconnector.leagueoflegends.impl

import com.leagueofteams.riotconnector.leagueoflegends.SummonerConnector
import com.leagueofteams.riotconnector.leagueoflegends.client.client.SummonerClient
import com.leagueofteams.riotconnector.leagueoflegends.client.constants.RegionUrl
import com.leagueofteams.riotconnector.leagueoflegends.client.response.summoner.SummonerDTO
import com.leagueofteams.riotconnector.leagueoflegends.exception.RiotException
import com.leagueofteams.riotconnector.leagueoflegends.exception.error.SummonerError
import com.leagueofteams.riotconnector.leagueoflegends.exception.SummonerException
import org.springframework.http.HttpStatus.NOT_FOUND
import org.springframework.stereotype.Service
import java.net.URI

@Service
class SummonerConnectorImpl(
        private val summonerClient: SummonerClient
) : SummonerConnector {

    override
    fun getSummonerByAccountId(encryptedAccountId: String, region: RegionUrl): SummonerDTO {
        try {
            return summonerClient.getSummonerByAccountId(URI(region.urlPrefix), encryptedAccountId)
        } catch (ex: RiotException) {
            when (ex.statusCode) {
                NOT_FOUND -> throw SummonerException(SummonerError.SUMMONER_NOT_FOUND_ERROR)
                else -> throw SummonerException(SummonerError.UNKNOWN_ERROR)
            }
        }
    }

    override
    fun getSummonerBySummonerId(region: RegionUrl, encryptedSummonerId: String): SummonerDTO {
        try {
            return summonerClient.getSummonerBySummonerId(URI(region.urlPrefix), encryptedSummonerId)
        } catch (ex: RiotException) {
            when (ex.statusCode) {
                NOT_FOUND -> throw SummonerException(SummonerError.SUMMONER_NOT_FOUND_ERROR)
                else -> throw SummonerException(SummonerError.UNKNOWN_ERROR)
            }
        }
    }

    override
    fun getSummonerByPUUID(region: RegionUrl, puuid: String): SummonerDTO {
        try {
            return summonerClient.getSummonerByPUUID(URI(region.urlPrefix), puuid)
        } catch (ex: RiotException) {
            when (ex.statusCode) {
                NOT_FOUND -> throw SummonerException(SummonerError.SUMMONER_NOT_FOUND_ERROR)
                else -> throw SummonerException(SummonerError.UNKNOWN_ERROR)
            }
        }
    }

    override
    fun getSummonerBySummonerName(region: RegionUrl, summonerName: String): SummonerDTO {
        try {
            return summonerClient.getSummonerBySummonerName(URI(region.urlPrefix), summonerName)
        } catch (ex: RiotException) {
            when (ex.statusCode) {
                NOT_FOUND -> throw SummonerException(SummonerError.SUMMONER_NOT_FOUND_ERROR)
                else -> throw SummonerException(SummonerError.UNKNOWN_ERROR)
            }
        }
    }

}