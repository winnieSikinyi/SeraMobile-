package com.greenrevive.serawaziapplication.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.greenrevive.serawaziapplication.model.ScenarioDataClass

@Dao
interface ScenarioDao {

    @Query("SELECT * FROM ScenarioDao ORDER BY id ASC LIMIT 1")
    fun getFirstScenario(): LiveData<ScenarioDataClass>

    @Query("SELECT * FROM ScenarioDao WHERE id > :currentId ORDER BY id ASC LIMIT 1")
    fun getNextScenario(currentId: Int): LiveData<ScenarioDataClass>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertScenario(scenario: ScenarioDataClass)

    @Query("SELECT * FROM ScenarioDao")
    fun getAllScenarios(): LiveData<List<ScenarioDataClass>>

}

