package dev.hackwithsodiq.devfestibadan.view.speaker

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import dev.hackwithsodiq.devfestibadan.R
import dev.hackwithsodiq.devfestibadan.databinding.ModelSpeakersBinding
import dev.hackwithsodiq.devfestibadan.model.Schedule

class SpeakerAdapter:ListAdapter<Schedule, SpeakerAdapter.ViewHolder>(DiffUtils()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ViewHolder private constructor(private val binding:ModelSpeakersBinding):RecyclerView.ViewHolder(binding.root){
        companion object {
            @LayoutRes
            val LAYOUT = R.layout.model_speakers

            fun from(parent: ViewGroup): ViewHolder {
                val withDataBinding: ModelSpeakersBinding = DataBindingUtil.inflate(
                    LayoutInflater.from(parent.context), ViewHolder.LAYOUT,
                    parent, false
                )
                return ViewHolder(withDataBinding)
            }
        }

        fun bind(schedule: Schedule){
            binding.also {
                it.speaker = schedule
                it.executePendingBindings()
            }
        }
    }
}

class DiffUtils:DiffUtil.ItemCallback<Schedule>() {
    override fun areItemsTheSame(oldItem: Schedule, newItem: Schedule): Boolean {
        return oldItem.scheduleId == newItem.scheduleId
    }

    override fun areContentsTheSame(oldItem: Schedule, newItem: Schedule): Boolean {
        return oldItem == newItem
    }
}