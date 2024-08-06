package com.korab.footballmanager.domain

import com.korab.footballmanager.data.Fixture
import com.korab.footballmanager.data.Team
import com.korab.footballmanager.data.persistance.LeagueDatabase

/**
 * @author korab.muhadri
 */
class LeagueRepository(
    leagueDatabase: LeagueDatabase,
) {
    private val teamDao = leagueDatabase.teamDao()
    private val fixtureDao = leagueDatabase.fixtureDao()

    fun observeAllTeams() = teamDao.getAllTeams()

    fun observeAllFixtures() = fixtureDao.getAllFixtures()

    suspend fun insertTeams(teams: List<Team>) {
        teamDao.clearAndInsertTeams(teams)
    }

    suspend fun insertFixtures(fixtures: List<Fixture>) {
        fixtureDao.clearAndInsertFixtures(fixtures)
    }

    suspend fun updateTeam(team: Team) {
        teamDao.updateTeam(team)
    }

    suspend fun getTeamById(id: Int): Team = teamDao.getTeamById(id)
}
