package com.greenrevive.serawaziapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.greenrevive.serawaziapplication.databinding.ActivityL1ThirdWrongAnswerBinding
import com.greenrevive.serawaziapplication.model.ScenarioDataClass
import com.greenrevive.serawaziapplication.ui.LevelTwoActivity


class L1ThirdWrongAnswer : AppCompatActivity() {
    lateinit var binding: ActivityL1ThirdWrongAnswerBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityL1ThirdWrongAnswerBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()
        binding.btnGotit2.setOnClickListener {
            val intent = Intent(this, LevelTwoActivity::class.java)
            startActivity(intent)
        }
        displayScenarios()
    }
    private fun displayScenarios() {
        val scenarios = listOf(
            ScenarioDataClass(1, "Having faced job rejection based on her gender, Susan feels she was a victim of discrimination. what legal avenues are available to uphold her rights in this scenario?", "Susan has the right to file a complaint with the relevant anti-discrimination agency and if she has the evidence to support her claim, It's essential for her to gather any relevant documentation or witnesses to strengthen her case.", "Job rejections happen all the time, and there is no legal recourse for someone who feels discriminated against hence Susan has no power to claim for the rejection", "ssssssssssssss", 1),
            ScenarioDataClass(2, "Lisa, a minor, is subjected by her mother to child labor in a factory So as to provide for the family.What is her right?", "Article 53 of the Constitution protects the rights of children, including protection from economic exploitation and harmful labor practices.", "She has the right of beating up the mother", "hffffffffhfhfh", 2),
            ScenarioDataClass(3, "A community faces forced eviction from their homes to make way for a commercial development.Do they have right here? What does it say?", "Article 43 of the Constitution guarantees the right to accessible and adequate housing, preventing arbitrary evictions.", "They have the right of forcifully staying there.", "ssjssjsjsjssj", 2)
        )

        val scenario = scenarios.firstOrNull()
        scenario?.let {
            binding.tvCorrectAnswerSummary.text = it.correctAnswer
        }
    }
}