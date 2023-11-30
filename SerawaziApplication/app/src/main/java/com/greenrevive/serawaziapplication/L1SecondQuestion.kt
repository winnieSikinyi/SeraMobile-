package com.greenrevive.serawaziapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import android.graphics.Color
import android.media.MediaPlayer
import com.greenrevive.serawaziapplication.databinding.ActivityL1SecondQuestionBinding
import com.greenrevive.serawaziapplication.model.ScenarioDataClass


class L1SecondQuestion : AppCompatActivity() {
    private lateinit var binding: ActivityL1SecondQuestionBinding
    private lateinit var mediaPlayerCorrect: MediaPlayer
    private lateinit var mediaPlayerIncorrect: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityL1SecondQuestionBinding.inflate(layoutInflater)
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
        binding.btncorrectt.setOnClickListener {
            Toast.makeText(this, "Correct!! That's Impressive", Toast.LENGTH_LONG).show()
            binding.btncorrectt.setBackgroundColor(Color.GREEN)
            binding.btncorrectt.setTextColor(Color.WHITE)
            binding.imguser1.setImageResource(R.drawable.rightlyhappy)

            binding.btncorrectt.isEnabled = false
            mediaPlayerCorrect.start()
            Handler().postDelayed({
                mediaPlayerCorrect.stop()
                mediaPlayerCorrect.stop()
                startActivity(Intent(this, L1ThirdQuestion::class.java))
            }, 3000)
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
                startActivity(Intent(this, L1SecondWrongAnswer::class.java))
                finish() // Add this line to finish the current activity
            }, 3000)
        }
        displayScenarios()
    }
    private fun displayScenarios() {
        val scenarios = listOf(
            ScenarioDataClass(2, "Kwamboka a guardian to Sarah, a child with a disability, is denied admission to a public school due to her disabilities and regarded her as a just needy person.What can she do?What right stands for her?", "Kwamboka can institute court proceedings claiming that Sarah's right or fundamental freedom in the Bill of Rights has been denied,violated.According to constituition everyone has right to institute court proceedings for such cases", "Public schools are not obligated to provide facilities for children with disabilities, and the responsibility lies with the child's family to seek another alternative", "ssssssssssssss", 2),
            ScenarioDataClass(1, "Having faced job rejection based on her gender, Susan feels she was a victim of discrimination. what legal avenues are available to uphold her rights in this scenario?", "Susan has the right to file a complaint with the relevant anti-discrimination agency and if she has the evidence to support her claim, It's essential for her to gather any relevant documentation or witnesses to strengthen her case."
                    , "Job rejections happen all the time, and there is no legal recourse for someone who feels discriminated against hence Susan has no power to claim for the rejection", "hffffffffhfhfh", 1),
            ScenarioDataClass(3, "Tom is arrested by the police without being informed of the reasons for his arrest, reaching the police station a statement is forged claiming that Tom had Mirra in his pockets .What are some of the rights that Tom should stand up with in this situation?", "Tom has the right to remain silent and have a lawyer present during police questioning. If he cannot afford one, a lawyer will be provided. He must be informed of the charges and can't be forced to testify against himself.", "Tom should be under the police and let them do as they please. A lawyer should be there but he must pay for it. And Tom should Confess so as to make the trial easier. Tom should unquestioningly comply with the police.", "ssjssjsjsjssj", 3)
        )

        val scenario = scenarios.firstOrNull()

        scenario?.let {
            binding.tvscene1.text = it.backgroundInfo

            binding.btncorrectt.text = it.correctAnswer 
            binding.btnanswer4.text = it.incorrectAnswer
        }
    }
}