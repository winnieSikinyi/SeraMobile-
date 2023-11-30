package com.greenrevive.serawaziapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.media.MediaPlayer
import android.view.animation.AnimationUtils
import com.greenrevive.serawaziapplication.databinding.ActivityLeveloneBinding
import com.greenrevive.serawaziapplication.ui.LevelTwoActivity

class levelone : AppCompatActivity() {
    lateinit var binding:ActivityLeveloneBinding
    private lateinit var mediaPlayer: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_levelone)
        binding = ActivityLeveloneBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initializeMediaPlayer()

        val animation = AnimationUtils.loadAnimation(this, R.anim.front_to_back_movement)
        binding.imageView18.startAnimation(animation)
//        binding.imageView.startAnimation(animation)

    }

    private fun initializeMediaPlayer() {
        mediaPlayer = MediaPlayer.create(this, R.raw.coinsound)
        mediaPlayer.isLooping = true
        mediaPlayer.start()
    }


    override fun onResume() {
        super.onResume()
        binding.btnLevel2.setOnClickListener {
            mediaPlayer.stop()
            startActivity(Intent(this,LevelTwoActivity::class.java))
        }

    }
}