package com.korab.footballmanager.ui.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.korab.footballmanager.R
import com.korab.footballmanager.databinding.FragmentTeamDetailsBinding
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * @author korab.muhadri
 */
class TeamDetailsFragment : Fragment() {
    private val viewModel by viewModel<TeamDetailsViewModel>()
    private var teamId: Int? = null
    private var finalPosition: Int? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        val binding = FragmentTeamDetailsBinding.inflate(inflater, container, false)

        arguments?.let {
            teamId = it.getInt("teamId")
            finalPosition = it.getInt("index")
        }

        teamId?.let { id ->
            lifecycleScope.launch {
                viewModel.getTeamDetails(id).collect { team ->
                    team?.let {
                        binding.teamName.text = it.name
                        binding.teamPoints.text = getString(R.string.points, it.points.toString())
                        binding.goalDifference.text =
                            getString(R.string.goal_difference, it.goalDifference.toString())
                        binding.finalPosition.text =
                            getString(
                                R.string.final_position,
                                (
                                    finalPosition?.plus(
                                        1,
                                    )
                                ).toString(),
                            )
                        binding.teamCity.text = it.city
                        binding.teamCoach.text = it.coachName
                    }
                }
            }
        }

        return binding.root
    }
}
