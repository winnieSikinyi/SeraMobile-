import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.greenrevive.serawaziapplication.model.ScenarioDataClass
import com.greenrevive.serawaziapplication.repository.ScenarioRepository
import kotlinx.coroutines.launch


class ScenariosViewModel : ViewModel() {
    private val scenarioRepository = ScenarioRepository()
//    private val _scenarioData=MutableLiveData<ScenarioDataClass?>()
    val postsLiveData = MutableLiveData<List<ScenarioDataClass>>()
    val errorLiveData = MutableLiveData<String>()
//    val scenarioData:LiveData<ScenarioDataClass?>
//    get() = _scenarioData


    fun fetchScenarios(): LiveData<List<ScenarioDataClass>> {

            return scenarioRepository.fetchScenarios()
    }

//    fun fetchScenario() {
//        viewModelScope.launch {
//            val response = scenarioRepository.fetchScenarios()
//
//            if (response.isSuccessful) {
//                val scenarios = response.body() ?: emptyList()
//
//                postsLiveData.postValue(scenarios as List<ScenarioDataClass>)
//            } else {
//                errorLiveData.postValue(response.errorBody()?.string())
//            }
//        }
//    }

    fun saveScenario(scenario: ScenarioDataClass) {
        viewModelScope.launch {
            scenarioRepository.saveScenarios(scenario)
        }
    }

    fun insertScenario(scenario: ScenarioDataClass) {
        viewModelScope.launch {
            scenarioRepository.saveScenarios(scenario)
        }
    }

}
//=======
//package com.greenrevive.serawaziapplication.viewmodel
//
//class ScenariosViewModel {
//}
//>>>>>>> db93a7e797d16a693c76d568526c223ca94def1a
