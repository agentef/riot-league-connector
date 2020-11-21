package com.leagueofteams.riotconnector.leagueoflegends.exception.error

import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatus.*

enum class LeagueError(val code: String, val status: HttpStatus, val description: String) {

    LEAGUE_NOT_FOUND_ERROR       ("RL-001", NOT_FOUND, "League not found."),
    INVALID_LEAGUE               ("RL-002", BAD_REQUEST, "Invalid league inserted."),
    REQUEST_LIMIT_EXCEEDED       ("RM-003", TOO_MANY_REQUESTS, "Request limit exceeded. Try again later."),
    INVALID_API_KEY              ("RM-004", FORBIDDEN, "Something is wrong with the current API Key."),
    UNKNOWN_ERROR                ("RL-999", INTERNAL_SERVER_ERROR, "Unknown error."),


}