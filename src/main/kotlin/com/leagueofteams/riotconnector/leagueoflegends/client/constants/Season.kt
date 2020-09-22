package com.leagueofteams.riotconnector.leagueoflegends.client.constants

import com.leagueofteams.riotconnector.leagueoflegends.exception.RiotException
import org.springframework.http.HttpStatus

enum class Season(var id: Int) {

    PRESEASON_3            (0),
    SEASON_3               (1),
    PRESEASON_2014         (2),
    SEASON_2014            (3),
    PRESEASON_2015         (4),
    SEASON_2015            (5),
    PRESEASON_2016         (6),
    SEASON_2016            (7),
    PRESEASON_2017         (8),
    SEASON_2017            (9),
    PRESEASON_2018         (10),
    SEASON_2018            (11),
    PRESEASON_2019         (12),
    SEASON_2019            (13),
    ;

    fun findById(id: Int): Season {
        return values().toSet().stream().filter { it.id.equals(id) }.findFirst().orElseThrow {
            RiotException(HttpStatus.BAD_REQUEST, "Invalid Season Id was provided. If you believe this was a mistake, please try and update your dependency.")
        }
    }

}