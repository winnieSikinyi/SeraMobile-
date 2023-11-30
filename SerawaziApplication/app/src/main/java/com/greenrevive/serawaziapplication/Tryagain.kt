package com.greenrevive.serawaziapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.greenrevive.serawaziapplication.databinding.ActivityTryagainBinding
import com.greenrevive.serawaziapplication.model.ScenarioDataClass

class Tryagain : AppCompatActivity() {
    lateinit var binding: ActivityTryagainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTryagainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()
        setContentView(binding.root)
        binding.btngotit.setOnClickListener {
            val intent= Intent(this, L1SecondQuestion::class.java)
            startActivity(intent)
        }
        displayScenarios()
    }
    private fun displayScenarios() {
        val scenarios = listOf(
            ScenarioDataClass(1, "Coming home from work, you encounter people running away and one of them pushes a wooden staff in your arm before running off. In the confusion, " +
                    "you run along only to be arrested with them. What should you do?",
                "Stay calm, You have the right to remain silent, and" +
                        " you should exercise this right until you have legal representation present." +
                        " Avoid making any statements without consulting an attorney.	",
                "Agree to everything to avoid making the police angry and plead guilty to avoid the ruckus. This will make you get released faster	", "ssssssssssssss", 1),
            ScenarioDataClass(1, "You want to hold demonstrations over social and political issues you find oppressive. Upon asking for permission from the vice-chancellor, they deny you this chance." +
                    " What does the constitution say about this?", "The law dictates that every individual has a right to demonstrate peacefully to put forward their petitions to the local authorities", "The university should dictate what each of it's members does", "hffffffffhfhfh", 1),
            ScenarioDataClass(1, "David requires urgent medical treatment, but the hospital refuses to admit him without payment.What is his right ?", "Constitution guarantees the right to the highest attainable standard of health, including the right to emergency medical treatment.", "He has right to beat up the doctor", "ssjssjsjsjssj", 1)
        )

        val scenario = scenarios.firstOrNull()

        scenario?.let {

            binding.tvcorrectans.text = it.correctAnswer
        }
    }

}