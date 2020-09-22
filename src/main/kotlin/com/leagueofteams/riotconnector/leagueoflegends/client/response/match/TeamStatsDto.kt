package com.leagueofteams.riotconnector.leagueoflegends.client.response.match

data class TeamStatsDto (

        val towerKills: Int,
        val riftHeraldKills: Int,
        val firstBlood: Boolean,
        val inhibitorKills: Int,
        val bans: Set<TeamBansDto>,
        val firstBaron: Boolean,
        val firstDragon: Boolean,
        val dominionVictoryScore: Int,
        val dragonKills: Int,
        val baronKills: Int,
        val firstInhibitor: Boolean,
        val firstTower: Boolean,
        val vilemawKills: Int,
        val firstRiftHerald: Boolean,
        val teamId: Int,
        val win: String

)