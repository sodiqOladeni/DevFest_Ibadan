package dev.hackwithsodiq.devfestibadan.view.schedule

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.google.android.flexbox.AlignItems
import com.google.android.flexbox.FlexDirection
import com.google.android.flexbox.FlexWrap
import com.google.android.flexbox.FlexboxLayoutManager
import dev.hackwithsodiq.devfestibadan.R
import dev.hackwithsodiq.devfestibadan.databinding.ModelScheduleItemBinding
import dev.hackwithsodiq.devfestibadan.model.Schedule

class ScheduleDisplayAdapter(private var context:Context):ListAdapter<Schedule, ScheduleDisplayAdapter.ViewHolder>(DiffUtils()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position), context)
    }

    class ViewHolder private constructor(private val binding:ModelScheduleItemBinding):RecyclerView.ViewHolder(binding.root){
        companion object {
            @LayoutRes
            val LAYOUT = R.layout.model_schedule_item

            fun from(parent: ViewGroup): ViewHolder {
                val withDataBinding: ModelScheduleItemBinding = DataBindingUtil.inflate(
                    LayoutInflater.from(parent.context), ViewHolder.LAYOUT,
                    parent, false
                )
                return ViewHolder(withDataBinding)
            }
        }

        fun bind(
            schedule: Schedule,
            context: Context
        ){
            binding.also {
                it.schedule = schedule
                it.recyclerView.apply {
                    val flexLayoutManager = FlexboxLayoutManager(context)
                    flexLayoutManager.flexWrap = FlexWrap.WRAP
                    flexLayoutManager.flexDirection = FlexDirection.ROW
                    flexLayoutManager.alignItems = AlignItems.STRETCH
                    layoutManager = flexLayoutManager
                    adapter = TagsRecyclerViewAdapter(schedule.tracks)
                }
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