package com.leagueofteams.riotconnector.leagueoflegends

import com.leagueofteams.riotconnector.leagueoflegends.client.constants.RegionUrl
import com.leagueofteams.riotconnector.leagueoflegends.client.request.league.Division
import com.leagueofteams.riotconnector.leagueoflegends.client.request.league.Queue
import com.leagueofteams.riotconnector.leagueoflegends.client.request.league.Tier
import com.leagueofteams.riotconnector.leagueoflegends.client.response.league.LeagueEntryDTO
import com.leagueofteams.riotconnector.leagueoflegends.client.response.league.LeagueListDTO

interface LeagueConnector {

    fun getChallengerLeagueByQueue(region: RegionUrl, queue: Queue): LeagueListDTO
    fun getGrandmasterLeagueByQueue(region: RegionUrl, queue: Queue): LeagueListDTO
    fun getMasterLeagueByQueue(region: RegionUrl, queue: Queue): LeagueListDTO
    fun getAllTheLeagueEntries(region: RegionUrl, queue: Queue, division: Division, tier: Tier): List<LeagueEntryDTO>
    fun getLeagueByLeagueId(region: RegionUrl, leagueId: Long): LeagueListDTO
    fun getLeagueEntriesBySummonerId(summonerId: String, region: RegionUrl): List<LeagueEntryDTO>

}