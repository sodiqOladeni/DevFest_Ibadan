package dev.hackwithsodiq.devfestibadan.view.team

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import dev.hackwithsodiq.devfestibadan.R
import dev.hackwithsodiq.devfestibadan.databinding.ModelSpeakersBinding
import dev.hackwithsodiq.devfestibadan.databinding.ModelTeamBinding
import dev.hackwithsodiq.devfestibadan.listeners.OnTeamLinkClickListeners
import dev.hackwithsodiq.devfestibadan.model.Schedule
import dev.hackwithsodiq.devfestibadan.model.Team

class TeamAdapter(private var linkClickListeners:OnTeamLinkClickListeners):ListAdapter<Team, TeamAdapter.ViewHolder>(
    DiffUtils()
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(
            parent
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position), linkClickListeners)
    }

    class ViewHolder private constructor(private val binding: ModelTeamBinding):RecyclerView.ViewHolder(binding.root){
        companion object {
            @LayoutRes
            val LAYOUT = R.layout.model_team

            fun from(parent: ViewGroup): ViewHolder {
                val withDataBinding: ModelTeamBinding = DataBindingUtil.inflate(
                    LayoutInflater.from(parent.context),
                    LAYOUT,
                    parent, false
                )
                return ViewHolder(
                    withDataBinding
                )
            }
        }

        fun bind(team: Team, linkClickListeners: OnTeamLinkClickListeners){
            binding.also {
                it.team = team
                it.executePendingBindings()
            }

            binding.teamTwitter.setOnClickListener {
                linkClickListeners.onLinkIconClicked(team.twitter)
            }
            binding.teamLink.setOnClickListener {
                linkClickListeners.onLinkIconClicked(team.webLink!!)
            }
        }
    }
}

class DiffUtils:DiffUtil.ItemCallback<Team>() {
    override fun areItemsTheSame(oldItem: Team, newItem: Team): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: Team, newItem: Team): Boolean {
        return oldItem == newItem
    }
}