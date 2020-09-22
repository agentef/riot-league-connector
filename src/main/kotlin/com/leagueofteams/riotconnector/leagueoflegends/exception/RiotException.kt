package com.leagueofteams.riotconnector.leagueoflegends.exception

import org.springframework.http.HttpStatus

open class RiotException(
        var apiName: String? = null,
        var statusCode: HttpStatus,
        var errorCode: String? = null,
        var description: String

) : RuntimeException() {
    constructor(statusCode: HttpStatus, description: String) : this(null, statusCode, null, description)
}