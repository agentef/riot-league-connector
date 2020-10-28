package com.leagueofteams.riotconnector.leagueoflegends.client.client

import com.leagueofteams.riotconnector.leagueoflegends.client.configuration.ClientConfiguration
import com.leagueofteams.riotconnector.leagueoflegends.client.response.match.MatchDto
import com.leagueofteams.riotconnector.leagueoflegends.client.response.match.MatchTimelineDto
import com.leagueofteams.riotconnector.leagueoflegends.client.response.match.MatchlistDto
import feign.Param
import feign.QueryMap
import feign.RequestLine
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.RequestParam
import java.net.URI

@FeignClient(name = "\${connector.league.match.name}", configuration = [ClientConfiguration::class] )
interface MatchClient {

    @RequestLine("GET /lol/match/v4/matches/{matchId}")
    fun getMatchByMatchId(urlPrefix: URI, @Param("matchId") matchId: Long): MatchDto

    @RequestLine("GET /lol/match/v4/matchlists/by-account/{encryptedAccountId}")
    fun getMatchesByEncryptedAccountId(
            urlPrefix: URI,
            @Param("encryptedAccountId") encryptedAccountId: String,
            @QueryMap map: Map<String, Any>?
    ): MatchlistDto

    @RequestLine("GET /lol/match/v4/timelines/by-match/{matchId}")
    fun getMatchTimeLineByMatchId(urlPrefix: URI, @Param("matchId") matchId: Long): MatchTimelineDto

    @RequestLine("GET /lol/match/v4/matches/by-tournament-code/{tournamentCode}/ids")
    fun getMatchIdsByTournamentCode(urlPrefix: URI, @Param("tournamentCode") tournamentCode: String): List<Long>

    @RequestLine("GET /lol/match/v4/matches/{matchId}/by-tournament-code/{tournamentCode}")
    fun getMatchByMatchIdAndTournamentCode(
            urlPrefix: URI,
            @Param("matchId") matchId: Long,
            @Param("tournamentCode") tournamentCode: String
    ): MatchDto

}