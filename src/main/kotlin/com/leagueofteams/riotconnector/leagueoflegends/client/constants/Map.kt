package com.leagueofteams.riotconnector.leagueoflegends.client.constants

import com.leagueofteams.riotconnector.leagueoflegends.exception.RiotException
import org.springframework.http.HttpStatus

enum class Map (val id: Int, val mapName: String, val notes: String) {

    SUMMONERS_RIFT_SUMMER           (1, "Summoner's Rift", "Original Summer variant"),
    SUMMONERS_RIFT_AUTUMN           (2, "Summoner's Rift", "Original Autumn variant"),
    THE_PROVING_GROUNDS             (3, "The Proving Grounds", "Tutorial Map"),
    TWISTED_TREELINE_OLD            (4, "Twisted Treeline", "Original Version"),
    THE_CRYSTAL_SCAR                (8, "The Crystal Scar", "Dominion map"),
    TWISTED_TREELINE                (10, "Twisted Treeline", "Last TT map"),
    SUMMONERS_RIFT                  (11, "Summoner's Rift", "Current Version"),
    HA                              (12, "Howling Abyss", "ARAM map"),
    BUTCHERS_BRIDGE                 (14, "Butcher's Bridge", "Alternate ARAM map"),
    COSMIC_RUINS                    (16, "Cosmic Ruins", "Dark Star: Singularity map"),
    VALORAN_CITY_PARK               (18, "Valoran City Park", "Star Guardian Invasion map"),
    SUBSTRUCTURE_43                 (19, "Substructure 43", "PROJECT: Hunters map"),
    CRASH_SITE                      (20, "Crash Site", "Odyssey: Extraction map"),
    NEXUS_BLITZ                     (21, "Nexus Blitz", "Nexus Blitz map"),
    ;

    fun findById(id: Int): Map {
        return values().toSet().stream().filter { it.id == id }.findFirst().orElseThrow {
            RiotException(HttpStatus.BAD_REQUEST, "Invalid Map Id was provided. If you believe this was a mistake, please try and update your dependency.")
        }
    }

}