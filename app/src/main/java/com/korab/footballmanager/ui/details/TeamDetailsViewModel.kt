package com.korab.footballmanager.ui.details

import androidx.lifecycle.ViewModel
import com.korab.footballmanager.data.Team
import com.korab.footballmanager.domain.LeagueRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

/**
 * @author korab.muhadri
 */
class TeamDetailsViewModel(
    private val repository: LeagueRepository,
) : ViewModel() {
    fun getTeamDetails(teamId: Int): Flow<Team?> = repository.observeAllTeams().map { teams -> teams.find { it.id == teamId } }
}
