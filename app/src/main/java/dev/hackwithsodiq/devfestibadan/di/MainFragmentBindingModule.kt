package dev.hackwithsodiq.devfestibadan.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import dev.hackwithsodiq.devfestibadan.view.BaseFragment
import dev.hackwithsodiq.devfestibadan.view.home.HomeFragment
import dev.hackwithsodiq.devfestibadan.view.schedule.ScheduleFragment
import dev.hackwithsodiq.devfestibadan.view.speaker.SpeakerFragment
import dev.hackwithsodiq.devfestibadan.view.team.TeamFragment

@Suppress("unused")
@Module
abstract class MainFragmentBindingModule {

    @ContributesAndroidInjector
    abstract fun bindHomeFragment(): HomeFragment

    @ContributesAndroidInjector
    abstract fun binScheduleFragment(): ScheduleFragment

    @ContributesAndroidInjector
    abstract fun bindBSpeakerFragment(): SpeakerFragment

    @ContributesAndroidInjector
    abstract fun bindTeamFragment(): TeamFragment

    @ContributesAndroidInjector
    abstract fun bindBaseFragment(): BaseFragment
}