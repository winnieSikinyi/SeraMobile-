package com.greenrevive.serawaziapplication

import androidx.room.Embedded
import androidx.room.Relation
import com.greenrevive.serawaziapplication.model.Levels
import com.greenrevive.serawaziapplication.model.ScenarioDataClass

data class LevelWithScenarios(
    @Embedded val level: Levels,
    @Relation(
        parentColumn = "id",
        entityColumn = "levelId"
    )
    val scenarios: List<ScenarioDataClass>
)
