package com.korab.footballmanager.util

import com.korab.footballmanager.data.Fixture
import com.korab.footballmanager.data.Team

/**
 * @author korab.muhadri
 */
object FixtureGenerator {
    /**
     * @param teams generated teams from TeamGenerator to generate fixtures
     * Each team plays each other team once (per 20 teams, there are 380 matches)
     */
    fun generateFixtures(teams: List<Team>): List<Fixture> {
        val fixtures = mutableListOf<Fixture>()

        for (i in teams.indices) {
            for (j in i + 1 until teams.size) {
                val homeTeam = teams[i]
                val awayTeam = teams[j]

                // Create home and away fixtures
                fixtures.add(Fixture(homeTeamId = homeTeam.id, awayTeamId = awayTeam.id))
                fixtures.add(Fixture(homeTeamId = awayTeam.id, awayTeamId = homeTeam.id))
            }
        }

        return fixtures
    }
}
