package com.greenrevive.serawaziapplication.model

import androidx.room.Dao
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
@Dao
@Entity(tableName = "LevelsDao")
data class Levels(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val levelTitle: String
)

@Entity(
    tableName = "ScenarioDao",
    foreignKeys = [ForeignKey(
        entity = Levels::class,
        parentColumns = ["id"],
        childColumns = ["levelId"],
        onDelete = ForeignKey.CASCADE
    )]
)
data class ScenarioDataClass(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val backgroundInfo: String,
    val correctAnswer: String,
    val incorrectAnswer: String,
 val image: String,
   val levelId: Int
)









