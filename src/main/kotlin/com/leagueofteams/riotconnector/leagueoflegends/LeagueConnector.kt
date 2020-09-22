package com.leagueofteams.riotconnector.leagueoflegends

import com.leagueofteams.riotconnector.leagueoflegends.client.request.league.Division
import com.leagueofteams.riotconnector.leagueoflegends.client.request.league.Queue
import com.leagueofteams.riotconnector.leagueoflegends.client.request.league.Tier
import com.leagueofteams.riotconnector.leagueoflegends.client.response.league.LeagueEntryDTO
import com.leagueofteams.riotconnector.leagueoflegends.client.response.league.LeagueListDTO

interface LeagueConnector {

    fun getChallengerLeagueByQueue(queue: Queue): LeagueListDTO
    fun getGrandmasterLeagueByQueue(queue: Queue): LeagueListDTO
    fun getMasterLeagueByQueue(queue: Queue): LeagueListDTO
    fun getAllTheLeagueEntries(queue: Queue, division: Division, tier: Tier): List<LeagueEntryDTO>
    fun getLeagueByLeagueId(leagueId: Long): LeagueListDTO

}