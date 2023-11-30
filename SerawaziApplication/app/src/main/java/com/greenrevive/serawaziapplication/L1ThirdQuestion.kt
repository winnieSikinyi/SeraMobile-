package com.greenrevive.serawaziapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import android.graphics.Color
import android.media.MediaPlayer
import com.greenrevive.serawaziapplication.databinding.ActivityL1ThirdQuestionBinding
import com.greenrevive.serawaziapplication.model.ScenarioDataClass

class L1ThirdQuestion : AppCompatActivity() {
    lateinit var binding: ActivityL1ThirdQuestionBinding
    private lateinit var mediaPlayerCorrect: MediaPlayer
    private lateinit var mediaPlayerIncorrect: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityL1ThirdQuestionBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initializeMediaPlayers()
    }

    private fun initializeMediaPlayers() {
        mediaPlayerCorrect = MediaPlayer.create(this, R.raw.winner_sound_effects_mp3_43014)
        mediaPlayerCorrect.setOnCompletionListener {
            mediaPlayerCorrect.stop()
            mediaPlayerCorrect.reset()
        }

        mediaPlayerIncorrect = MediaPlayer.create(this, R.raw.freeze_dance_for_kids_dance_music_for_kids_mp3_74824)
        mediaPlayerIncorrect.setOnCompletionListener {
            mediaPlayerIncorrect.stop()
            mediaPlayerIncorrect.reset()
        }
    }

    override fun onResume() {
        super.onResume()
        setContentView(binding.root)
        binding.btncorrectAnswer.setOnClickListener {
            Toast.makeText(this, "Correct!! That's Impressive", Toast.LENGTH_LONG).show()
            binding.btncorrectAnswer.setBackgroundColor(Color.GREEN)
            binding.btncorrectAnswer.setTextColor(Color.WHITE)
            binding.imguser1.setImageResource(R.drawable.rightlyhappy)

            binding.btncorrectAnswer.isEnabled = false
            mediaPlayerCorrect.start()
            Handler().postDelayed({
                mediaPlayerCorrect.stop()
                mediaPlayerCorrect.reset()
                startActivity(Intent(this, levelone::class.java))
            }, 2000)
        }

        binding.ivchat1.setOnClickListener {
            val intent = Intent(this, ChatbotInteraction::class.java)
            startActivity(intent)
        }

        binding.btnanswer4.setOnClickListener {
            Toast.makeText(this, "Ooops Incorrect!! Get to know why:", Toast.LENGTH_LONG).show()
            binding.btnanswer4.setBackgroundColor(Color.RED)
            binding.btnanswer4.setTextColor(Color.WHITE)
            binding.imguser1.setImageResource(R.drawable.wronglyshocked)

            binding.btnanswer4.isEnabled = false
            mediaPlayerIncorrect.start()
            Handler().postDelayed({
                mediaPlayerIncorrect.stop()
                mediaPlayerIncorrect.reset()
                startActivity(Intent(this, L1ThirdWrongAnswer::class.java))
            }, 3000)
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
            binding.tvscene1.text = it.backgroundInfo
            binding.btncorrectAnswer.text = it.correctAnswer
            binding.btnanswer4.text = it.incorrectAnswer
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayerCorrect.release()
        mediaPlayerIncorrect.release()
    }
}