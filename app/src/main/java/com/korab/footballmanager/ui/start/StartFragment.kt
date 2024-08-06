package com.korab.footballmanager.ui.start

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.korab.footballmanager.R
import com.korab.footballmanager.databinding.FragmentStartBinding
import kotlinx.coroutines.launch

class StartFragment : Fragment() {
    private lateinit var binding: FragmentStartBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentStartBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?,
    ) {
        super.onViewCreated(view, savedInstanceState)
        binding.startBtn.setOnClickListener {
            lifecycleScope.launch {
                navigateToTeamStandings()
            }
        }
    }

    private fun navigateToTeamStandings() {
        findNavController().navigate(
            R.id.action_startFragment_to_teamStandingsFragment,
        )
    }
}
