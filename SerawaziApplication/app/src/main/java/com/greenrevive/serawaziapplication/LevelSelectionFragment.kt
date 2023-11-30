package com.greenrevive.serawaziapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.greenrevive.serawaziapplication.databinding.FragmentLevelSelectionBinding
import com.greenrevive.serawaziapplication.ui.LevelTwoActivity

class LevelSelectionFragment : Fragment() {
    var binding: FragmentLevelSelectionBinding? = null
    private lateinit var mediaPlayer: MediaPlayer

    @SuppressLint("SuspiciousIndentation")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLevelSelectionBinding.inflate(inflater, container, false)
        return binding?.root


    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initializeMediaPlayer()

        binding?.imglevel1?.setOnClickListener {
            playLevelOne()
        }

        binding?.tolife?.setOnClickListener {
            playLevelTwo()
        }
    }

    private fun initializeMediaPlayer() {
        mediaPlayer = MediaPlayer.create(
            requireContext(),
            R.raw.freeze_dance_for_kids_dance_music_for_kids_mp3_74824
        )
        mediaPlayer.isLooping = true
        mediaPlayer.start()
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer.release()
    }

    private fun playLevelOne() {
        mediaPlayer.stop()
        val intent = Intent(requireContext(), Levelpurple::class.java)
        startActivity(intent)
    }

    private fun playLevelTwo() {
        mediaPlayer.stop()
        val intent = Intent(requireContext(), LevelTwoActivity::class.java)
        startActivity(intent)
    }
}




