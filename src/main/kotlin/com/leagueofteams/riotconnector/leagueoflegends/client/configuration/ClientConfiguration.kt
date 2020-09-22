package com.leagueofteams.riotconnector.leagueoflegends.client.configuration

import com.leagueofteams.riotconnector.leagueoflegends.configuration.Constant
import com.leagueofteams.riotconnector.leagueoflegends.configuration.EnvironmentProperty.API_KEY
import feign.RequestInterceptor
import feign.codec.ErrorDecoder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.env.Environment

@Configuration
class ClientConfiguration(private var env: Environment) {

    @Bean
    fun errorDecoder(): ErrorDecoder {
        return RiotErrorDecoder()
    }

    @Bean
    fun requestInterceptor(): RequestInterceptor {
        return RequestInterceptor { run { it.header(Constant.API_KEY_HEADER, env.getProperty(API_KEY)) } }
    }

}
