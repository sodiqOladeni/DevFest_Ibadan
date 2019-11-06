package dev.hackwithsodiq.devfestibadan.view.team

import android.content.Intent
import android.net.Uri
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import dev.hackwithsodiq.devfestibadan.R
import dev.hackwithsodiq.devfestibadan.databinding.TeamFragmentBinding
import dev.hackwithsodiq.devfestibadan.listeners.OnTeamLinkClickListeners
import dev.hackwithsodiq.devfestibadan.view.BaseFragment
import javax.inject.Inject
import java.io.IOException


class TeamFragment : BaseFragment(), OnTeamLinkClickListeners {
    override fun onLinkIconClicked(link: String) {
        startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(link)))
    }

    private lateinit var viewModel: TeamViewModel
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var binding: TeamFragmentBinding
    private lateinit var teamAdapter:TeamAdapter

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

        val animation = AnimationUtils.loadLayoutAnimation(context, R.anim.item_bottom_anim)
        teamAdapter = TeamAdapter(this)

        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            layoutAnimation = animation
            adapter = teamAdapter
        }

        viewModel.allTeams.observe(this, Observer {
            binding.progressBar.visibility = View.GONE
            it?.let {
                if (it.isNullOrEmpty()){
                    binding.recyclerView.visibility = View.GONE
                    binding.emptyData.visibility = View.VISIBLE
                }else{
                    binding.recyclerView.visibility = View.VISIBLE
                    binding.emptyData.visibility = View.GONE
                    teamAdapter.submitList(it)
                }
            }
        })

        loadJSONFromAsset()?.let {
            viewModel.loadTeamAsset(it)
        }
    }

    fun loadJSONFromAsset(): String? {
        var json: String? = null
        try {
            val `is` = activity!!.assets.open("all_team.json")
            val size = `is`.available()
            val buffer = ByteArray(size)
            `is`.read(buffer)
            `is`.close()
            json = String(buffer, Charsets.UTF_8)
        } catch (ex: IOException) {
            ex.printStackTrace()
            return null
        }
        return json
    }
}
