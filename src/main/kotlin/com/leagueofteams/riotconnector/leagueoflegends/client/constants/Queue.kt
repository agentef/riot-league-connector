package com.leagueofteams.riotconnector.leagueoflegends.client.constants

import com.leagueofteams.riotconnector.leagueoflegends.exception.MatchException
import com.leagueofteams.riotconnector.leagueoflegends.exception.RiotException
import com.leagueofteams.riotconnector.leagueoflegends.exception.error.MatchError
import org.springframework.http.HttpStatus

enum class Queue(val id: Int, val map: String, val description: String?, val notes: String?) {

    CUSTOM                      (0,         "Custom games",         null,                                       null),
    SR_RANKED_SOLO              (420,       "Summoner's Rift",      "5v5 Ranked Solo games",                    null),
    SR_BLIND_PICK               (430,       "Summoner's Rift",      "5v5 Blind Pick games",                     null),
    SR_RANKED_FLEX              (440,       "Summoner's Rift",      "5v5 Ranked Flex games",                    null),
    HA_ARAM                     (450,       "Howling Abyss",        "5v5 ARAM games",                           null),
    SR_BLOOD_HUNT               (600,       "Summoner's Rift",      "Blood Hunt Assassin games",                null),
    COSMIC_RUINS_DARK_STAR      (610,       "Cosmic Ruins",         "Dark Star: Singularity games",             null),
    CLASH                       (700,       "Summoner's Rift",      "Clash games",                              null),
    TT_COOP_BEGINNER            (820,       "Twisted Treeline",     "Co-op vs. AI Beginner Bot games",          null),
    SR_COOP_INTRO               (830,       "Summoner's Rift",      "Co-op vs. AI Intro Bot games",             null),
    SR_COOP_BEGINNER            (840,       "Summoner's Rift",      "Co-op vs. AI Beginner Bot games",          null),
    SR_COOP_INTERMEDIATE        (850,       "Summoner's Rift",      "Co-op vs. AI Intermediate Bot games",      null),
    SR_URF_V2                   (900,       "Summoner's Rift",      "URF games",                                null),
    CS_ASCENSION                (910,       "Crystal Scar",         "Ascension games",                          null),
    HA_LEGEND_PORO_KING         (920,       "Howling Abyss",        "Legend of the Poro King games",            null),
    SR_NEXUS_SIEGE              (940,       "Summoner's Rift",      "Nexus Siege games",                        null),
    SR_DOOM_BOTS                (950,       "Summoner's Rift",      "Doom Bots Voting games",                   null),
    SR_DOOM_BOTS_STANDARD       (960,       "Summoner's Rift",      "Doom Bots Standard games",                 null),
    STAR_GUARDIAN_NORMAL        (980,       "Valoran City Park",    "Star Guardian Invasion: Normal games",     null),
    STAR_GUARDIAN_ONSLAUGHT     (990,       "Valoran City Park",    "Star Guardian Invasion: Onslaught games",  null),
    OVERCHARGE_PROJECT_HUNTERS  (1000,      "Overcharge",           "PROJECT: Hunters games",                   null),
    SR_SNOW_ARURF               (1010,      "Summoner's Rift",      "Snow ARURF games",                         null),
    SR_ONE_FOR_ALL              (1020,      "Summoner's Rift",      "One for All games",                        null),
    ODYSSEY_INTRO               (1030,      "Crash Site",           "Odyssey Extraction: Intro games",          null),
    ODYSSEY_CADET               (1040,      "Crash Site",           "Odyssey Extraction: Cadet games",          null),
    ODYSSEY_CREWMEMBER          (1050,      "Crash Site",           "Odyssey Extraction: Crewmember games",     null),
    ODYSSEY_CAPTAIN             (1060,      "Crash Site",           "Odyssey Extraction: Captain games",        null),
    ODYSSEY_ONSLAUGHT           (1070,      "Crash Site",           "Odyssey Extraction: Onslaught games",      null),
    CONVERGENCE_TFT             (1090,      "Convergence",          "Teamfight Tactics games",                  null),
    CONVERGENCE_TFT_RANKED      (1100,      "Convergence",          "Ranked Teamfight Tactics games",           null),
    CONVERGENCE_TFT_TUTORIAL    (1110,      "Convergence",          "Teamfight Tactics Tutorial games",         null),
    SR_TUTORIAL_1               (2000,      "Summoner's Rift",      "Tutorial 1",                               null),
    SR_TUTORIAL_2               (2010,      "Summoner's Rift",      "Tutorial 2",                               null),
    SR_TUTORIAL_3               (2020,      "Summoner's Rift",      "Tutorial 3",                               null),
    SR_ALL_RANDOM               (325,       "Summoner's Rift",      "All Random games",                         null),
    SR_DRAFT_PICK               (400,       "Summoner's Rift",      "5v5 Draft Pick games",                     null),
    CS_DEF_NOT_DOMINION         (317,       "Crystal Scar",         "Definitely Not Dominion games",            null),
    SR_NEMESIS                  (310,       "Summoner's Rift",      "Nemesis games",                            null),
    SR_BLACK_MARKET_BRAWLERS    (313,       "Summoner's Rift",      "Black Market Brawlers games",              null),
    TT_HEXAKILL                 (98,        "Twisted Treeline",     "6v6 Hexakill games",                       null),
    BB_ARAM                     (100,       "Butcher's Bridge",     "5v5 ARAM games",                           null),
    HA_SNOWDOWN_SHOWDOWN_1X1    (72,        "Howling Abyss",        "1v1 Snowdown Showdown games",              null),
    HA_SNOWDOWN_SHOWDOWN_2X2    (73,        "Howling Abyss",        "2v2 Snowdown Showdown games",              null),
    SR_HEXAKILL                 (75,        "Summoner's Rift",      "6v6 Hexakill games",                       null),
    SR_URF_OLD                  (76,        "Summoner's Rift",      "Ultra Rapid Fire games",                   null),
    HA_ONE_FOR_ALL_MIRROR       (78,        "Howling Abyss",        "One For All: Mirror Mode games",           null),
    SR_URF_COOP_VS_AI           (83,        "Summoner's Rift",      "Co-op vs AI Ultra Rapid Fire games",       null),



    @Deprecated("Deprecated in favor of queueId 430")
    SR_BLIND_PICK_OLD           (2,         "Summoner's Rift",      "5v5 Blind Pick games",                     "Deprecated in patch 7.19 in favor of queueId 430"),
    @Deprecated("Deprecated in favor of queueId 420")
    SR_RANKED_SOLO_OLD          (4,         "Summoner's Rift",      "5v5 Ranked Solo games",                    "Deprecated in favor of queueId 420"),
    @Deprecated("Game mode deprecated")
    SR_PREMADE_RANKED           (6,         "Summoner's Rift",      "5v5 Ranked Premade games",                 "Game mode deprecated"),
    @Deprecated("Deprecated in favor of queueId 32 and 33")
    SR_COOP_VS_AI_OLD           (7,         "Summoner's Rift",      "Co-op vs AI games",                        "Deprecated in favor of queueId 32 and 33"),
    @Deprecated("Deprecated in patch 7.19 in favor of queueId 460")
    TT_NORMAL                   (8,         "Twisted Treeline",     "3v3 Normal games",                         "Deprecated in patch 7.19 in favor of queueId 460"),
    @Deprecated("Deprecated in patch 7.19 in favor of queueId 470")
    TT_RANKED_FLEX_OLD          (9,         "Twisted Treeline",     "3v3 Ranked Flex games",                    "Deprecated in patch 7.19 in favor of queueId 470"),
    @Deprecated("Deprecated in favor of queueId 400")
    SR_DRAFT_PICK_OLD           (14,        "Summoner's Rift",      "5v5 Draft Pick games",                     "Deprecated in favor of queueId 400"),
    @Deprecated("Game mode deprecated")
    CS_BLIND_PICK               (16,        "Crystal Scar",         "5v5 Dominion Blind Pick games",            "Game mode deprecated"),
    @Deprecated("Game mode deprecated")
    CS_DRAFT_PICK               (17,        "Crystal Scar",         "5v5 Dominion Draft Pick games",            "Game mode deprecated"),
    @Deprecated("Game mode deprecated")
    CS_COOP_VS_API              (25,        "Crystal Scar",         "Dominion Co-op vs AI games",               "Game mode deprecated"),
    @Deprecated("Deprecated in patch 7.19 in favor of queueId 830")
    SR_COOP_INTRO_OLD           (31,        "Summoner's Rift",      "Co-op vs AI Intro Bot games",              "Deprecated in patch 7.19 in favor of queueId 830"),
    @Deprecated("Deprecated in patch 7.19 in favor of queueId 840")
    R_COOP_BEGINNER_OLD         (32,        "Summoner's Rift",      "Co-op vs AI Beginner Bot games",           "Deprecated in patch 7.19 in favor of queueId 840"),
    @Deprecated("Deprecated in patch 7.19 in favor of queueId 850")
    SR_COOP_INTERMEDIATE_OLD    (33,        "Summoner's Rift",      "Co-op vs AI Intermediate Bot games",       "Deprecated in patch 7.19 in favor of queueId 850"),
    @Deprecated("Game mode deprecated")
    TT_TEAM_RANKED              (41,        "Twisted Treeline",     "3v3 Ranked Team games",                    "Game mode deprecated"),
    @Deprecated("Game mode deprecated")
    SR_TEAM_RANKED              (42,        "Summoner's Rift",      "5v5 Ranked Team games",                    "Game mode deprecated"),
    @Deprecated("Deprecated in patch 7.19 in favor of queueId 800")
    TT_COOP_VS_AI               (52,        "Twisted Treeline",     "Co-op vs AI games",                        "Deprecated in patch 7.19 in favor of queueId 800"),
    @Deprecated("Game mode deprecated")
    SR_TEAM_BUILDER             (61,        "Summoner's Rift",      "5v5 Team Builder games",                   "Game mode deprecated"),
    @Deprecated("Deprecated in patch 7.19 in favor of queueId 450")
    HA_ARAM_OLD                 (65,        "Howling Abyss",        "5v5 ARAM games",                           "Deprecated in patch 7.19 in favor of queueId 450"),
    @Deprecated("Game mode deprecated")
    HA_ARAM_COOP_VS_AI          (67,        "Howling Abyss",        "ARAM Co-op vs AI games",                   "Game mode deprecated"),
    @Deprecated("Deprecated in patch 8.6 in favor of queueId 1020")
    SR_ONE_FOR_ALL_OLD          (70,        "Summoner's Rift",      "One for All games",                        "Deprecated in patch 8.6 in favor of queueId 1020"),
    @Deprecated("Deprecated in patch 7.19 in favor of queueId 950")
    SR_DOOM_BOTS_1              (91,        "Summoner's Rift",      "Doom Bots Rank 1 games",                   "Deprecated in patch 7.19 in favor of queueId 950"),
    @Deprecated("Deprecated in patch 7.19 in favor of queueId 950")
    SR_DOOM_BOTS_2              (92,        "Summoner's Rift",      "Doom Bots Rank 2 games",                   "Deprecated in patch 7.19 in favor of queueId 950"),
    @Deprecated("Deprecated in patch 7.19 in favor of queueId 950")
    SR_DOOM_BOTS_3              (93,        "Summoner's Rift",      "Doom Bots Rank 5 games",                   "Deprecated in patch 7.19 in favor of queueId 950"),
    @Deprecated("Deprecated in patch 7.19 in favor of queueId 910")
    CS_ASCENSION_OLD            (96,        "Crystal Scar",         "Ascension games",                          "Deprecated in patch 7.19 in favor of queueId 910"),
    @Deprecated("Deprecated in patch 7.19 in favor of queueId 920")
    HA_PORO_KING                (300,       "Howling Abyss",        "Legend of the Poro King games",            "Deprecated in patch 7.19 in favor of queueId 920"),
    @Deprecated("Deprecated in patch 7.19 in favor of queueId 940")
    SR_NEXUS_SIEGE_OLD          (315,       "Summoner's Rift",      "Nexus Siege games",                        "Deprecated in patch 7.19 in favor of queueId 940"),
    @Deprecated("Deprecated in patch 7.19 in favor of queueId 900")
    SR_ARURF                    (318,       "Summoner's Rift",      "ARURF games",                              "Deprecated in patch 7.19 in favor of queueId 900"),
    @Deprecated("Game mode deprecated")
    SR_RANKED_DYNAMIC           (410,       "Summoner's Rift",      "5v5 Ranked Dynamic games",                 "Game mode deprecated in patch 6.22"),
    @Deprecated("Deprecated in patch 9.23")
    TT_BLIND_PICK               (460,       "Twisted Treeline",     "3v3 Blind Pick games",                     "Deprecated in patch 9.23"),
    @Deprecated("Deprecated in patch 9.23")
    TT_RANKED_FLEX              (470,       "Twisted Treeline",     "3v3 Ranked Flex games",                    "Deprecated in patch 9.23"),
    @Deprecated("Deprecated in patch 9.23")
    TT_COOP_INTERMEDIATE        (800,       "Twisted Treeline",     "Co-op vs. AI Intermediate Bot games",      "Deprecated in patch 9.23"),
    @Deprecated("Deprecated in patch 9.23")
    TT_COOP_INTRO               (810,       "Twisted Treeline",     "Co-op vs. AI Intro Bot games",             "Deprecated in patch 9.23"),
    @Deprecated("Deprecated in patch 9.2 (?)")
    NEXUS_BLITZ                 (1200,      "Nexus Blitz",          "Nexus Blitz games",                        "Deprecated in patch 9.2"),
    ;


    companion object {
        fun findById(id: Int): Queue {
            return values().toList().stream().filter {it.id == id}.findFirst().orElseThrow {
                throw RiotException(HttpStatus.BAD_REQUEST, "Invalid Queue Id was provided.")
            }
        }
    }
}