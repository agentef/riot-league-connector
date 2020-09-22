package com.leagueofteams.riotconnector.leagueoflegends.exception.error

import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatus.*

enum class SummonerError(val code: String, val status: HttpStatus, val description: String) {

    SUMMONER_NOT_FOUND_ERROR        ("RS-001", NOT_FOUND, "Summoner not found."),
    ACCOUNT_NOT_FOUND_ERROR         ("RS-002", NOT_FOUND, "Account not found."),

    UNKNOWN_ERROR                   ("RS-999", NOT_FOUND, "Unknown error."),


}