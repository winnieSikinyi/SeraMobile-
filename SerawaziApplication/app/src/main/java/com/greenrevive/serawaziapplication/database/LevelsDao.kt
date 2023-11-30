//package com.greenrevive.serawaziapplication.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.greenrevive.serawaziapplication.LevelWithScenarios
import com.greenrevive.serawaziapplication.model.Levels
import com.greenrevive.serawaziapplication.model.ScenarioDataClass

@Dao
interface LevelsDao {

    @Transaction
    @Query("SELECT * FROM LevelsDao WHERE id = :levelId")
    suspend fun getLevelWithScenarios(levelId: Int): LevelWithScenarios?

    @Transaction
    @Query("SELECT * FROM LevelsDao WHERE id > :currentLevelId ORDER BY id ASC LIMIT 1")
    suspend fun getNextLevelWithScenarios(currentLevelId: Int): LevelWithScenarios?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLevel(level: Levels)

    @Query("SELECT * FROM LevelsDao")
    fun getAllLevelsLiveData(): LiveData<List<Levels>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(level: Levels)

    @Query("SELECT * FROM ScenarioDao WHERE levelId = :levelId")
    fun getScenariosForLevel(levelId: Int): LiveData<List<ScenarioDataClass>>

    @Query("SELECT * FROM LevelsDao WHERE id = :levelId")
    fun getLevelsById(levelId: Int): LiveData<Levels>
}
