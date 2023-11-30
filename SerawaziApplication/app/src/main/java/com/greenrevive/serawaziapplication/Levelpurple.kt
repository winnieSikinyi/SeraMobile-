package com.greenrevive.serawaziapplication

import ScenariosViewModel
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import android.graphics.Color
import android.media.MediaPlayer
import androidx.activity.viewModels
import com.greenrevive.serawaziapplication.databinding.ActivityLevelpurpleBinding
import com.greenrevive.serawaziapplication.model.ScenarioDataClass

class Levelpurple : AppCompatActivity() {
    val ScenariosViewModel:ScenariosViewModel by viewModels()
    lateinit var binding: ActivityLevelpurpleBinding
    private lateinit var mediaPlayerCorrect: MediaPlayer
    private lateinit var mediaPlayerIncorrect: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLevelpurpleBinding.inflate(layoutInflater)
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
        binding.btncorrecttt.setOnClickListener {
            Toast.makeText(this, "Correct!! That's Impressive", Toast.LENGTH_LONG).show()
            binding.btncorrecttt.setBackgroundColor(Color.GREEN)
            binding.btncorrecttt.setTextColor(Color.WHITE)
            binding.imguser1.setImageResource(R.drawable.rightlyhappy)
            binding.btncorrecttt.isEnabled = false
            mediaPlayerCorrect.start()
            Handler().postDelayed({
                mediaPlayerCorrect.stop()
                mediaPlayerCorrect.reset()
                startActivity(Intent(this, L1SecondQuestion::class.java))
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
                startActivity(Intent(this, Tryagain::class.java))
            }, 3000)
        }

        displayScenarios()
    }
    private fun displayScenarios() {
        val scenarios = listOf(
            ScenarioDataClass(1, "Coming home from work, you encounter people running away and one of them pushes a wooden staff in your arm before running off. In the confusion, " +
                    "you run along only to be arrested with them. What should you do?",
                "Stay calm, You have the right to remain silent, and you should exercise this right until you have legal representation present. Avoid making any statements without consulting an attorney.	",
                "Agree to everything to avoid making the police angry and plead guilty to avoid the ruckus. This will make you get released faster	", "ssssssssssssss", 1),
            ScenarioDataClass(1, "You want to hold demonstrations over social and political issues you find oppressive. Upon asking for permission from the vice-chancellor, they deny you this chance." +
                    " What does the constitution say about this?", "The law dictates that every individual has a right to demonstrate peacefully to put forward their petitions to the local authorities", "The university should dictate what each of it's members does", "hffffffffhfhfh", 1),
            ScenarioDataClass(1, "David requires urgent medical treatment, but the hospital refuses to admit him without payment.What is his right ?", "Constitution guarantees the right to the highest attainable standard of health, including the right to emergency medical treatment.", "He has right to beat up the doctor", "ssjssjsjsjssj", 1)
        )

        val scenario = scenarios.firstOrNull()

        scenario?.let {
            binding.tvscene1.text = it.backgroundInfo

            binding.btncorrecttt.text = it.correctAnswer
            binding.btnanswer4.text = it.incorrectAnswer
        }
    }




        override fun onDestroy() {
            super.onDestroy()
            mediaPlayerCorrect.release()
            mediaPlayerIncorrect.release()
        }
    }

