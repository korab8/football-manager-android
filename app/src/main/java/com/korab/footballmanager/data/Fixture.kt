package com.korab.footballmanager.data

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * @author korab.muhadri
 */
@Entity(tableName = "fixtures")
data class Fixture(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val homeTeamId: Int,
    val awayTeamId: Int,
)
