package dev.hackwithsodiq.devfestibadan.view.schedule

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import dev.hackwithsodiq.devfestibadan.R
import dev.hackwithsodiq.devfestibadan.databinding.FragmentScheduleBinding
import dev.hackwithsodiq.devfestibadan.utils.Methods
import dev.hackwithsodiq.devfestibadan.utils.filterSchedule
import dev.hackwithsodiq.devfestibadan.view.BaseFragment
import javax.inject.Inject

class ScheduleFragment : BaseFragment() {

    private lateinit var viewModel: ScheduleViewModel
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var binding:FragmentScheduleBinding
    private lateinit var scheduleAdapter:ScheduleDisplayAdapter
    private var sectionNumber: Int? = null

    override fun onCreateView(inflater: LayoutInflater,
        container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentScheduleBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(ScheduleViewModel::class.java).apply {
            sectionNumber = arguments?.getInt(ARG_SECTION_NUMBER) ?: 1
            setIndex(sectionNumber!!)
        }

        val animation = AnimationUtils.loadLayoutAnimation(context, R.anim.item_bottom_anim)
        scheduleAdapter = ScheduleDisplayAdapter(context!!)

        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            layoutAnimation = animation
            adapter = scheduleAdapter
        }

        viewModel.allSchedules.observe(this, Observer {
            binding.progressBar.visibility = View.GONE
            it?.let {
                if (it.isNullOrEmpty()){
                    binding.recyclerView.visibility = View.GONE
                    binding.emptyData.visibility = View.VISIBLE
                }else{
                    binding.recyclerView.visibility = View.VISIBLE
                    binding.emptyData.visibility = View.GONE
                    when(sectionNumber){
                        1 -> {
                            scheduleAdapter.submitList(filterSchedule("Android", it))
                        }
                        2 -> {
                            scheduleAdapter.submitList(filterSchedule("Cloud", it))
                        }
                        3 -> {
                            scheduleAdapter.submitList(filterSchedule("Web", it))
                        }
                    }
                }
            }
        })
    }

    companion object {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private const val ARG_SECTION_NUMBER = "section_number"

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        @JvmStatic
        fun newInstance(sectionNumber: Int): ScheduleFragment {
            return ScheduleFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_SECTION_NUMBER, sectionNumber)
                }
            }
        }
    }
}