package dev.hackwithsodiq.devfestibadan.view.speaker

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import dev.hackwithsodiq.devfestibadan.R
import dev.hackwithsodiq.devfestibadan.databinding.FragmentSpeakerBinding
import dev.hackwithsodiq.devfestibadan.view.BaseFragment
import javax.inject.Inject

class SpeakerFragment : BaseFragment() {

    private lateinit var viewModel: SpeakerViewModel
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var binding:FragmentSpeakerBinding
    private lateinit var speakerAdapter:SpeakerAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        binding = FragmentSpeakerBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(SpeakerViewModel::class.java)

        val animation = AnimationUtils.loadLayoutAnimation(context, R.anim.item_bottom_anim)
        speakerAdapter = SpeakerAdapter()
        val gridLayoutDecorator = GridSpacingItemDecoration(2, 15, false)

        binding.recyclerView.apply {
            layoutManager = GridLayoutManager(context, 2)
            layoutAnimation = animation
            adapter = speakerAdapter
            addItemDecoration(gridLayoutDecorator)
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
                    speakerAdapter.submitList(it)
                }
            }
        })
    }
}