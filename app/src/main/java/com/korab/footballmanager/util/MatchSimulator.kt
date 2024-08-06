package com.korab.footballmanager.util

import com.korab.footballmanager.domain.LeagueRepository
import kotlinx.coroutines.flow.first

/**
 * @author korab.muhadri
 * @param repository, League Repository that is responsible for all fixtures/teams (insert, read etc)
 */
class MatchSimulator(
    private val repository: LeagueRepository,
) {
    suspend fun simulateMatches() {
        val fixtures = repository.observeAllFixtures().first()
        fixtures.forEach { fixture ->
            val homeGoals = (0..5).random()
            val awayGoals = (0..5).random()

            val homeTeam = repository.getTeamById(fixture.homeTeamId)
            val awayTeam = repository.getTeamById(fixture.awayTeamId)

            homeTeam.goalsFor += homeGoals
            homeTeam.goalsAgainst += awayGoals
            awayTeam.goalsFor += awayGoals
            awayTeam.goalsAgainst += homeGoals

            when {
                homeGoals > awayGoals -> {
                    homeTeam.points += 3
                }
                homeGoals < awayGoals -> {
                    awayTeam.points += 3
                }
                else -> {
                    homeTeam.points += 1
                    awayTeam.points += 1
                }
            }

            repository.updateTeam(homeTeam)
            repository.updateTeam(awayTeam)
        }
    }
}
