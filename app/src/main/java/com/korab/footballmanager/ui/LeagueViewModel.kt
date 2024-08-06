package com.korab.footballmanager.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.korab.footballmanager.data.Team
import com.korab.footballmanager.domain.LeagueRepository
import com.korab.footballmanager.util.FixtureGenerator
import com.korab.footballmanager.util.MatchSimulator
import com.korab.footballmanager.util.TeamGenerator
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

/**
 * @author korab.muhadri
 */
class LeagueViewModel(
    private val repository: LeagueRepository,
) : ViewModel() {
    fun observeAllTeams(): Flow<List<Team>> = repository.observeAllTeams()

    // generate teams and fixtures on viewModel initialization
    init {
        viewModelScope.launch {
            generateTeams()
            generateFixtures()
        }
    }

    private suspend fun generateTeams() {
        val teams = TeamGenerator.generateTeams()
        repository.insertTeams(teams)
    }

    private suspend fun generateFixtures() {
        val teamList = repository.observeAllTeams().first()
        val fixtures = FixtureGenerator.generateFixtures(teamList)
        repository.insertFixtures(fixtures)
    }

    fun simulateAllMatches() {
        viewModelScope.launch {
            generateTeams()
            generateFixtures()
            MatchSimulator(repository).simulateMatches()
        }
    }
}
