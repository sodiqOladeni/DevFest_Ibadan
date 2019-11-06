package dev.hackwithsodiq.devfestibadan.view.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import dev.hackwithsodiq.devfestibadan.databinding.FragmentHomeBinding
import dev.hackwithsodiq.devfestibadan.view.BaseFragment
import kotlinx.android.synthetic.main.fragment_home.*
import javax.inject.Inject
import android.content.Intent
import android.net.Uri



class HomeFragment : BaseFragment() {

    private lateinit var viewModel: HomeViewModel
    @Inject lateinit var viewModelFactory:ViewModelProvider.Factory
    private lateinit var binding:FragmentHomeBinding

    override fun onCreateView(inflater: LayoutInflater,
        container: ViewGroup?, savedInstanceState: Bundle?): View? {
         binding = FragmentHomeBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(HomeViewModel::class.java)

        fab.setOnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://www.eventbrite.com/e/devfest-ibadan-tickets-76350070115")))
        }
        whatGdg.setOnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://developers.google.com/groups/")))
        }
        whatDevFest.setOnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://devfest.withgoogle.com/")))
        }
    }
}