package com.greenrevive.serawaziapplication.ui

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.view.animation.AnimationUtils

import com.greenrevive.serawaziapplication.R

import com.greenrevive.serawaziapplication.databinding.ActivityLevelTwoCongratsBinding


class LevelTwoCongratsActivity : AppCompatActivity() {
    lateinit var binding: ActivityLevelTwoCongratsBinding
    private lateinit var mediaPlayer: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {

        binding = ActivityLevelTwoCongratsBinding.inflate(layoutInflater)
        val view=binding.root
        super.onCreate(savedInstanceState)
        val animation = AnimationUtils.loadAnimation(this, R.anim.front_to_back_movement)
//        binding.imageView6.startAnimation(animation)
        binding.ivPurpleBackground.startAnimation(animation)

        setContentView(binding.root)
        initializeMediaPlayer()
    }
    private fun initializeMediaPlayer() {
        mediaPlayer = MediaPlayer.create(this, R.raw.coinsound)
        mediaPlayer.isLooping = true
        mediaPlayer.start()
    }


    override fun onResume() {
        super.onResume()
        binding.tvPlayLevel3.setOnClickListener {
            mediaPlayer.stop()
            startActivity(Intent(this,SelectALevelActivity::class.java))
        }
    }
}
