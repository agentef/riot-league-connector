package com.leagueofteams.riotconnector.leagueoflegends.client.response.match

data class MatchEventDto (

        var laneType: String,
        var skillSlot: Int,
        var ascendedType: String,
        var creatorId: Int,
        var afterId: Int,
        var eventType: String,
        var type: MatchEventType,
        var levelUpType: String,
        var wardType: String,
        var participantId: Int,
        var towerType: String,
        var itemId: Int,
        var beforeId: Int,
        var pointCaptured: String,
        var monsterType: String,
        var monsterSubType: String,
        var teamId: Int,
        var position: MatchPositionDto,
        var killerId: Int,
        var timestamp: Long,
        var assistingParticipantIds: Set<Int>,
        var buildingType: String,
        var victimId: Int

)