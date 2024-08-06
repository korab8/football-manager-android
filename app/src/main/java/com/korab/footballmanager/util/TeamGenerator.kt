package com.korab.footballmanager.util

import com.korab.footballmanager.data.Team

/**
 * Team Generator Singleton class
 * shuffled() method used to provide random yet unique names of coaches/teams
 */
object TeamGenerator {
    private val teamNames =
        listOf(
            "Team A",
            "Team B",
            "Team C",
            "Team D",
            "Team E",
            "Team F",
            "Team G",
            "Team H",
            "Team I",
            "Team J",
            "Team K",
            "Team L",
            "Team M",
            "Team N",
            "Team O",
            "Team P",
            "Team Q",
            "Team R",
            "Team S",
            "Team T",
        )
    private val coaches =
        listOf(
            "Coach A",
            "Coach B",
            "Coach C",
            "Coach D",
            "Coach E",
            "Coach F",
            "Coach G",
            "Coach H",
            "Coach I",
            "Coach J",
            "Coach K",
            "Coach L",
            "Coach M",
            "Coach N",
            "Coach O",
            "Coach P",
            "Coach Q",
            "Coach R",
            "Coach S",
            "Coach T",
        )
    private val cities = listOf("Prishtine", "Peje", "Gjilan", "Ferizaj", "Gjakove", "Mitrovice", "Prizren")

    fun generateTeams(): List<Team> {
        val shuffledTeamNames = teamNames.shuffled()
        val shuffledCoaches = coaches.shuffled()

        return (1..20).map { i ->
            Team(
                name = shuffledTeamNames[i - 1],
                coachName = shuffledCoaches[i - 1],
                city = cities.random(),
            )
        }
    }
}
