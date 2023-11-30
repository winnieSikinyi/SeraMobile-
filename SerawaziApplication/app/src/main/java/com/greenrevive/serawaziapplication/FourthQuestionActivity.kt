package com.greenrevive.serawaziapplication

import android.content.Intent
import android.graphics.Color
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import com.greenrevive.serawaziapplication.databinding.ActivityFourthQuestionBinding
import com.greenrevive.serawaziapplication.model.ScenarioDataClass
import com.greenrevive.serawaziapplication.ui.LevelTwoCongratsActivity


class FourthQuestionActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFourthQuestionBinding
    private lateinit var mediaPlayerCorrect: MediaPlayer
    private lateinit var mediaPlayerIncorrect: MediaPlayer
    private var btnCorrectClicked = false
    private var btnWrongClicked = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFourthQuestionBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initializeMediaPlayers()
    }

    private fun initializeMediaPlayers() {
        mediaPlayerCorrect = MediaPlayer.create(this, R.raw.winner_sound_effects_mp3_43014)
        mediaPlayerIncorrect = MediaPlayer.create(this, R.raw.freeze_dance_for_kids_dance_music_for_kids_mp3_74824)
    }

    override fun onResume() {
        super.onResume()

        binding.btnCorrect9.setOnClickListener {
            Toast.makeText(this, "Correct!! That's Impressive", Toast.LENGTH_LONG).show()
            binding.btnCorrect9.setBackgroundColor(Color.GREEN)
            binding.btnCorrect9.setTextColor(Color.WHITE)
            binding.ivGamer3.setImageResource(R.drawable.rightlyhappy)

            binding.btnCorrect9.isEnabled = false
            mediaPlayerCorrect.start()
            Handler().postDelayed({
                mediaPlayerCorrect.stop()
                startActivity(Intent(this, LevelTwoCongratsActivity::class.java))
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
                startActivity(Intent(this, FourthQuestionWrongAnswer::class.java))
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
                "Robert a citizen, from central of kenya is denied the right to vote in an election without valid reasons. He is escorted outside of  polling stations .He is threatened to be locked behind bars if he shows up again.Do you think Robert deserves to vote .What right according to the constituition does he have?",
                "Article 38 of the Constitution guarantees the right to participate in free and fair elections or any referendum.Roberts right to vote should be upheld.",
                "The authorities according to constituition they have right to restrict,escort someone outside polling stations without valid reasons",
                "ssjssjsjsjssj",
                1)
        )

        val scenario = scenarios.firstOrNull()

        scenario?.let {
            binding.tvque2.text = it.backgroundInfo
            binding.btnWrong3.text = it.incorrectAnswer
            binding.btnCorrect9.text = it.correctAnswer
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        mediaPlayerCorrect.release()
        mediaPlayerIncorrect.release()
    }
}