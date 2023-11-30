package com.greenrevive.serawaziapplication

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.content.ContextCompat
import com.greenrevive.serawaziapplication.databinding.ActivityChoosecharactersBinding


class choosecharacters : AppCompatActivity() {
    lateinit var binding: ActivityChoosecharactersBinding
    private var selectedAvatar: Int = R.drawable.avatarone
    private var proceedButtonClicked: Boolean = false
    private lateinit var mediaPlayer: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChoosecharactersBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupButtonClickListeners()
        initializeMediaPlayer()
    }

    private fun initializeMediaPlayer() {
        mediaPlayer = MediaPlayer.create(this, R.raw.freeze_dance_for_kids_dance_music_for_kids_mp3_74824)
        mediaPlayer.isLooping = true
        mediaPlayer.start()
    }

    override fun onPause() {
        super.onPause()
        mediaPlayer.pause()
    }

    override fun onResume() {
        super.onResume()
        mediaPlayer.start()
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer.release()
    }

    private fun setupButtonClickListeners() {
        binding.ivavatarone.setOnClickListener {
            selectAvatar(R.drawable.newcharacterwoman, binding.ivavatarone)
        }

        binding.ivavatartwo.setOnClickListener {
            selectAvatar(R.drawable.yellowman, binding.ivavatartwo)
        }

        binding.ivavatarthree.setOnClickListener {
            selectAvatar(R.drawable.secondnewwoman, binding.ivavatarthree)
        }

        binding.ivavatarfour.setOnClickListener {
            selectAvatar(R.drawable.secondnewman, binding.ivavatarfour)
        }

        binding.btnproceed.setOnClickListener {
            if (proceedButtonClicked) {
                val intent = Intent(this, homepage::class.java)
                startActivity(intent)
            }
        }
    }

    private fun selectAvatar(avatar: Int, imageView: ImageView) {
        binding.ivavatarone.animate().scaleX(1f).scaleY(1f).setDuration(300).start()
        binding.ivavatartwo.animate().scaleX(1f).scaleY(1f).setDuration(300).start()
        binding.ivavatarthree.animate().scaleX(1f).scaleY(1f).setDuration(300).start()
        binding.ivavatarfour.animate().scaleX(1f).scaleY(1f).setDuration(300).start()

        imageView.animate().scaleX(1.5f).scaleY(1.5f).setDuration(300).start()

        when (avatar) {
            R.drawable.newcharacterwoman -> {
//                binding.ivavatarone.setImageDrawable(AppCompatResources.getDrawable(this, R.drawable.avatarfive))
                setProceedButtonAppearance()
            }
            R.drawable.yellowman -> {
//                binding.ivavatartwo.setImageDrawable(AppCompatResources.getDrawable(this, R.drawable.avatarsix))
                setProceedButtonAppearance()
            }
            R.drawable.secondnewwoman -> {
//                binding.ivavatarthree.setImageDrawable(AppCompatResources.getDrawable(this, R.drawable.avatarseven))
                setProceedButtonAppearance()
            }
            R.drawable.secondnewman -> {
//                binding.ivavatarfour.setImageDrawable(AppCompatResources.getDrawable(this, R.drawable.avatareight))
                setProceedButtonAppearance()
            }
        }

        selectedAvatar = avatar
    }

    private fun setProceedButtonAppearance() {
        binding.btnproceed.setBackgroundColor(ContextCompat.getColor(this, R.color.greenColor))
        binding.btnproceed.setTextColor(ContextCompat.getColor(this, R.color.whiteColor))
        proceedButtonClicked = true
    }
}