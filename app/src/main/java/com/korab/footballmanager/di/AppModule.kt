package com.korab.footballmanager.di

import androidx.room.Room
import com.korab.footballmanager.data.persistance.LeagueDatabase
import com.korab.footballmanager.domain.LeagueRepository
import com.korab.footballmanager.ui.LeagueViewModel
import com.korab.footballmanager.ui.details.TeamDetailsViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * @author korab.muhadri
 * koin module to initialize Database, Repository and ViewModels
 */
val appModule =
    module {
        single<LeagueDatabase> {
            Room
                .databaseBuilder(
                    androidContext(),
                    LeagueDatabase::class.java,
                    "league_db",
                ).build()
        }
        single { LeagueRepository(get()) }
        viewModel { LeagueViewModel(get()) }
        viewModel { TeamDetailsViewModel(get()) }
    }
