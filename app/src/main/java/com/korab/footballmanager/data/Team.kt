package com.korab.footballmanager.data

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * @author korab.muhadri
 */
@Entity(tableName = "teams")
data class Team(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    var points: Int = 0,
    var goalsFor: Int = 0,
    var goalsAgainst: Int = 0,
    val coachName: String,
    val city: String,
) {
    val goalDifference: Int
        get() = goalsFor - goalsAgainst
}
