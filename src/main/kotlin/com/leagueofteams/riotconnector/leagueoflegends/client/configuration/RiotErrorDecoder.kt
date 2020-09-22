package com.leagueofteams.riotconnector.leagueoflegends.client.configuration

import com.leagueofteams.riotconnector.leagueoflegends.exception.RiotException
import feign.Response
import feign.codec.ErrorDecoder
import org.springframework.http.HttpStatus

class RiotErrorDecoder : ErrorDecoder {

    override fun decode(methodKey: String, response: Response): Exception {
        return RiotException(HttpStatus.valueOf(response.status()), response.reason())
    }

}