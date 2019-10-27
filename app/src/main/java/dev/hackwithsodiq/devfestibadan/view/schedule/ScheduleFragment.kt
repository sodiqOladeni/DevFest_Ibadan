package dev.hackwithsodiq.devfestibadan.view.schedule

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import dev.hackwithsodiq.devfestibadan.databinding.FragmentScheduleBinding
import dev.hackwithsodiq.devfestibadan.view.BaseFragment
import javax.inject.Inject

class ScheduleFragment : BaseFragment() {

    private lateinit var viewModel: ScheduleViewModel
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var binding:FragmentScheduleBinding

    override fun onCreateView(inflater: LayoutInflater,
        container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentScheduleBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(ScheduleViewModel::class.java)
    }
}