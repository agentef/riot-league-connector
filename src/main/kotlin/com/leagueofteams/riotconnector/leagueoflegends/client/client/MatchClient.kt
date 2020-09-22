package com.leagueofteams.riotconnector.leagueoflegends.client.client

import com.leagueofteams.riotconnector.leagueoflegends.client.response.match.MatchDto
import com.leagueofteams.riotconnector.leagueoflegends.client.configuration.ClientConfiguration
import com.leagueofteams.riotconnector.leagueoflegends.client.response.match.MatchTimelineDto
import com.leagueofteams.riotconnector.leagueoflegends.client.response.match.MatchlistDto
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@FeignClient(url = "\${connector.league.match.url}", name = "\${connector.league.match.name}", configuration = [ClientConfiguration::class] )
interface MatchClient {

    @GetMapping("/v4/match/{matchId}")
    fun getMatchByMatchId(@PathVariable matchId: Long): MatchDto

    @GetMapping("/v4/matchlists/by-account/{encryptedAccountId}")
    fun getMatchesByEncryptedAccountId(@PathVariable encryptedAccountId: String): MatchlistDto

    @GetMapping("/lol/match/v4/timelines/by-match/{matchId}")
    fun getMatchTimeLineByMatchId(@PathVariable matchId: Long): MatchTimelineDto

    @GetMapping("/lol/match/v4/matches/by-tournament-code/{tournamentCode}/ids")
    fun getMatchIdsByTournamentCode(@PathVariable tournamentCode: String): List<Long>

    @GetMapping("/lol/match/v4/matches/{matchId}/by-tournament-code/{tournamentCode}")
    fun getMatchByMatchIdAndTournamentCode(
            @PathVariable matchId: Long,
            @PathVariable tournamentCode: String
    ): MatchDto

}