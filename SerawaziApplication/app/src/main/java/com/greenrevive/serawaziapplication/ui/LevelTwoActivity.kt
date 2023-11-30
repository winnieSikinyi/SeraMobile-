package com.greenrevive.serawaziapplication.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.graphics.Color
import android.os.Handler
import android.widget.Toast
import com.greenrevive.serawaziapplication.R
import com.greenrevive.serawaziapplication.databinding.ActivityLevelTwoBinding
import android.media.MediaPlayer
import com.greenrevive.serawaziapplication.ChatbotInteraction
import com.greenrevive.serawaziapplication.ThirdQuestionActivity
import com.greenrevive.serawaziapplication.model.ScenarioDataClass

class LevelTwoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLevelTwoBinding
    private lateinit var mediaPlayerCorrect: MediaPlayer
    private lateinit var mediaPlayerIncorrect: MediaPlayer
    private var btnCorrectClicked = false
    private var btnWrongClicked = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLevelTwoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initializeMediaPlayers()
    }

    private fun initializeMediaPlayers() {
        mediaPlayerCorrect = MediaPlayer.create(this, R.raw.winner_sound_effects_mp3_43014)
        mediaPlayerIncorrect = MediaPlayer.create(this, R.raw.freeze_dance_for_kids_dance_music_for_kids_mp3_74824)
    }

    override fun onResume() {
        super.onResume()

        binding.btnCorrect7.setOnClickListener {
            Toast.makeText(this, "Correct!! That's Impressive", Toast.LENGTH_LONG).show()
            binding.btnCorrect7.setBackgroundColor(Color.GREEN)
            binding.btnCorrect7.setTextColor(Color.WHITE)
            binding.ivGamer2.setImageResource(R.drawable.rightlyhappy)
            binding.btnCorrect7.isEnabled = false
            mediaPlayerCorrect.start()
            Handler().postDelayed({
                mediaPlayerCorrect.stop()
                startActivity(Intent(this, ThirdQuestionActivity::class.java))
            }, 3000)
        }
        binding.ivchat1.setOnClickListener {
            val intent = Intent(this, ChatbotInteraction::class.java)
            startActivity(intent)
        }

        binding.btnWrong2.setOnClickListener {
            Toast.makeText(this, "Incorrect!! Here's why:", Toast.LENGTH_LONG).show()
            binding.btnWrong2.setBackgroundColor(Color.RED)
            binding.btnWrong2.setTextColor(Color.WHITE)
            binding.ivGamer2.setImageResource(R.drawable.wronglyshocked)

            binding.btnWrong2.isEnabled = false
            mediaPlayerIncorrect.start()
            Handler().postDelayed({
                mediaPlayerIncorrect.stop()
                startActivity(Intent(this, Level2IncorrectAnswerActivity::class.java))
            }, 2000)
        }
        displayScenarios()
    }

    private fun displayScenarios() {
        val scenarios = listOf(
            ScenarioDataClass(1, "Ahmed, a refugee, is denied access to move around in the host country.He has all necessary certificates that indicate that he is a refugee.He has shown all his documents but they are asking him to give out some cash.What right does he have according to the constitution of Kenya?",
                "According to Constitution protects the rights of citizens including refugees,right to freedom of movement,right to Enter,remain,Reside anywhere in Kenya.This right may still apply to him.",
                "  Article 33 of the Constitution does not protect the rights of refugees, including access to education for refugee children and movement within the country.", "ssssssssssssss", 1),
                    )

        val scenario = scenarios.firstOrNull()

        scenario?.let {
            binding.tvque2.text = it.backgroundInfo
            binding.btnCorrect7.text = it.correctAnswer
            binding.btnWrong2.text = it.incorrectAnswer
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayerCorrect.release()
        mediaPlayerIncorrect.release()
    }
}