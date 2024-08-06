package com.korab.footballmanager.data.persistance

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.korab.footballmanager.data.Fixture
import kotlinx.coroutines.flow.Flow

/**
 * @author korab.muhadri
 */
@Dao
interface FixtureDao {
    @Query("SELECT * FROM fixtures")
    fun getAllFixtures(): Flow<List<Fixture>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFixtures(fixtures: List<Fixture>)

    @Query("DELETE FROM fixtures")
    suspend fun deleteFixtures()

    @Transaction
    suspend fun clearAndInsertFixtures(fixtures: List<Fixture>) {
        deleteFixtures()
        insertFixtures(fixtures)
    }
}
