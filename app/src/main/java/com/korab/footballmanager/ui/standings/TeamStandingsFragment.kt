package com.korab.footballmanager.ui.standings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.korab.footballmanager.R
import com.korab.footballmanager.data.Team
import com.korab.footballmanager.databinding.FragmentTeamStandingsBinding
import com.korab.footballmanager.ui.LeagueViewModel
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * @author korab.muhadri
 */
class TeamStandingsFragment : Fragment() {
    private val viewModel by viewModel<LeagueViewModel>()
    private lateinit var teamAdapter: TeamAdapter
    private lateinit var binding: FragmentTeamStandingsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentTeamStandingsBinding.inflate(inflater, container, false)
        teamAdapter = TeamAdapter { team, index -> onTeamClicked(team, index) }
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = teamAdapter
        }

        binding.simulateBtn.setOnClickListener { viewModel.simulateAllMatches() }

        lifecycleScope.launch { subscribeUI() }

        return binding.root
    }

    private suspend fun subscribeUI() {
        viewModel.observeAllTeams().collect { teams ->
            val sortedTeams = teams.sortedByDescending { it.points }
            teamAdapter.submitList(sortedTeams)
        }
    }

    private fun onTeamClicked(
        team: Team,
        index: Int,
    ) {
        findNavController().navigate(
            R.id.action_teamStandingsFragment_to_teamDetailsFragment,
            bundleOf("teamId" to team.id, "index" to index),
        )
    }
}
