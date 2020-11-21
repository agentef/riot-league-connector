package com.leagueofteams.riotconnector.leagueoflegends.exception.error

import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatus.*

enum class MatchError(val code: String, val status: HttpStatus, val description: String) {

    MATCH_NOT_FOUND_ERROR       ("RM-001", NOT_FOUND, "Match(es) not found."),
    REQUEST_LIMIT_EXCEEDED      ("RM-002", TOO_MANY_REQUESTS, "Request limit exceeded. Try again later."),
    NOT_EXISTING_PARAMETERS     ("RM-003", BAD_REQUEST, "One or more parameters were not found."),
    INVALID_API_KEY             ("RM-004", FORBIDDEN, "Something is wrong with the current API Key."),
    UNKNOWN_ERROR               ("RM-999", INTERNAL_SERVER_ERROR, "Unknown error: "),


}