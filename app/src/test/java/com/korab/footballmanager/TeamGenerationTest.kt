package com.korab.footballmanager

import com.korab.footballmanager.data.Team
import junit.framework.TestCase.assertTrue
import org.junit.Test

/**
 * @author korab.muhadri
 */
class TeamGenerationTest {
    private val teamNames = (1..20).map { "Team $it" }
    private val coaches = (1..20).map { "Coach $it" }

    private fun generateTeams(): List<Team> {
        val shuffledTeamNames = teamNames.shuffled()
        val shuffledCoaches = coaches.shuffled()

        return (1..20).map { i ->
            Team(
                name = shuffledTeamNames[i - 1],
                coachName = shuffledCoaches[i - 1],
                city = "random city",
            )
        }
    }

    @Test
    fun `generateTeams should produce unique team names`() {
        val teams = generateTeams()
        val teamNames = teams.map { it.name }
        assertTrue(teamNames.toSet().size == teamNames.size)
    }

    @Test
    fun `generateTeams should produce unique coach names`() {
        val teams = generateTeams()

        val coachNames = teams.map { it.coachName }
        assertTrue(coachNames.toSet().size == coachNames.size)
    }
}
