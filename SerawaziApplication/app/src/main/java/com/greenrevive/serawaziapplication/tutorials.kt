package com.greenrevive.serawaziapplication

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.ImageView
import com.greenrevive.serawaziapplication.databinding.ActivityTutorialsBinding


class tutorials : AppCompatActivity() {
    lateinit var binding: ActivityTutorialsBinding
    private val imagePairs = listOf(
        listOf(R.id.ivcharacter, R.id.ivwelcome),
        listOf(R.id.ivsucceed, R.id.ivcharactertwo),
        listOf(R.id.ivchatbot, R.id.ivsera)
    )

    private var currentIndex = 0
    private val handler = Handler()
    private lateinit var mediaPlayer: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTutorialsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        hideAllImages()

        binding.btnskip.setOnClickListener {
            val intent = Intent(this, choosecharacters::class.java)
            startActivity(intent)
        }

        mediaPlayer = MediaPlayer.create(this, R.raw.bacon_mp3_42110)
        mediaPlayer.isLooping = true
    }

    override fun onResume() {
        super.onResume()
        handler.postDelayed(imageRevealRunnable, IMAGE_REVEAL_DELAY_MS)
        mediaPlayer.start()
    }

    override fun onPause() {
        super.onPause()
        handler.removeCallbacksAndMessages(null)
        mediaPlayer.pause()
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer.release()
    }

    private fun hideAllImages() {
        for (imagePair in imagePairs) {
            for (imageId in imagePair) {
                val imageView = findViewById<ImageView>(imageId)
                imageView.visibility = View.GONE
            }
        }
    }

    private val imageRevealRunnable: Runnable = object : Runnable {
        override fun run() {
            for (imageId in imagePairs[currentIndex]) {
                val imageView = findViewById<ImageView>(imageId)
                imageView.visibility = View.VISIBLE
            }

            currentIndex = (currentIndex + 1) % imagePairs.size

            if (currentIndex == 0) {
                handler.postDelayed({
                    hideAllImages()
                    handler.postDelayed(this, IMAGE_REVEAL_DELAY_MS)
                }, IMAGE_REVEAL_DELAY_MS)
            } else {
                handler.postDelayed(this, IMAGE_REVEAL_DELAY_MS)
            }
        }
    }

    companion object {
        private const val IMAGE_REVEAL_DELAY_MS = 2000L // Delay for revealing each image
    }
}