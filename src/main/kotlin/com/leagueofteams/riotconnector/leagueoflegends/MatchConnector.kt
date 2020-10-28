package com.leagueofteams.riotconnector.leagueoflegends

import com.leagueofteams.riotconnector.leagueoflegends.client.constants.Queue
import com.leagueofteams.riotconnector.leagueoflegends.client.constants.RegionUrl
import com.leagueofteams.riotconnector.leagueoflegends.client.response.datadragon.champion.ChampionData
import com.leagueofteams.riotconnector.leagueoflegends.client.response.match.MatchDto
import com.leagueofteams.riotconnector.leagueoflegends.client.response.match.MatchTimelineDto
import com.leagueofteams.riotconnector.leagueoflegends.client.response.match.MatchlistDto
import java.time.LocalDateTime

interface MatchConnector {

    fun getMatchByMatchId(region: RegionUrl, matchId: Long): MatchDto
    fun getMatchByMatchIdAndTournamentCode(region: RegionUrl, matchId: Long, tournamentCode: String): MatchDto
    fun getMatchIdsByTournamentCode(tournamentCode: String, region: RegionUrl): List<Long>
    fun getMatchTimeLineByMatchId(region: RegionUrl, matchId: Long): MatchTimelineDto

    fun getMatchesByEncryptedAccountId(region: RegionUrl, accountId: String, champion: Set<ChampionData>?, queue: Set<Queue>?, endTime: LocalDateTime?, beginTime: LocalDateTime?, endIndex: Int?, beginIndex: Int?): MatchlistDto
}