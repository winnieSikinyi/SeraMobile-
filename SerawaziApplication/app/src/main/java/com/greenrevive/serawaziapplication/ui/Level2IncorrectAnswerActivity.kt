package com.greenrevive.serawaziapplication.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.greenrevive.serawaziapplication.ThirdQuestionActivity
import com.greenrevive.serawaziapplication.databinding.ActivityLevel2IncorrectAnswerBinding
import com.greenrevive.serawaziapplication.model.ScenarioDataClass

class Level2IncorrectAnswerActivity : AppCompatActivity() {
    lateinit var binding: ActivityLevel2IncorrectAnswerBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLevel2IncorrectAnswerBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()
        binding.btnGotit2.setOnClickListener {
            val intent = Intent(this, ThirdQuestionActivity::class.java)
            startActivity(intent)
        }
        displayScenarios()
    }
    private fun displayScenarios() {
        val scenarios = listOf(
            ScenarioDataClass(1, "Ahmed, a refugee, is denied access to move around in the host country.He has all necessary certificates that indicate that he is a refugee.He has shown all his documents but they are asking him to give out some cash.What right does he have according to the constitution of Kenya?",
                " The Constitution protects the rights of citizens including refugees,right to freedom of movement,right to Enter,remain,Reside anywhere in Kenya.This right may still apply to him.",
                "  Article 33 of the Constitution protects the rights of working refugees, including access to education for working refugee children and movement within the country.", "ssssssssssssss", 1),
        )

        val scenario = scenarios.firstOrNull()

        scenario?.let {
            binding.tvCorrectAnswerSummary.text = it.correctAnswer
        }
    }


}