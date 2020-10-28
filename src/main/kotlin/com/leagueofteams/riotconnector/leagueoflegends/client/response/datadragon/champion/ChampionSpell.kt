package com.leagueofteams.riotconnector.leagueoflegends.client.response.datadragon.champion

data class ChampionSpell (

        val id: String,
        val name: String,
        val description: String,
        val tooltip: String,
        val leveltip: List<LevelTip>,
        val maxrank: Int,
        val cooldown: List<Int>,
        val cooldownBurn: String,
        val cost: List<Int>,
        val costBurn: String,
        val datavalues: Any?,
        val effect: List<List<Int>?>,
        val effectBurn: List<String?>,
        val vars: List<Any?>,
        val costType: String,
        val maxammo: String,
        val range: List<Int>,
        val rangeBurn: String,
        val image: SpellImage,
        val resource: String



)