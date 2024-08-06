package com.korab.footballmanager.data.persistance

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import com.korab.footballmanager.data.Team
import kotlinx.coroutines.flow.Flow

/**
 * @author korab.muhadri
 */
@Dao
interface TeamDao {
    @Query("SELECT * FROM teams ORDER BY points DESC")
    fun getAllTeams(): Flow<List<Team>>

    @Query("SELECT * FROM teams WHERE id = :id")
    suspend fun getTeamById(id: Int): Team

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTeams(teams: List<Team>)

    @Update
    suspend fun updateTeam(team: Team)

    @Query("DELETE FROM teams")
    suspend fun deleteTeams()

    @Transaction
    suspend fun clearAndInsertTeams(teams: List<Team>) {
        deleteTeams()
        insertTeams(teams)
    }
}
