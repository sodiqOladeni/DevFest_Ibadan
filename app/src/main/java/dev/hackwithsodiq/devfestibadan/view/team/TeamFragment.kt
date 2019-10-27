package dev.hackwithsodiq.devfestibadan.view.team

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider

import dev.hackwithsodiq.devfestibadan.databinding.TeamFragmentBinding
import dev.hackwithsodiq.devfestibadan.view.BaseFragment
import javax.inject.Inject

class TeamFragment : BaseFragment() {

    private lateinit var viewModel: TeamViewModel
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var binding: TeamFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = TeamFragmentBinding.inflate(inflater)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(TeamViewModel::class.java)

    }

}
