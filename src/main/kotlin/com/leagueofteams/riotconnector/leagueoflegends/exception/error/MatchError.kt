package com.leagueofteams.riotconnector.leagueoflegends.exception.error

import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatus.*

enum class MatchError(val code: String, val status: HttpStatus, val description: String) {

    MATCH_NOT_FOUND_ERROR       ("RM-001", NOT_FOUND, "Match not found."),
    INVALID_QUEUE              ("RM-001", NOT_FOUND, "Match not found."),
    UNKNOWN_ERROR               ("RM-999", INTERNAL_SERVER_ERROR, "Unknown error: "),


}