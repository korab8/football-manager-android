package com.korab.footballmanager.ui.standings

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.korab.footballmanager.R
import com.korab.footballmanager.data.Team
import com.korab.footballmanager.databinding.ItemTeamBinding

/**
 * @author korab.muhadri
 */
class TeamAdapter(
    private val onTeamClicked: (Team, Int) -> Unit,
) : ListAdapter<Team, TeamAdapter.TeamViewHolder>(TeamDiffCallback()) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): TeamViewHolder {
        val binding = ItemTeamBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TeamViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: TeamViewHolder,
        position: Int,
    ) {
        val team = getItem(position)
        holder.bind(team, onTeamClicked)
    }

    class TeamViewHolder(
        private val binding: ItemTeamBinding,
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(
            team: Team,
            onTeamClicked: (Team, Int) -> Unit,
        ) {
            binding.teamName.text = team.name
            binding.teamPoints.text = binding.root.context.getString(R.string.points, team.points.toString())
            binding.teamCity.text = team.city
            binding.teamCoach.text = team.coachName
            binding.root.setOnClickListener { onTeamClicked(team, adapterPosition) }
        }
    }

    class TeamDiffCallback : DiffUtil.ItemCallback<Team>() {
        override fun areItemsTheSame(
            oldItem: Team,
            newItem: Team,
        ): Boolean = oldItem.id == newItem.id

        override fun areContentsTheSame(
            oldItem: Team,
            newItem: Team,
        ): Boolean = oldItem == newItem
    }
}
