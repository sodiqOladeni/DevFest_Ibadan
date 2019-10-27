package dev.hackwithsodiq.devfestibadan.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import dev.hackwithsodiq.devfestibadan.view.home.HomeViewModel
import dev.hackwithsodiq.devfestibadan.view.schedule.ScheduleViewModel
import dev.hackwithsodiq.devfestibadan.view.speaker.SpeakerViewModel
import dev.hackwithsodiq.devfestibadan.view.team.TeamViewModel

@Suppress("unused")
@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    abstract fun bindHomeViewModel(homeViewModel: HomeViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ScheduleViewModel::class)
    abstract fun bindScheduleViewModel(scheduleViewModel: ScheduleViewModel):ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(SpeakerViewModel::class)
    abstract fun bindSpeakerViewModel(speakerViewModel: SpeakerViewModel):ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(TeamViewModel::class)
    abstract fun bindTeamViewModel(teamViewModel: TeamViewModel):ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory):ViewModelProvider.Factory
}