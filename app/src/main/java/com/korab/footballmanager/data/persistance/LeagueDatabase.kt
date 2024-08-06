package com.korab.footballmanager.data.persistance

import androidx.room.Database
import androidx.room.RoomDatabase
import com.korab.footballmanager.data.Fixture
import com.korab.footballmanager.data.Team

/**
 * @author korab.muhadri
 */
@Database(entities = [Team::class, Fixture::class], version = 1)
abstract class LeagueDatabase : RoomDatabase() {
    abstract fun teamDao(): TeamDao

    abstract fun fixtureDao(): FixtureDao
}
