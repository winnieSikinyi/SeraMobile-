package com.greenrevive.serawaziapplication

import android.content.Intent
import android.graphics.Color
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import com.greenrevive.serawaziapplication.databinding.ActivityThirdQuestionBinding
import com.greenrevive.serawaziapplication.model.ScenarioDataClass

class ThirdQuestionActivity : AppCompatActivity() {
    private lateinit var binding: ActivityThirdQuestionBinding
    private lateinit var mediaPlayerCorrect: MediaPlayer
    private lateinit var mediaPlayerIncorrect: MediaPlayer
    private var btnCorrectClicked = false
    private var btnWrongClicked = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityThirdQuestionBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initializeMediaPlayers()
    }

    private fun initializeMediaPlayers() {
        mediaPlayerCorrect = MediaPlayer.create(this, R.raw.winner_sound_effects_mp3_43014)
        mediaPlayerIncorrect = MediaPlayer.create(this, R.raw.freeze_dance_for_kids_dance_music_for_kids_mp3_74824)
    }

    override fun onResume() {
        super.onResume()

        binding.btnCorrect3.setOnClickListener {
            Toast.makeText(this, "Correct!! That's Impressive", Toast.LENGTH_LONG).show()
            binding.btnCorrect3.setBackgroundColor(Color.GREEN)
            binding.btnCorrect3.setTextColor(Color.WHITE)
            binding.ivGamer3.setImageResource(R.drawable.rightlyhappy)

            binding.btnCorrect3.isEnabled = false
            mediaPlayerCorrect.start()
            Handler().postDelayed({
                mediaPlayerCorrect.stop()
                startActivity(Intent(this, FourthQuestionActivity::class.java))
            }, 3000)
        }

        binding.btnWrong3.setOnClickListener {
            Toast.makeText(this, "Incorrect!! Here's why:", Toast.LENGTH_LONG).show()
            binding.btnWrong3.setBackgroundColor(Color.RED)
            binding.btnWrong3.setTextColor(Color.WHITE)
            binding.ivGamer3.setImageResource(R.drawable.wronglyshocked)

            binding.btnWrong3.isEnabled = false
            mediaPlayerIncorrect.start()
            Handler().postDelayed({
                mediaPlayerIncorrect.stop()
                startActivity(Intent(this, ThirdQuestionWrongAnswer::class.java))
            }, 2000)
        }
        binding.ivchat1.setOnClickListener {
            val intent = Intent(this, ChatbotInteraction::class.java)
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
            binding.tvque3.text = it.backgroundInfo
            binding.btnWrong3.text = it.incorrectAnswer
            binding.btnCorrect3.text = it.correctAnswer
        }
    }


        override fun onDestroy() {
        super.onDestroy()
        mediaPlayerCorrect.release()
        mediaPlayerIncorrect.release()
    }
}