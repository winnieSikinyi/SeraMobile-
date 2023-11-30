package com.greenrevive.serawaziapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.greenrevive.serawaziapplication.databinding.ActivityThirdQuestionWrongAnswerBinding
import com.greenrevive.serawaziapplication.model.ScenarioDataClass

class ThirdQuestionWrongAnswer : AppCompatActivity() {
    lateinit var binding: ActivityThirdQuestionWrongAnswerBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityThirdQuestionWrongAnswerBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()
        binding.btnGotit2.setOnClickListener {
            val intent = Intent(this, FourthQuestionActivity::class.java)
            startActivity(intent)
        }
        displayScenarios()
    }

    private fun displayScenarios() {
        val scenarios = listOf(
            ScenarioDataClass(
                1,
                "Sarah,a college student wants to organize a peaceful protest on her campus to raise awareness about political and social issues.However,when she applies for a permit to hold the protest, the university denies her request, citing concerns about potential disruptions. What in the bill of rights is relevant to her situation? ",
                "Right to assemble, demonstrate, picket, and petition: Article 37 of the Constitution states that every person has the right to assemble, demonstrate, picket, and present petitions to public authorities, as long as it is done peaceably and unarmed.",
                "The university should dictate what each of it's members does , since they are the ones in charge according to the constituition of Kenya ",
                "hffffffffhfhfh",
                1
            ),

            )

        val scenario = scenarios.firstOrNull()

        scenario?.let {
            binding.tvCorrectAnswerSummary.text = it.correctAnswer
        }
    }
}