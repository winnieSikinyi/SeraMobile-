package com.greenrevive.serawaziapplication.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.media.MediaPlayer
import android.os.Bundle
import com.greenrevive.serawaziapplication.Levelpurple
import com.greenrevive.serawaziapplication.R
import com.greenrevive.serawaziapplication.databinding.ActivitySelectAlevelBinding

class SelectALevelActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySelectAlevelBinding
    private lateinit var mediaPlayer: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySelectAlevelBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initializeMediaPlayer()
        playLevelOne()
        playLevelTwo()
    }

    private fun initializeMediaPlayer() {
        mediaPlayer = MediaPlayer.create(this, R.raw.freeze_dance_for_kids_dance_music_for_kids_mp3_74824)
        mediaPlayer.isLooping = true
        mediaPlayer.start()
    }


    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer.release()
    }

    private fun playLevelOne() {
        binding.imglevel1.setOnClickListener {
            mediaPlayer.stop()
            val intent = Intent(this, Levelpurple::class.java)
            startActivity(intent)
        }
    }

    private fun playLevelTwo() {
        binding.tolife.setOnClickListener {
            mediaPlayer.stop()
            val intent = Intent(this, LevelTwoActivity::class.java)
            startActivity(intent)
        }
    }
}