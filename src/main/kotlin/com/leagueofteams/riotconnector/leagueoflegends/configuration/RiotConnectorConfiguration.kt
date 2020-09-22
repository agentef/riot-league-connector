package com.leagueofteams.riotconnector.leagueoflegends.configuration

import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration

@Configuration
@ComponentScan(basePackages = ["com.leagueofteams.riotconnector.leagueoflegends"])
@EnableFeignClients(basePackages = ["com.leagueofteams.riotconnector.leagueoflegends"])
class RiotConnectorConfiguration
