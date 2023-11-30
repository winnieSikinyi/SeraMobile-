package com.greenrevive.serawaziapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.greenrevive.serawaziapplication.databinding.ActivityFourthQuestionWrongAnswerBinding
import com.greenrevive.serawaziapplication.model.ScenarioDataClass
import com.greenrevive.serawaziapplication.ui.SelectALevelActivity


class FourthQuestionWrongAnswer : AppCompatActivity() {
    lateinit var binding: ActivityFourthQuestionWrongAnswerBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFourthQuestionWrongAnswerBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()
        binding.btnGotit2.setOnClickListener {
            val intent = Intent(this, SelectALevelActivity::class.java)
            startActivity(intent)
        }
        displayScenarios()
    }
    private fun displayScenarios() {
        val scenarios = listOf(

            ScenarioDataClass(
                1,
                "Robert a citizen, from central of kenya is denied the right to vote in an election without valid reasons. He is escorted outside of  polling stations .He is threatened to be locked behind bars if he shows up again.Do you think Robert deserves to vote .What right according to the constituition does he have?",
                "Article 38 of the Constitution guarantees the right to participate in free and fair elections or any referendum.Roberts right to vote should be upheld.",
                "The authorities according to constituition they have right to restrict,escort someone outside polling stations without valid reasons",
                "ssjssjsjsjssj",
                1)
        )

        val scenario = scenarios.firstOrNull()

        scenario?.let {
            binding.tvCorrectAnswerSummary.text = it.correctAnswer
        }
    }
}