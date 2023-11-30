package com.greenrevive.serawaziapplication.repository

import androidx.lifecycle.LiveData
import com.greenrevive.serawaziapplication.MyScenarios
import com.greenrevive.serawaziapplication.model.Levels
import com.greenrevive.serawaziapplication.model.ScenarioDataClass
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


class ScenarioRepository {
    val database = ScenarioDb.getDatabase(MyScenarios.appContext)

    suspend fun  saveScenarios(scenario: ScenarioDataClass){
        withContext(Dispatchers.IO){
            database.getScenarioDao().insertScenario(scenario)
        }
    }
    fun fetchScenarios():LiveData<List<ScenarioDataClass>>{
        return database.getScenarioDao().getAllScenarios()
    }
    fun getLevelsById(levelId:Int): LiveData<Levels> {
        return  database.getLevelsDao().getLevelsById(levelId)
    }

    companion object {
        fun insertScenario(scenario: ScenarioDataClass) {
            TODO("Not yet implemented")
        }

        fun getlevelsById(levelId: Int): LiveData<ScenarioDataClass> {
            TODO("Not yet implemented")
        }
    }


}