package dev.hackwithsodiq.devfestibadan.view.speaker

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import dev.hackwithsodiq.devfestibadan.databinding.FragmentSpeakerBinding
import dev.hackwithsodiq.devfestibadan.view.BaseFragment
import javax.inject.Inject

class SpeakerFragment : BaseFragment() {

    private lateinit var viewModel: SpeakerViewModel
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var binding:FragmentSpeakerBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        binding = FragmentSpeakerBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(SpeakerViewModel::class.java)
    }
}