package dev.hackwithsodiq.devfestibadan.view.schedule

import android.content.Context
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import dev.hackwithsodiq.devfestibadan.R

class ScheduleMainFragment : Fragment() {

    private var mContext: Context? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = getContext()
    }

    override fun onDestroy() {
        super.onDestroy()
        mContext = null
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_schedule_main, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val sectionsPagerAdapter = SectionsPagerAdapter(mContext!!, childFragmentManager)
        val viewPager: ViewPager = view!!.findViewById(R.id.view_pager)
        viewPager.offscreenPageLimit = 3
        viewPager.adapter = sectionsPagerAdapter
        val tabs: TabLayout = view!!.findViewById(R.id.tabs)
        tabs.setupWithViewPager(viewPager)
    }
}
